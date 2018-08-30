package com.huiliang.salessituationservice.config;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.crypto.KeyGenerator;

@Configuration
public class RedisConfig extends CachingConfigurerSupport {

}
