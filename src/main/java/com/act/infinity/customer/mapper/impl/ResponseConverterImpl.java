package com.act.infinity.customer.mapper.impl;

import com.act.infinity.customer.mapper.ResponseConverter;
import com.act.infinity.customer.grpc.CreateCustomerResponse;
import com.act.infinity.customer.grpc.Customer;
import com.act.infinity.customer.entity.bo.CustomerBO;
import com.act.infinity.customer.entity.bo.OrderBO;
import com.act.infinity.customer.dto.CustomerDTO;
import com.act.infinity.customer.dto.OrderDTO;
import com.act.infinity.order.grpc.GetOrderListResponse;
import com.act.infinity.order.grpc.GetOrderListResponse.Builder;
import com.act.infinity.order.grpc.GetOrderResponse;
import com.act.infinity.order.grpc.Order;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ResponseConverterImpl implements ResponseConverter {

  // for gRPC
  @Override
  public CreateCustomerResponse createCustomerResponseGRPC(CustomerBO input){
    CreateCustomerResponse response = CreateCustomerResponse.newBuilder()
        .setResponse(
            Customer.newBuilder()
                .setId(input.getId())
                .setName(input.getName())
                .build())
        .build();
    return response;
  }

  // for REST
  @Override
  public CustomerDTO createDTO(CustomerBO input){
    CustomerDTO response = new CustomerDTO();
    response.setId(input.getId());
    response.setName(input.getName());
    return response;
  }

  // for gRPC
  @Override
  public GetOrderResponse getOrderResponseGRPC(OrderBO input){
    GetOrderResponse response = GetOrderResponse.newBuilder()
                                  .setResponse(
                                      Order.newBuilder()
                                          .setId(input.getId())
                                          .setCustomerId(input.getCustomerId())
                                          .setOrderNumber(input.getOrderNumber())
                                          .build()
                                  ).build();
    return response;
  }
  // for REST
  @Override
  public OrderDTO createDTO(OrderBO input){
    OrderDTO response = new OrderDTO();
    response.setId(input.getId());
    response.setCustomerId(input.getCustomerId());
    response.setOrderNumber(input.getOrderNumber());
    return response;
  }

  //for gRPC
  @Override
  public GetOrderListResponse getOrderCustomerListResponseGRPC(List<OrderBO> objList){
    Builder builder = GetOrderListResponse.newBuilder();
    if (objList != null){
      List<Order> orders = new ArrayList<>();;
      objList.stream().forEach(el -> {
        orders.add(Order.newBuilder()
                    .setId(el.getId())
                    .setCustomerId(el.getCustomerId())
                    .setOrderNumber(el.getOrderNumber())
                    .build());
      });
      builder.addAllResponse(orders);

    }
    GetOrderListResponse response = builder.build();

    return response;
  }

  // for REST
  @Override
  public List<OrderDTO> createListDTO(List<OrderBO> objList){
    List<OrderDTO> response = new ArrayList<>();

    if(objList != null){
      objList.stream().forEach(el -> {
        response.add(createDTO(el));
      });
    }
    return response;
  }


}
