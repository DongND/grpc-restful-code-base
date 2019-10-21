package com.act.infinity.customer.controller.grpc;


import com.act.infinity.customer.mapper.RequestConverter;
import com.act.infinity.customer.mapper.ResponseConverter;
import com.act.infinity.customer.grpc.CreateCustomerRequest;
import com.act.infinity.customer.grpc.CreateCustomerResponse;
import com.act.infinity.customer.grpc.CustomerServiceGrpc;
import com.act.infinity.customer.entity.bo.CustomerBO;
import com.act.infinity.customer.service.CustomerService;
import io.grpc.stub.StreamObserver;
import org.lognet.springboot.grpc.GRpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GRpcService
public class CustomerGrpcController extends CustomerServiceGrpc.CustomerServiceImplBase {

  @Autowired
  private CustomerService customerService;

  @Autowired
  private RequestConverter requestConverter;

  @Autowired
  private ResponseConverter responseConverter;

  @Override
  public void createCustomer(CreateCustomerRequest request,
      StreamObserver<CreateCustomerResponse> responseStreamObserver){

    CustomerBO customerBO = requestConverter.createBO(request);

    CreateCustomerResponse response = responseConverter.createCustomerResponseGRPC(
                                    customerService.createCustomer(customerBO));

    responseStreamObserver.onNext(response);
    responseStreamObserver.onCompleted();
  }

}
