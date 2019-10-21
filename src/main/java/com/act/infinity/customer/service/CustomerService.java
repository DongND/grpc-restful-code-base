package com.act.infinity.customer.service;

import com.act.infinity.customer.entity.CustomerEntity;
import com.act.infinity.customer.entity.bo.CustomerBO;
import com.act.infinity.customer.repository.CustomerRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
  @Autowired
  CustomerRepository customerRepository;
  public CustomerBO createCustomer(CustomerBO customer){
    // doing stuff for customer and return result
    CustomerBO response = new CustomerBO();
    response.setId(customer.getId());
    response.setName(customer.getName() + " created");

    return response;
  }

  public CustomerBO getById(Integer id){
    Optional<CustomerEntity> found = customerRepository.findById(id);
    if (found.isPresent()){
      CustomerEntity entity = found.get();
      CustomerBO cb = new CustomerBO(entity.getId(), entity.getFirstname() + " " + entity.getLastname());
      return cb;
    }

    return null;
  }
}
