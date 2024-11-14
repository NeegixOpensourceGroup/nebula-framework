<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >
<mapper namespace="${templateTable.packageName}.${templateTable.javaTableName[0]?lower_case+templateTable.javaTableName[1..]}.infrastructure.repository.mapper.customized.${templateTable.javaTableName}CustomizedMapper">

    <!-- 根据Ids查询数量 -->
    <select id="selectCountByIds" resultType="java.lang.Integer">
        select count(1) from ${templateTable.sqlTableName}
        <where>
            id in
            <foreach collection="list" item="id" index="index" open="(" close=")" separator=",">
                ${r"#{id, jdbcType=BIGINT}"}
            </foreach>
        </where>
    </select>

</mapper>