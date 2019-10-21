package com.act.infinity.customer;

import com.act.infinity.customer.grpc.CreateCustomerRequest;
import com.act.infinity.customer.grpc.CreateCustomerResponse;
import com.act.infinity.customer.grpc.Customer;
import com.act.infinity.customer.grpc.CustomerServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcControllerTest {
    public static void main(String[] args){
      ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8001 )
          .usePlaintext().build();

      CustomerServiceGrpc.CustomerServiceBlockingStub client = CustomerServiceGrpc.newBlockingStub(channel);

      CreateCustomerRequest request = CreateCustomerRequest.newBuilder()
                                        .setRequest(
                                            Customer.newBuilder()
                                                .setId(100)
                                                .setName("GRPC Customer name")
                                                .build())
                                        .build();
      CreateCustomerResponse response = client.createCustomer(request);

      System.out.println("Got customer ID: " + response.getResponse().getId()
                      + " And Name: "+ response.getResponse().getName());
    }
}
