package com.act.infinity.customer.service;

import com.act.infinity.customer.dto.OrderDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HttpClientService {

  @Autowired
  private RestTemplate restTemplate;

  public List<OrderDTO> getOrdersByCustomerId(String enpoint, Integer customerId){

      try {
        String url = enpoint+"/api/v1/customer/" + customerId + "/orders";
        System.out.println("URL: " + url);
        List<OrderDTO> response = restTemplate.exchange(url, HttpMethod.GET, null,
            new ParameterizedTypeReference<List<OrderDTO>>(){}).getBody();
        return response;
      } catch (Exception ex){
        System.out.println(ex);

        return null;
      }

  }
}
