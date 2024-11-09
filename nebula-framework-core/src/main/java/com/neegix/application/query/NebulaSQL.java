package com.neegix.application.query;

import lombok.Setter;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA (Community Edition)
 * Thank you to JetBrains for their contributions to the vast number of developers
 *
 * @Author: kushu001
 * @Date: 2024/10/23/16:39
 * @Description:
 */
public class NebulaSQL {
    @Setter
    private boolean distinct;
    private final List<WhereGroups> whereClauses;
    private List<String> groupByClauses;
    private List<OrderBy> orderByClauses;

    private List<String> havingClauses;
    @Setter
    private Pager pager;

    public NebulaSQL() {
        whereClauses = new ArrayList<>();
    }

    public NebulaSQL setPager(int currentPage, int pageSize){
        this.pager = new Pager(currentPage, pageSize);
        return this;
    }

    public void clear() {
        whereClauses.clear();
        groupByClauses.clear();
        orderByClauses.clear();
        havingClauses.clear();
        pager = null;
        distinct = false;
    }
    public NebulaSQL setGroupByClauses(String... columns) {
        groupByClauses = new ArrayList<>(List.of(columns));
        return this;
    }

    // 添加链式调用的 orderBy 方法
    public NebulaSQL orderBy(String column, EnumOrder enumOrder) {
        if (orderByClauses == null) {
            orderByClauses = new ArrayList<>(); // 确保orderByClauses不为null
        }
        orderByClauses.add(new OrderBy(column, enumOrder));
        return this;
    }

    // 重载方法，允许链式调用时不指定排序方向
    public NebulaSQL orderBy(String column) {
        if (orderByClauses == null) {
            orderByClauses = new ArrayList<>(); // 确保orderByClauses不为null
        }
        orderByClauses.add(new OrderBy(column, EnumOrder.ASC));
        return this;
    }

    // 修改后的 createWhereGroups 方法
    public  <T extends WhereGroups> T createWhereGroups(Class<T> clazz) {
        try {
            T whereGroups = clazz.getDeclaredConstructor().newInstance();
            if (whereClauses.isEmpty() || !whereClauses.contains(whereGroups)) {
                whereClauses.add(whereGroups);
            }
            return whereGroups;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Failed to instantiate class: " + clazz.getName(), e);
        } catch (InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public <T extends WhereGroups> T orWhereGroups(Class<T> clazz) {
        try {
            T whereGroups = clazz.getDeclaredConstructor().newInstance();
            whereClauses.add(whereGroups);
            return whereGroups;
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException("Failed to instantiate class: " + clazz.getName(), e);
        } catch (InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
