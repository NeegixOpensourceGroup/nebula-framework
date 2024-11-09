package com.neegix.utils;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/11/06/11:35
 * @Description:
 */
public class StringUtils {
    /**
     * 将下划线命名转换为驼峰命名
     * @param input 下划线命名的字符串
     * @return 驼峰命名的字符串
     */
    public static String toCamelCase(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        StringBuilder result = new StringBuilder();
        boolean nextUpperCase = false;

        for (char c : input.toCharArray()) {
            if (c == '_') {
                nextUpperCase = true;
            } else if (nextUpperCase) {
                result.append(Character.toUpperCase(c));
                nextUpperCase = false;
            } else {
                result.append(Character.toLowerCase(c));
            }
        }

        return result.toString();
    }

    /**
     * 将带有前缀的表名转换为驼峰命名的类名
     * @param tableName 表名
     * @param tablePrefix 表前缀
     * @return 驼峰命名的类名
     */
    public static String toCamelCaseClassName(String tableName, String tablePrefix) {
        if (tableName == null || tableName.isEmpty()) {
            return tableName;
        }

        // 去掉表前缀
        if (tablePrefix != null && !tablePrefix.isEmpty() && tableName.startsWith(tablePrefix)) {
            tableName = tableName.substring(tablePrefix.length());
        }

        // 转换为驼峰命名
        String camelCaseName = toCamelCase(tableName);

        // 确保第一个字母大写
        if (!camelCaseName.isEmpty()) {
            camelCaseName = Character.toUpperCase(camelCaseName.charAt(0)) + camelCaseName.substring(1);
        }

        return camelCaseName;
    }

    /**
     * 将字符串的首字母转换为小写。
     *
     * @param str 需要处理的字符串
     * @return 首字母小写后的字符串
     */
    public static String lowerCaseFirstLetter(String str) {
        // 如果输入字符串为 null 或空字符串，直接返回原字符串
        if (str == null || str.isEmpty()) {
            return str;
        }

        // 获取字符串的第一个字符
        char firstChar = str.charAt(0);

        // 将第一个字符转换为小写
        char lowerCaseFirstChar = Character.toLowerCase(firstChar);

        // 获取从第二个字符到最后的所有字符
        String restOfTheString = str.substring(1);

        // 将转换后的首字母与剩余部分拼接起来
        return lowerCaseFirstChar + restOfTheString;
    }
}
