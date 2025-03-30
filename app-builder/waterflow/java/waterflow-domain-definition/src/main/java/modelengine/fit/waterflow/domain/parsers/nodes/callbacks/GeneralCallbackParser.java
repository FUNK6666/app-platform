/*---------------------------------------------------------------------------------------------
 *  Copyright (c) 2025 Huawei Technologies Co., Ltd. All rights reserved.
 *  This file is a part of the ModelEngine Project.
 *  Licensed under the MIT License. See License.txt in the project root for license information.
 *--------------------------------------------------------------------------------------------*/

package modelengine.fit.waterflow.domain.parsers.nodes.callbacks;

import modelengine.fit.waterflow.domain.definitions.nodes.callbacks.FlowCallback;
import modelengine.fit.waterflow.domain.definitions.nodes.callbacks.FlowGeneralCallback;
import modelengine.fit.waterflow.domain.enums.FlowCallbackType;
import modelengine.fit.waterflow.domain.parsers.FlowGraphData;

/**
 * 通用型回调函数解析类
 *
 * @author 李哲峰
 * @since 1.0
 */
public class GeneralCallbackParser implements CallbackParser {
    /**
     * 按照回调函数规则解析回调函数
     *
     * @param flowGraphData {@link FlowGraphData} 流程json操作封装对象
     * @param nodeIndex 当前节点索引
     * @return 流程节点回调函数对象
     */
    @Override
    public FlowCallback parseCallback(FlowGraphData flowGraphData, int nodeIndex) {
        FlowCallback flowCallback = new FlowGeneralCallback();
        flowCallback.setType(FlowCallbackType.GENERAL_CALLBACK);
        commonParse(flowCallback, flowGraphData, nodeIndex);
        flowCallback.setFilteredKeys(flowGraphData.getNodeCallbackFilteredKeys(nodeIndex));
        flowCallback.setFitables(flowGraphData.getNodeCallbackFitables(nodeIndex));
        return flowCallback;
    }
}
