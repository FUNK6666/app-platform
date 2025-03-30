/*---------------------------------------------------------------------------------------------
 *  Copyright (c) 2025 Huawei Technologies Co., Ltd. All rights reserved.
 *  This file is a part of the ModelEngine Project.
 *  Licensed under the MIT License. See License.txt in the project root for license information.
 *--------------------------------------------------------------------------------------------*/


package modelengine.fit.jade.waterflow;

import modelengine.fit.jane.common.entity.OperationContext;
import modelengine.fit.jober.entity.FlowInstanceResult;
import modelengine.fit.waterflow.entity.FlowStartInfo;

import modelengine.fit.waterflow.entity.JoberErrorInfo;
import modelengine.fitframework.annotation.Genericable;

import java.util.Map;

/**
 * 流程1:1运行时流程实例相关服务
 *
 * @author 杨祥宇
 * @since 2023/12/11
 */
public interface FlowInstanceService {
    /**
     * 根据流程定义id启动流程实例
     *
     * @param flowDefinitionId 流程定义id
     * @param startInfo 流程启动参数
     * @param context 操作人上下文信息
     * @return 流程实例id标识
     */
    @Genericable(id = "4026db8328a04abe8c2308e993a40499")
    FlowInstanceResult startFlow(String flowDefinitionId, FlowStartInfo startInfo,
            OperationContext context);

    /**
     * 根据流程定义id恢复流程执行
     * 流程1:1运行时使用trace id进行恢复
     * request key为businessData和operator，后续可以补充passData
     *
     * @param flowDefinitionId 流程定义id
     * @param instanceId 流程实例id
     * @param request 变更的上下文业务数据列集合
     * @param context 操作人上下文信息
     */
    @Genericable(id = "9bcdd0ee456f45838900acb2c39ced2b")
    void resumeFlow(String flowDefinitionId, String instanceId, Map<String, Object> request, OperationContext context);

    /**
     * 根据traceId终止流程
     *
     * @param flowDefinitionId 流程定义id
     * @param instanceId 流程实例id
     * @param filter 与业务相关的过滤条件，停止满足条件的部分context，目前不支持
     * @param operationContext 操作人上下文信息
     */
    @Genericable(id = "lwwza8xmojxhf0l0wiznpfikvok8pvd0")
    void terminateFlows(String flowDefinitionId, String instanceId, Map<String, Object> filter,
            OperationContext operationContext);

    /**
     * 恢复指定数据上下文的异步任务
     *
     * @param flowDataId 流程运行数据唯一标识
     * @param businessData 业务执行返回的数据
     * @param operationContext 操作人，为null则默认为前一个操作人
     */
    @Genericable(id = "ac8d6b7590b747dca41bd3aeeb45db59")
    void resumeAsyncJob(String flowDataId, Map<String, Object> businessData, OperationContext operationContext);

    /**
     * 指定数据上下文的异步jober异常信息回传
     *
     * @param flowDataId 流程运行数据唯一标识
     * @param errorInfo 错误信息
     * @param operationContext 操作人，为null则默认为前一个操作人
     */
    @Genericable(id = "40f3acba4f904e8f98d02a0858ebdaf3")
    void failAsyncJob(String flowDataId, JoberErrorInfo errorInfo, OperationContext operationContext);
}
