<#assign currentTime = .now>
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >

<!--
    This file is auto-generated by nebula-framework-generator.
    The auto-generation plugin was developed using IntelliJ IDEA Community Edition.
    Thanks to JetBrains for their outstanding contributions to the developer community.

    The code generated by this tool is owned by the user of the tool.
    The tool itself is copyrighted by ${templateTable.copyright}.

    @author ${templateTable.copyright}
    @version ${templateTable.version}
    @since ${currentTime?string("yyyy-MM-dd HH:mm:ss")}
-->

<mapper namespace="${templateTable.packageName}.${templateTable.javaTableName[0]?lower_case+templateTable.javaTableName[1..]}.infrastructure.repository.mapper.${templateTable.javaTableName}Mapper">
    <resultMap id="${templateTable.javaTableName}ResultMap" type="${templateTable.packageName}.${templateTable.javaTableName[0]?lower_case+templateTable.javaTableName[1..]}.infrastructure.repository.dataobject.${templateTable.javaTableName}DO">
        <#if templateTable.columns?exists>
            <#list templateTable.columns as column>
                <#if column.isPrimaryKey??>
        <id column="${column.sqlName}" property="${column.javaName}" />
                <#else>
        <result column="${column.sqlName}" property="${column.javaName}" />
                </#if>
            </#list>
        </#if>
    </resultMap>
    <sql id="wheres">
        <where>
            <if test="whereClauses != null and whereClauses.size() > 0">
                <foreach collection="whereClauses" item="group" separator=" OR ">
                    <if test="group.wheres != null and group.wheres.size() > 0">
                        <trim prefix="(" suffix=")" prefixOverrides="AND ">
                            <foreach collection="group.wheres" item="where" separator=" AND ">
                                <choose>
                                    <when test="where.enumOperator == @com.neegix.application.query.EnumOperator@EQUAL">
                                        ${r"${where.column}"} = ${r"#{where.value}"}
                                    </when>
                                    <when test="where.enumOperator == @com.neegix.application.query.EnumOperator@NOT_EQUAL">
                                        ${r"${where.column}"} != ${r"#{where.value}"}
                                    </when>
                                    <when test="where.enumOperator == @com.neegix.application.query.EnumOperator@GREATER_THAN">
                                        ${r"${where.column}"} &gt; ${r"#{where.value}"}
                                    </when>
                                    <when test="where.enumOperator == @com.neegix.application.query.EnumOperator@LESS_THAN">
                                        ${r"${where.column}"} &lt; ${r"#{where.value}"}
                                    </when>
                                    <when test="where.enumOperator == @com.neegix.application.query.EnumOperator@GREATER_EQUAL_THAN">
                                        ${r"${where.column}"} &gt;= ${r"#{where.value}"}
                                    </when>
                                    <when test="where.enumOperator == @com.neegix.application.query.EnumOperator@LESS_EQUAL_THAN">
                                        ${r"${where.column}"} &lt;= ${r"#{where.value}"}
                                    </when>
                                    <when test="where.enumOperator == @com.neegix.application.query.EnumOperator@LIKE and where.prefix and where.suffix">
                                        ${r"${where.column}"} LIKE CONCAT('%', ${r"#{where.value}"}, '%')
                                    </when>
                                    <when test="where.enumOperator == @com.neegix.application.query.EnumOperator@LIKE and where.prefix and !where.suffix">
                                        ${r"${where.column}"} LIKE CONCAT('%', ${r"#{where.value}"})
                                    </when>
                                    <when test="where.enumOperator == @com.neegix.application.query.EnumOperator@LIKE and !where.prefix and where.suffix">
                                        ${r"${where.column}"} LIKE CONCAT(${r"#{where.value}"}, '%')
                                    </when>
                                    <when test="where.enumOperator == @com.neegix.application.query.EnumOperator@LIKE and !where.prefix and !where.suffix">
                                        ${r"${where.column}"} LIKE ${r"#{where.value}"}
                                    </when>

                                    <when test="where.enumOperator == @com.neegix.application.query.EnumOperator@NOT_LIKE and where.prefix and where.suffix">
                                        ${r"${where.column}"} NOT LIKE CONCAT('%', ${r"#{where.value}"}, '%')
                                    </when>
                                    <when test="where.enumOperator == @com.neegix.application.query.EnumOperator@NOT_LIKE and where.prefix and !where.suffix">
                                        ${r"${where.column}"} NOT LIKE CONCAT('%', ${r"#{where.value}"})
                                    </when>
                                    <when test="where.enumOperator == @com.neegix.application.query.EnumOperator@NOT_LIKE and !where.prefix and where.suffix">
                                        ${r"${where.column}"} NOT LIKE CONCAT(${r"#{where.value}"}, '%')
                                    </when>
                                    <when test="where.enumOperator == @com.neegix.application.query.EnumOperator@NOT_LIKE and !where.prefix and !where.suffix">
                                        ${r"${where.column}"} NOT LIKE ${r"#{where.value}"}
                                    </when>
                                    <when test="where.enumOperator == @com.neegix.application.query.EnumOperator@IN">
                                       ${r"${where.column}"} IN
                                        <foreach collection="where.value" item="item" open="(" separator="," close=")">
                                            ${r"#{item}"}
                                        </foreach>
                                    </when>
                                    <when test="where.enumOperator == @com.neegix.application.query.EnumOperator@NOT_IN">
                                        ${r"${where.column}"} NOT IN
                                        <foreach collection="where.value" item="item" open="(" separator="," close=")">
                                            ${r"#{item}"}
                                        </foreach>
                                    </when>
                                    <when test="where.enumOperator == @com.neegix.application.query.EnumOperator@IS_NULL">
                                        ${r"${where.column}"} IS NULL
                                    </when>
                                    <when test="where.enumOperator == @com.neegix.application.query.EnumOperator@IS_NOT_NULL">
                                        ${r"${where.column}"} IS NOT NULL
                                    </when>
                                    <!-- 添加其他操作符的处理 -->
                                </choose>
                            </foreach>
                        </trim>
                    </if>
                </foreach>
            </if>
        </where>
    </sql>
  <sql id="columns">
    <#if templateTable.columns?exists>
    <#list templateTable.columns as column>${column.sqlName}<#if column_has_next>,</#if></#list>
    </#if>
  </sql>
    <!-- 查询字典项数量 -->
    <select id="selectCount" resultType="java.lang.Long">
        select count(1) from ${templateTable.sqlTableName}
        <include refid="wheres" />
        <if test="groupByClauses != null and groupByClauses.size() > 0">
            GROUP BY
            <foreach collection="groupByClauses" item="groupBy" separator=", ">
                ${r"${groupBy}"}
            </foreach>
        </if>
        <if test="havingClauses != null and havingClauses.size() > 0">
            HAVING
            <foreach collection="havingClauses" item="having" separator=" AND ">
                ${r"${having}"}
            </foreach>
        </if>
    </select>

    <select id="selectOne" resultMap="${templateTable.javaTableName}ResultMap">
        SELECT
        <if test="distinct">DISTINCT</if>
        <choose>
            <when test="groupByClauses != null and groupByClauses.size() > 0">
                <foreach collection="groupByClauses" item="groupBy" separator=", ">
                    ${r"${groupBy}"}
                </foreach>
            </when>
            <otherwise>
                <include refid="columns" />
            </otherwise>
        </choose>
        FROM ${templateTable.sqlTableName}
        <include refid="wheres" />
        <if test="groupByClauses != null and groupByClauses.size() > 0">
            GROUP BY
            <foreach collection="groupByClauses" item="groupBy" separator=", ">
                ${r"${groupBy}"}
            </foreach>
        </if>
        <if test="havingClauses != null and havingClauses.size() > 0">
            HAVING
            <foreach collection="havingClauses" item="having" separator=" AND ">
                ${r"${having}"}
            </foreach>
        </if>
        <if test="orderByClauses != null and !orderByClauses.isEmpty()">
            ORDER BY
            <foreach collection="orderByClauses" item="orderBy" separator=", ">
                ${r"${orderBy.column}"} ${r"${orderBy.enumOrder}"}
            </foreach>
        </if>
        <if test="pager != null">
            LIMIT ${r"#{pager.offset}"}, ${r"#{pager.pageSize}"}
        </if>
    </select>

    <select id="selectList" resultMap="${templateTable.javaTableName}ResultMap">
        SELECT
        <if test="distinct">DISTINCT</if>
        <choose>
            <when test="groupByClauses != null and groupByClauses.size() > 0">
                <foreach collection="groupByClauses" item="groupBy" separator=", ">
                    ${r"${groupBy}"}
                </foreach>
            </when>
            <otherwise>
                <include refid="columns" />
            </otherwise>
        </choose>
        FROM ${templateTable.sqlTableName}
        <include refid="wheres" />
        <if test="groupByClauses != null and groupByClauses.size() > 0">
            GROUP BY
            <foreach collection="groupByClauses" item="groupBy" separator=", ">
                ${r"${groupBy}"}
            </foreach>
        </if>
        <if test="havingClauses != null and havingClauses.size() > 0">
            HAVING
            <foreach collection="havingClauses" item="having" separator=" AND ">
                ${r"${having}"}
            </foreach>
        </if>
        <if test="orderByClauses != null and !orderByClauses.isEmpty()">
            ORDER BY
            <foreach collection="orderByClauses" item="orderBy" separator=", ">
                ${r"${orderBy.column}"} ${r"${orderBy.enumOrder}"}
            </foreach>
        </if>
        <if test="pager != null">
            LIMIT ${r"#{pager.offset}"}, ${r"#{pager.pageSize}"}
        </if>
    </select>

    <!-- 根据Id查询字典组 -->
    <select id="selectByPrimaryKey" resultMap="${templateTable.javaTableName}ResultMap">
        select <include refid="columns" /> from ${templateTable.sqlTableName}  where id=${r"#{id,jdbcType=BIGINT}"}
    </select>

    <!--新增字典组-->
    <insert id="insert" parameterType="${templateTable.packageName}.${templateTable.javaTableName[0]?lower_case+templateTable.javaTableName[1..]}.infrastructure.repository.dataobject.${templateTable.javaTableName}DO">
      insert into ${templateTable.sqlTableName}
      <trim prefix="(" suffix=")" suffixOverrides=",">
        <#if templateTable.columns?exists>
            <#list templateTable.columns as column>
        <if test="${column.javaName} != null">${column.sqlName},</if>
            </#list>
        </#if>
      </trim>
      <trim prefix="VALUES (" suffix=")" suffixOverrides=",">
        <#if templateTable.columns?exists>
            <#list templateTable.columns as column>
        <if test="${column.javaName} != null">${r"#{"}${column.javaName}},</if>
            </#list>
        </#if>
      </trim>
    </insert>


    <!--更新字典组-->
    <update id="updateByPrimaryKey" parameterType="${templateTable.packageName}.${templateTable.javaTableName[0]?lower_case+templateTable.javaTableName[1..]}.infrastructure.repository.dataobject.${templateTable.javaTableName}DO">
        update ${templateTable.sqlTableName}
          <set>
            <#if templateTable.columns?exists>
                <#list templateTable.columns as column>
                <#if !column.isPrimaryKey()>
            <if test="${column.javaName} != null">
              ${column.sqlName} = ${r"#{"}${column.javaName}},
            </if>
                </#if>
                </#list>
            </#if>
          </set>
          where id = ${r"#{id}"}
    </update>

    <!--批量删除字典项-->
    <delete id="deleteByPrimaryKeys">
        delete from ${templateTable.sqlTableName}
        <where>
            id in
            <foreach collection="list" item="id" index="index" open="(" close=")" separator=",">
                ${r"#{id, jdbcType=BIGINT}"}
            </foreach>
        </where>
    </delete>

</mapper>