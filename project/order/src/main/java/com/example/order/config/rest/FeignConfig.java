package com.example.order.config.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients
@RequiredArgsConstructor
public class FeignConfig {

  private final ObjectMapper objectMapper;

  @Bean
  public ErrorDecoder errorDecoder() {
    return new FeignErrorDecoder(objectMapper);
  }
}
