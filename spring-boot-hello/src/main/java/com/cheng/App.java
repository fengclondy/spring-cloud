package com.cheng;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * Hello world!
 *
 */
//extends WebMvcConfigurerAdapter
@SpringBootApplication
@MapperScan("com.cheng.*")//扫描：该包下相应的class,主要是MyBatis的持久化类.
public class App 
{
	
//	@Override
//	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//		super.configureMessageConverters(converters);
//		
//		/*
//		 * 1、需要先定义一个 convert 转换消息的对象;
//		 * 2、添加fastJson 的配置信息，比如：是否要格式化返回的json数据;
//		 * 3、在convert中添加配置信息.
//		 * 4、将convert添加到converters当中.
//		 * 
//		 */
//		
//		// 1、需要先定义一个 convert 转换消息的对象;
//		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
//		
//		//2、添加fastJson 的配置信息，比如：是否要格式化返回的json数据;
//		FastJsonConfig fastJsonConfig = new FastJsonConfig();
//		fastJsonConfig.setSerializerFeatures(
//                SerializerFeature.PrettyFormat
//        );
//		
//		//3、在convert中添加配置信息.
//        fastConverter.setFastJsonConfig(fastJsonConfig);
//        
//        //4、将convert添加到converters当中.
//    	converters.add(fastConverter);
//		
//	}
	
	
	/**
	 * 在这里我们使用 @Bean注入 fastJsonHttpMessageConvert
	 * @return
	 */
	@Bean
	public HttpMessageConverters fastJsonHttpMessageConverters() {
		// 1、需要先定义一个 convert 转换消息的对象;
		FastJsonHttpMessageConverter fastConverter = new FastJsonHttpMessageConverter();
		
		//2、添加fastJson 的配置信息，比如：是否要格式化返回的json数据;
		FastJsonConfig fastJsonConfig = new FastJsonConfig();
		fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat);
		
		//4、处理中文乱码问题
		List<MediaType> fastMediaType=new ArrayList<>();
		fastMediaType.add(MediaType.APPLICATION_JSON_UTF8);
		fastConverter.setSupportedMediaTypes(fastMediaType);
		
		
		//3、在convert中添加配置信息.
		fastConverter.setFastJsonConfig(fastJsonConfig);
		
		
		HttpMessageConverter<?> converter = fastConverter;
		return new HttpMessageConverters(converter);
	}
	
	
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }
}
