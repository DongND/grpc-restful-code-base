package com.act.infinity.customer.service;

import com.act.infinity.customer.mapper.ResponseConverter;
import com.act.infinity.customer.entity.bo.OrderBO;
import com.act.infinity.customer.dto.OrderDTO;
import com.act.infinity.order.grpc.GetOrderListResponse;
import com.act.infinity.order.grpc.GetOrderListResponse.Builder;
import com.act.infinity.order.grpc.Order;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AggregateService {

  @Autowired
  private ResponseConverter responseConverter;

  @Autowired
  private HttpClientService httpClientService;

  @Autowired
  private GRpcClientService gRpcClientService;

  // Get all order by customerId, customerId +1, customerId + 2
  public List<OrderDTO> getAllOrdersByCustomerId(Integer id){

    List listDTOs = new ArrayList<OrderBO>();

    List<OrderDTO> first = httpClientService.getOrdersByCustomerId("http://localhost:8001",  id);
    List<OrderDTO> second = httpClientService.getOrdersByCustomerId("http://localhost:8002", id +1);
    List<OrderDTO> third = httpClientService.getOrdersByCustomerId("http://localhost:8003", id +2);
    listDTOs.addAll(first != null ? first : new ArrayList());
    listDTOs.addAll(second != null ? second : new ArrayList());
    listDTOs.addAll(third != null ? third : new ArrayList());

    return listDTOs;
  }

  // Get all order by customerId, customerId +1, customerId + 2
  public GetOrderListResponse getAllOrdersByCustomerIdGrpc(Integer id){

    GetOrderListResponse first = gRpcClientService.getOrderResponseList("http://localhost", 9001,  id);
    GetOrderListResponse second = gRpcClientService.getOrderResponseList("http://localhost", 9002,id +1);
    GetOrderListResponse third = gRpcClientService.getOrderResponseList("http://localhost", 9003, id +2);

    List<Order> fList = first.getResponseList();
    List<Order> sList = second.getResponseList();
    List<Order> tList = third.getResponseList();
    List<Order> all =new ArrayList<>();
    all.addAll(fList);
    all.addAll(sList);
    all.addAll(tList);

    Builder builder = GetOrderListResponse.newBuilder();

    for( int i=0; i< all.size(); i++){
      builder.setResponse(i, all.get(i));
    }

    return builder.build();
  }

}
