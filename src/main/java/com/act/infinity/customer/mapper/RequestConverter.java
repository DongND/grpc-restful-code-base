package com.act.infinity.customer.mapper;

import com.act.infinity.customer.dto.CustomerDTO;
import com.act.infinity.customer.dto.OrderDTO;
import com.act.infinity.customer.entity.bo.CustomerBO;
import com.act.infinity.customer.entity.bo.OrderBO;
import com.act.infinity.customer.grpc.CreateCustomerRequest;

public interface RequestConverter {

  CustomerBO createBO(CreateCustomerRequest obj);

  CustomerBO createBO(CustomerDTO obj);

  OrderBO createBO(OrderDTO obj);
}
