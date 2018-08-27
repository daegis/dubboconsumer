package cn.aegisa.dubboconsumer.web;

import cn.aegisa.dubbodemo.api.TestApi;
import com.alibaba.dubbo.config.annotation.Reference;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Using IntelliJ IDEA.
 *
 * @author XIANYINGDA at 8/27/2018 11:33 AM
 */
@RestController
@Slf4j
@RequestMapping("/test")
public class TestController {

    @Reference(check = false, retries = 0)
    private TestApi testApi;

    @GetMapping("/time")
    public String test() {
        log.info("页面访问请求");
        System.out.println(testApi);
        if (testApi != null) {
            return testApi.getTime();
        }
        return "no server";
    }
}
