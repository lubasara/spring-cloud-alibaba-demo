package net.biancheng.c.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class SentineFlowLimitController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/testA")
    public String testA() {
        return "c语言中文网提醒您，服务访问成功------testA";
    }

    @GetMapping("/testB")
    public String testB() {
        return "c语言中文网提醒您，服务访问成功------testB";
    }

    /**
     * 通过 Sentinel 控制台定义流控规则
     *
     */
    @GetMapping("/testD")
    @SentinelResource(value = "testD-resource", blockHandler = "blockHandlerTestD") //通过注解定义资源
    public String testD() {
        log.info("c语言中文网提醒您，服务访问成功------testD：" + serverPort);
        return "c语言中文网提醒您，服务访问成功------testD：" + serverPort;
    }
    /**
     * 限流之后的逻辑
     * @param exception
     * @return
     */
    public String blockHandlerTestD(BlockException exception) {
        log.info(Thread.currentThread().getName() + "c语言中文网提醒您，TestD服务访问失败! 您已被限流，请稍后重试");
        return "c语言中文网提醒您，TestD服务访问失败! 您已被限流，请稍后重试";
    }

}
