package org.xr.user.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.xr.user.handler.UserInterfaceHandler;

/**
 * @author LiuQi
 * @version 1.0
 * @data 2022/12/14 13:10
 * 拦截
 *
 *
 */
//    /** 解决跨域问题 **/
//    public void addCorsMappings(CorsRegistry registry) ;
//
//    /** 添加拦截器 **/
//    void addInterceptors(InterceptorRegistry registry);
//
//    /** 这里配置视图解析器 **/
//    void configureViewResolvers(ViewResolverRegistry registry);
//
//    /** 配置内容裁决的一些选项 **/
//    void configureContentNegotiation(ContentNegotiationConfigurer configurer);
//
//    /** 视图跳转控制器 **/
//    void addViewControllers(ViewControllerRegistry registry);
//
//    /** 静态资源处理 **/
//    void addResourceHandlers(ResourceHandlerRegistry registry);
//
//    /** 默认静态资源处理器 **/
//    void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer);
@Configuration
public class WebConfiguration  implements WebMvcConfigurer  // 官方推荐的
    //extends WebMvcConfigurationSupport 也能实现拦截
{

    @Bean // 自动装载
    public UserInterfaceHandler userInterfaceHandler(){
        return new UserInterfaceHandler();
    }
    @Override
    public void addInterceptors(InterceptorRegistry registry) { //拦截接口
        registry.addInterceptor(userInterfaceHandler());
    }



}
