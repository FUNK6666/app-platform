/*
 * Copyright (c) 2025 Huawei Technologies Co., Ltd. All rights reserved.
 * This file is a part of the ModelEngine Project.
 * Licensed under the MIT License. See License.txt in the project root for license information.
 */

package modelengine.fit.task_new.mapper;

import modelengine.fit.task_new.condition.MetaInstanceCondition;
import modelengine.fit.task_new.po.MetaInstancePo;

import java.util.List;

/**
 * Meta 实例数据库 Mapper 类
 *
 * @author 邬涨财
 * @since 2025-03-31
 */
public interface MetaInstanceMapper {
    /**
     * 插入一条 MetaInstance 数据对象。
     *
     * @param instancePo 表示需要插入的 {@link MetaInstancePo}。
     */
    void insertOne(MetaInstancePo instancePo);

    /**
     * 更新一条 MetaInstance 数据对象。
     *
     * @param instancePo 表示需要更新的 {@link MetaInstancePo}。
     */
    void updateOne(MetaInstancePo instancePo);

    /**
     * 删除 MetaInstance 列表。
     *
     * @param ids 表示需要删除的实例 id 的 {@link List}{@code <}{@link String}{@code >}。
     */
    void delete(List<String> ids);

    /**
     * 查找 MetaInstance 列表
     *
     * @param cond 表示需要查找的 {@link MetaInstanceCondition}。
     * @return 表示查找到的 {@link List}{@code <}{@link MetaInstancePo}{@code >}。
     */
    List<MetaInstancePo> select(MetaInstanceCondition cond);

    /**
     * 统计 MetaInstance 个数
     *
     * @param cond 表示所要统计的条件的 {@link MetaInstanceCondition}。
     * @return 表示查询后的结果的 {@code long}
     */
    long count(MetaInstanceCondition cond);
}
