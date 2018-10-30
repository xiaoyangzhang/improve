package com.dc.improve;

import com.dc.improve.config.HelloProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author zhangxiaoyang
 */
@SpringBootApplication
@EnableSwagger2
public class ImproveApplication {


    public static void main(String[] args) {
        SpringApplication.run(ImproveApplication.class);

    }

}