package com.act.infinity.customer.service;

import com.act.infinity.order.grpc.GetCustomerOrderRequest;
import com.act.infinity.order.grpc.GetOrderListResponse;
import com.act.infinity.order.grpc.OrderServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.stereotype.Service;

@Service
public class GRpcClientService {
    public GetOrderListResponse getOrderResponseList(String host, Integer port, Integer customerId){
      ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
          .usePlaintext().build();

      OrderServiceGrpc.OrderServiceBlockingStub client = OrderServiceGrpc.newBlockingStub(channel);

      GetCustomerOrderRequest request = GetCustomerOrderRequest.newBuilder()
          .setCustomerId(customerId)
          .build();
      GetOrderListResponse response = client.getAggregateCustomerOrderList(request);
      return  response;
    }
}
