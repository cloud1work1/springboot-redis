# springboot-redis

## REDIS JEDISCONNECTIONFACTORY usage
- jedisConnectionFactory = new JedisConnectionFactory();

  jedisConnectionFactory.setHostName(hostName);
  
  jedisConnectionFactory.setPort(port);
  
  jedisConnectionFactory.setPassword(password);
  
 - RedisTemplate redisTemplate = new RedisTemplate();
 
   redisTemplate.setConnectionFactory(jedisConnectionFactory);
   
  - HashOperation<String, Type, Object> hashOperation = redisTemplate.opsForHash();
  
  - @Cachable(value="name", key="#your-id", unless="#result.param <condtn>")
