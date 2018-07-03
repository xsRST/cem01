package com.shsxt.crm.Task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * 定时任务
 * @author 殇丶无求
 */
@Component
public class CrmTask {

    /**
     * 每个1秒执行一次
     */
    @Scheduled(cron = "*/1 * * * * ?")
    public void task(){

    }
}
