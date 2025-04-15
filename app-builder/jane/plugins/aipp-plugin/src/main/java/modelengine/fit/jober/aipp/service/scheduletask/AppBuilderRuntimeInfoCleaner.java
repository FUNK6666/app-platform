/*---------------------------------------------------------------------------------------------
 *  Copyright (c) 2025 Huawei Technologies Co., Ltd. All rights reserved.
 *  This file is a part of the ModelEngine Project.
 *  Licensed under the MIT License. See License.txt in the project root for license information.
 *--------------------------------------------------------------------------------------------*/

package modelengine.fit.jober.aipp.service.scheduletask;

import modelengine.fit.jober.aipp.repository.AppBuilderRuntimeInfoRepository;
import modelengine.fitframework.annotation.Component;
import modelengine.fitframework.log.Logger;

import java.util.List;

/**
 * AppBuilderRuntimeInfo数据库表清理任务
 *
 * @author 杨祥宇
 * @since 2025-04-15
 */
@Component
public class AppBuilderRuntimeInfoCleaner {
    private static final Logger log = Logger.get(AppBuilderRuntimeInfoCleaner.class);

    private final AppBuilderRuntimeInfoRepository runtimeInfoRepo;

    public AppBuilderRuntimeInfoCleaner(AppBuilderRuntimeInfoRepository runtimeInfoRepo) {
        this.runtimeInfoRepo = runtimeInfoRepo;
    }

    public void appBuilderRuntimeInfoCleaner(int ttl, int limit) {
        log.info("Start cleaning app builder runtime infos");
        try {
            while (true) {
                List<Long> expiredRuntimeInfoIds = runtimeInfoRepo.getExpiredRuntimeInfos(ttl, limit);
                if (expiredRuntimeInfoIds.isEmpty()) {
                    break;
                }
                runtimeInfoRepo.deleteRuntimeInfos(expiredRuntimeInfoIds);

            }
        } catch (Exception e) {
            log.error("cleaning app builder runtime infos failed, exception:", e);
        }
        log.info("Finish cleaning app builder runtime infos");
    }
}
