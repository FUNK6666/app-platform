/*---------------------------------------------------------------------------------------------
 *  Copyright (c) 2025 Huawei Technologies Co., Ltd. All rights reserved.
 *  This file is a part of the ModelEngine Project.
 *  Licensed under the MIT License. See License.txt in the project root for license information.
 *--------------------------------------------------------------------------------------------*/

package modelengine.fit.waterflow.domain.validators.rules.nodes;

import modelengine.fit.jade.waterflow.exceptions.WaterflowParamException;
import modelengine.fit.waterflow.domain.definitions.nodes.FlowNode;
import modelengine.fitframework.inspection.Validation;

/**
 * 开始节点校验规则
 *
 * @author 高诗意
 * @since 1.0
 */
public class StartNodeRule implements NodeRule {
    /**
     * 校验不同流程节点类型的合法性
     * 当校验不通过时，抛出运行时异常{@link WaterflowParamException}
     *
     * @param flowNode 流程节点
     */
    @Override
    public void apply(FlowNode flowNode) {
        Validation.same(flowNode.getEvents().size(), EXPECT_EVENT_SIZE, exception("start node event size"));
        validateNull(flowNode.getJober(), "start node jober should be null");
        validateTriggerMode(flowNode, "start node trigger mode");
    }
}
