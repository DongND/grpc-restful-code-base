package com.act.infinity.customer.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="service-config")
@Getter
@Setter
@ToString
public class ServiceConfiguration {


  private String serviceA1Endpoint;

  private String serviceA1Port;

  private String serviceA2Endpoint;

  private String serviceA2Port;

  private String serviceA3Endpoint;

  private String serviceA3Port;


}
