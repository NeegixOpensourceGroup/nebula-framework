package com.neegix.base;

import com.neegix.application.query.NebulaSQL;

import java.io.Serializable;
import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/08/28/16:33
 * @Description:
 */
public interface BaseMapper<T, PK extends Serializable> {

     T selectByPrimaryKey(PK id);

     List<T> selectAll();

     T selectOne(NebulaSQL nebulaSQL);

     long selectCount(NebulaSQL nebulaSQL);

     List<T> selectList(NebulaSQL nebulaSQL);

     void insert(T t);

     void updateByPrimaryKey(T t);

     void delete(NebulaSQL nebulaSQL);

     void deleteByPrimaryKey(PK id);

     void deleteByPrimaryKeys(List<PK> ids);
}
