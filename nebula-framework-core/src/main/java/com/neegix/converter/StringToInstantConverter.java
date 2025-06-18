package com.neegix.converter;

import org.springframework.core.convert.converter.Converter;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/11/27/16:55
 * @Description:
 */
//@Component
public class StringToInstantConverter implements Converter<String, Instant> {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSX");

    @Override
    public Instant convert(String source) {
        try {
            // 解析字符串为 ZonedDateTime，指定时区为 UTC
            ZonedDateTime zonedDateTime = ZonedDateTime.parse(source, FORMATTER.withZone(ZoneId.of("UTC")));

            // 将 ZonedDateTime 转换为 Instant
            Instant instant = zonedDateTime.toInstant();

            // 减去时区的时间差（例如，减去8小时）
            ZoneId targetZone = ZoneId.of("Asia/Shanghai");
            long hoursOffset = targetZone.getRules().getOffset(zonedDateTime.toLocalDateTime()).getTotalSeconds() / 3600;

            return instant.minusSeconds(hoursOffset * 3600);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format: " + source, e);
        }
    }
}