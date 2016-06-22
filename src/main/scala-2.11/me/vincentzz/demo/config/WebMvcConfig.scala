package me.vincentzz.demo.config

import java.nio.charset.Charset

import com.fasterxml.jackson.module.scala.DefaultScalaModule
import org.springframework.context.annotation.{Bean, Configuration}
import org.springframework.http.converter.json.{Jackson2ObjectMapperBuilder, MappingJackson2HttpMessageConverter}
import org.springframework.http.converter.{HttpMessageConverter, StringHttpMessageConverter}
import org.springframework.web.servlet.ViewResolver
import org.springframework.web.servlet.config.annotation._
import org.springframework.web.servlet.view.InternalResourceViewResolver
import org.springframework.web.servlet.view.JstlView
import org.springframework.web.servlet.view.velocity.VelocityViewResolver

@Configuration
//@EnableWebMvc
class WebMvcConfig extends WebMvcConfigurerAdapter {
  val CLASSPATH_RESOURCE_LOCATIONS = Array("classpath:/web/",
    "classpath:/public/", "classpath:/static/")

//  override def configureMessageConverters(converters: java.util.List[HttpMessageConverter[_]]) {
//    converters.add(jackson2HttpMessageConverter)
//    converters.add(stringHttpMessageConverter)
//  }

  //overwrite the default velocityViewResolver
  @Bean def velocityViewResolver: VelocityViewResolver = {
    val velocityViewResolver = new VelocityViewResolver
    velocityViewResolver.setPrefix("/templates/")
    velocityViewResolver.setSuffix(".vm")
    velocityViewResolver
  }

  // replace the springBoot default objectMapper which is customized for java
  @Bean def jackson2HttpMessageConverter: MappingJackson2HttpMessageConverter = {
    val converter: MappingJackson2HttpMessageConverter = new MappingJackson2HttpMessageConverter
    converter.setObjectMapper(new Jackson2ObjectMapperBuilder().modules(DefaultScalaModule).build())
    converter
  }
  // replace springBoot default stringHttpMessageConverter
  @Bean def stringHttpMessageConverter: StringHttpMessageConverter = {
    new StringHttpMessageConverter(Charset.forName("UTF-8"))
  }

  override def addResourceHandlers(registry: ResourceHandlerRegistry) {
    registry.addResourceHandler("/**").addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS: _*)
  }

  override def configureDefaultServletHandling(configure: DefaultServletHandlerConfigurer): Unit = {
    configure.enable
  }
}
