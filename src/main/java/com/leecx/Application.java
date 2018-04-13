package com.leecx;

import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
//扫描 mybatis mapper 包路径
@MapperScan(basePackages = "com.leecx.mapper")
//扫描 所有需要的包, 包含一些自用的工具类包 所在的路径
@ComponentScan(basePackages= {"com.leecx", "org.n3r.idworker"})
public class Application {
	
	/*************对于是ORACLE 数据库的 mybatis必须增加如下的配置*********Start */
	@Bean
	public ConfigurationCustomizer configurationCustomizer() {
		return new MybatisPlusCustomizers();
	}

	class MybatisPlusCustomizers implements ConfigurationCustomizer {
		@Override
		public void customize(org.apache.ibatis.session.Configuration configuration) {
			configuration.setJdbcTypeForNull(JdbcType.NULL);
		}
	}
	/*************对于是ORACLE 数据库的 mybatis必须增加如下的配置*********End */

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	 	
}
