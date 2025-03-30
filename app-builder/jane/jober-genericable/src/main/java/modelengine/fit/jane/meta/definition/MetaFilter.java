/*---------------------------------------------------------------------------------------------
 *  Copyright (c) 2025 Huawei Technologies Co., Ltd. All rights reserved.
 *  This file is a part of the ModelEngine Project.
 *  Licensed under the MIT License. See License.txt in the project root for license information.
 *--------------------------------------------------------------------------------------------*/

package modelengine.fit.jane.meta.definition;

import static modelengine.fitframework.util.ObjectUtils.nullIf;

import java.util.Collections;
import java.util.List;

/**
 * 查询Meta所用Filter。
 *
 * @author 陈镕希
 * @since 2023-12-08
 */
public class MetaFilter {
    private List<String> ids;

    private List<String> names;

    private List<String> categories;

    private List<String> templateIds;

    private List<String> creators;

    private List<String> orderBys;

    public MetaFilter() {
        this(null, null, null, null, null, null);
    }

    public MetaFilter(List<String> ids, List<String> names, List<String> categories, List<String> templateIds,
            List<String> creators, List<String> orderBys) {
        this.ids = nullIf(ids, Collections.emptyList());
        this.names = nullIf(names, Collections.emptyList());
        this.categories = nullIf(categories, Collections.emptyList());
        this.templateIds = nullIf(templateIds, Collections.emptyList());
        this.creators = nullIf(creators, Collections.emptyList());
        this.orderBys = nullIf(orderBys, Collections.emptyList());
    }

    public List<String> getIds() {
        return ids;
    }

    public void setIds(List<String> ids) {
        this.ids = nullIf(ids, Collections.emptyList());
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = nullIf(names, Collections.emptyList());
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = nullIf(categories, Collections.emptyList());
    }

    public List<String> getTemplateIds() {
        return templateIds;
    }

    public void setTemplateIds(List<String> templateIds) {
        this.templateIds = nullIf(templateIds, Collections.emptyList());
    }

    public List<String> getCreators() {
        return creators;
    }

    public void setCreators(List<String> creators) {
        this.creators = nullIf(creators, Collections.emptyList());
    }

    public List<String> getOrderBys() {
        return orderBys;
    }

    public void setOrderBys(List<String> orderBys) {
        this.orderBys = orderBys;
    }
}
