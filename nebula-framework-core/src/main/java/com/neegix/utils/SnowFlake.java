package com.neegix.utils;

/**
 * Created by IntelliJ IDEA
 *
 * @Author: kushu001
 * @Date: 2023/05/30/15:14
 * @Description:
 */
public class SnowFlake {
    private final long datacenterIdBits = 2L;
    private final long workerIdBits = 2L;

    private final long datacenterId;
    private final long workerId;
    private long sequence = 0L;
    private long lastTimestamp = -1L;

    public SnowFlake(long datacenterId, long workerId) {
        long maxDatacenterId = ~(-1L << datacenterIdBits);
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException("Datacenter ID can't be greater than " + maxDatacenterId + " or less than 0");
        }
        long maxWorkerId = ~(-1L << workerIdBits);
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException("Worker ID can't be greater than " + maxWorkerId + " or less than 0");
        }
        this.datacenterId = datacenterId;
        this.workerId = workerId;
    }

    public synchronized long nextId() {
        long timestamp = System.currentTimeMillis();
        if (timestamp < lastTimestamp) {
            throw new RuntimeException("Clock moved backwards. Refusing to generate id for " + (lastTimestamp - timestamp) + " milliseconds");
        }
        long sequenceBits = 10L;
        if (lastTimestamp == timestamp) {
            long sequenceMask = ~(-1L << sequenceBits);
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = waitNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0L;
        }
        lastTimestamp = timestamp;
        // 设置起始时间为2021/1/1 08:00:00（北京时间）
        long twepoch = 1609459200000L;
        long datacenterIdShift = sequenceBits + workerIdBits;
        long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;
        return ((timestamp - twepoch) << timestampLeftShift) |
                (datacenterId << datacenterIdShift) |
                (workerId << sequenceBits) |
                sequence;
    }

    private long waitNextMillis(long lastTimestamp) {
        long timestamp = System.currentTimeMillis();
        while (timestamp <= lastTimestamp) {
            timestamp = System.currentTimeMillis();
        }
        return timestamp;
    }

    public static void main(String[] args) {

        SnowFlake idGenerator = new SnowFlake(1, 1);
        for (int i = 0; i < 18; i++) {
            long id = idGenerator.nextId();
            System.out.println(id);
        }
    }
}
