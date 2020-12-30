package com.javacodegeeks.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;

import com.javacodegeeks.model.Employee;

@Configuration
public class RedisConfig {

	@Bean
	public JedisConnectionFactory jedisConnectionFactory() {
		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
		/*jedisConnectionFactory.getPoolConfig().setMaxIdle(30);
		jedisConnectionFactory.getPoolConfig().setMinIdle(10);*/
		jedisConnectionFactory.setHostName("redis-18356.c10.us-east-1-2.ec2.cloud.redislabs.com");
		jedisConnectionFactory.setPort(18356);
		jedisConnectionFactory.setUsePool(true);
		jedisConnectionFactory.setPassword("fzH2MdYW5JdAnUEZmy65PRMJHCyp8sMB");
		return jedisConnectionFactory;
	}
	
	@Bean
	public RedisTemplate<String, Employee> redisTemplate() {
		final RedisTemplate<String, Employee> redisTemplate = new RedisTemplate<String, Employee>();
		redisTemplate.setConnectionFactory(jedisConnectionFactory());
		redisTemplate.setValueSerializer(new GenericToStringSerializer<Employee>(Employee.class));
		/*redisTemplate.setEnableTransactionSupport(true);*/
		return redisTemplate;
	}
}
