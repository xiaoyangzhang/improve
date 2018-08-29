package com.dc.improve.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: improve
 * @description:
 * @author: zhangxiaoyang
 * @date: 2018/8/14 下午12:08
 **/
@Configuration
@EnableSwagger2
public class Swagger2Configuration {

    @Value("${spring.application.name}")
    private String appName;


    //不支持IE浏览器
    @Bean
    public Docket buildDocket() {
        ParameterBuilder plateformParameterBuilder = new ParameterBuilder();
//        plateformParameterBuilder.name("platform").parameterType("header")
//                                 .defaultValue("10").description("平台").modelRef(new ModelRef("string"))
//                                 .required(false).build();
//        ParameterBuilder languageParameterBuilder = new ParameterBuilder();
//        languageParameterBuilder.name("language").parameterType("header")
//                                .defaultValue("zh").description("语言：中文（zh） 英文（en）").modelRef(new ModelRef("string"))
//                                .required(false).build();
//        ParameterBuilder tokenParameterBuilder = new ParameterBuilder();
//        tokenParameterBuilder.name("token").parameterType("header")
//                             .defaultValue("").description("用户token,登录后接口必传").modelRef(new ModelRef("string"))
//                             .required(false).build();
        List<Parameter> aParameters = new ArrayList<Parameter>();
        aParameters.add(plateformParameterBuilder.build());
//        aParameters.add(languageParameterBuilder.build());
//        aParameters.add(tokenParameterBuilder.build());
        //生产环境禁止扫描API
        /* if (env.getProperty("spring.cloud.config.profile").equals("rls")) {*/
        // return new Docket(DocumentationType.SWAGGER_2).enable(false);
        /*} else {*/
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(buildApiInf()).
                        globalOperationParameters(aParameters)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.dc.improve"))//要扫描的API(Controller)基础包
                .paths(PathSelectors.any())
                .build();
        /* }*/


    }

    private ApiInfo buildApiInf() {
        return new ApiInfoBuilder()
                .title(appName+"接口文档")
                /*.description("接口Headers中公共传递参数sign(签名)、timeStamp(时间戳精确到秒)" +
                        "、cidKey(平台key(字典platform_cidKey))、token(用户token)、platForm(平台(字典：platform))、language(默认中文(字典：language))," +
                        "sign:所有Headers及参数key自然排序（升序），拼接字符串str+=(key+value)，然后cidKey+str+cidKey进行md5加密！" +
                        "注：参数没有可传递值，传空")*/
                // .termsOfServiceUrl("http://zkt.com.cn")
                // .contact(new Contact("diaomingkai", "http://zkt.com.cn", "diaomingkai@zhiketong.cn"))
                .version("1.0")
                .build();
    }

   /* 说明：

    @Api：用在类上，说明该类的作用
    @ApiOperation：用在方法上，说明方法的作用
    @ApiImplicitParams：用在方法上包含一组参数说明
    @ApiImplicitParam：用在@ApiImplicitParams注解中，指定一个请求参数的各个方面
    paramType：参数放在哪个地方
    header-->请求参数的获取：@RequestHeader
    query-->请求参数的获取：@RequestParam
    path（用于restful接口）-->请求参数的获取：@PathVariable
    body
    form（不常用）
    name：参数名
    dataType：参数类型
    required：参数是否必须传
    value：参数的意思
    defaultValue：参数的默认值
    @ApiResponses：用于表示一组响应
    @ApiResponse：用在@ApiResponses中，一般用于表达一个错误的响应信息
    code：数字，例如400
    message：信息，例如"请求参数没填好"
    response：抛出异常的类
    @ApiModel：描述一个Model的信息（这种一般用在post创建的时候，使用@RequestBody这样的场景，请求参数无法使用@ApiImplicitParam注解进行描述的时候）
    @ApiModelProperty：描述一个model的属性*/

}
