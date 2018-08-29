package com.dc.improve;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhangxiaoyang
 */
@SpringBootApplication
public class ImproveApplication {


    public static void main(String[] args) {
//        new SpringApplication().addListeners((ApplicationListener<ApplicationEvent>) applicationEvent -> {
//            long timestamp = applicationEvent.getTimestamp();
//            System.out.println("应用监听器timestamp="+timestamp);
//        });
        SpringApplication.run(ImproveApplication.class);

    }

}