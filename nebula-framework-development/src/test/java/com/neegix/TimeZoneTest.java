package com.neegix;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/11/29/11:40
 * @Description:
 */
public class TimeZoneTest {
    public static void main(String[] args) {
        // 给定的 Instant 对象
        Instant instant = Instant.parse("2024-11-27T16:00:00Z");

        // 转换为 Timestamp
        Timestamp stamp = from(instant);

        // 输出 Timestamp 对象（默认显示为本地时间）
        System.out.println("Default Timestamp: " + stamp);

        // 显式转换为 UTC 时间
        ZonedDateTime utcDateTime = ZonedDateTime.ofInstant(instant, ZoneId.of("UTC"));
        System.out.println("UTC Timestamp: " + utcDateTime);

        // 显式转换为本地时间（假设本地时区是 UTC+8）
        ZonedDateTime localDateTime = ZonedDateTime.ofInstant(instant, ZoneId.systemDefault());
        System.out.println("Local Timestamp: " + localDateTime);
    }

    public static Timestamp from(Instant instant) {
        try {
            Timestamp stamp = new Timestamp(instant.getEpochSecond() * 1000L);
            stamp.setNanos(instant.getNano());
            return stamp;
        } catch (ArithmeticException ex) {
            throw new IllegalArgumentException(ex);
        }
    }
}
