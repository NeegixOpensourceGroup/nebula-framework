package com.neegix.utils;

/**
 * 分布式ID生成器（雪花算法）
 * 支持两种使用方式：
 * 1. 静态方法直接调用：SnowFlake.nextId()
 * 2. 实例化后调用：new SnowFlake(datacenterId, workerId).nextId()
 */
public class SnowFlake {
    // 静态单例实例（默认datacenterId=1, workerId=1）
    private static final SnowFlake DEFAULT_INSTANCE = new SnowFlake(1, 1);

    // 常量定义
    private static final long DATACENTER_ID_BITS = 2L;
    private static final long WORKER_ID_BITS = 2L;
    private static final long SEQUENCE_BITS = 10L;

    // 位移计算
    private static final long WORKER_ID_SHIFT = SEQUENCE_BITS;
    private static final long DATACENTER_ID_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS;
    private static final long TIMESTAMP_LEFT_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS + DATACENTER_ID_BITS;

    // 起始时间戳（2021-01-01 08:00:00）
    private static final long TWEPOCH = 1609459200000L;

    // 序列号掩码
    private static final long SEQUENCE_MASK = ~(-1L << SEQUENCE_BITS);

    // 实例变量
    private final long datacenterId;
    private final long workerId;
    private long sequence = 0L;
    private long lastTimestamp = -1L;

    /**
     * 构造函数
     * @param datacenterId 数据中心ID (0-3)
     * @param workerId 工作节点ID (0-3)
     */
    public SnowFlake(long datacenterId, long workerId) {
        long maxDatacenterId = ~(-1L << DATACENTER_ID_BITS);
        long maxWorkerId = ~(-1L << WORKER_ID_BITS);

        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            throw new IllegalArgumentException(
                    String.format("Datacenter ID must be between 0 and %d", maxDatacenterId));
        }
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(
                    String.format("Worker ID must be between 0 and %d", maxWorkerId));
        }

        this.datacenterId = datacenterId;
        this.workerId = workerId;
    }

    /**
     * 静态方法：直接获取ID（使用默认实例）
     */
    public static long generateId() {
        return DEFAULT_INSTANCE.nextInstanceId();
    }

    /**
     * 实例方法：获取下一个ID
     */
    public synchronized long nextId() {
        return nextInstanceId();
    }

    /**
     * 实际的ID生成逻辑
     */
    private synchronized long nextInstanceId() {
        long timestamp = timeGen();

        if (timestamp < lastTimestamp) {
            throw new RuntimeException(
                    String.format("Clock moved backwards. Refusing to generate id for %d milliseconds",
                            lastTimestamp - timestamp));
        }

        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & SEQUENCE_MASK;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0L;
        }

        lastTimestamp = timestamp;

        return ((timestamp - TWEPOCH) << TIMESTAMP_LEFT_SHIFT)
                | (datacenterId << DATACENTER_ID_SHIFT)
                | (workerId << WORKER_ID_SHIFT)
                | sequence;
    }

    /**
     * 等待下一个毫秒时间戳
     */
    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    /**
     * 获取当前时间戳
     */
    private long timeGen() {
        return System.currentTimeMillis();
    }

    public static void main(String[] args) {
        // 静态方法调用
        System.out.println("Static method call:");
        for (int i = 0; i < 5; i++) {
            System.out.println(SnowFlake.generateId());
        }

        // 实例方法调用
        System.out.println("\nInstance method call:");
        SnowFlake snowFlake = new SnowFlake(2, 3);
        for (int i = 0; i < 5; i++) {
            System.out.println(snowFlake.nextId());
        }
    }
}