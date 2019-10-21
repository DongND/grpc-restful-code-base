package com.act.infinity.customer.controller.rest;

import com.act.infinity.customer.factory.ResponseFactory;
import com.act.infinity.customer.mapper.RequestConverter;
import com.act.infinity.customer.mapper.ResponseConverter;
import com.act.infinity.customer.dto.CustomerDTO;
import com.act.infinity.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController {

	@Autowired
	private ResponseFactory responseFactory;

	@Autowired
	private CustomerService customerService;

	@Autowired
	private RequestConverter requestConverter;

	@Autowired
	private ResponseConverter responseConverter;

	@PostMapping("/api/v1/customer")
	public ResponseEntity createCustomer(@RequestBody CustomerDTO customer){
		return responseFactory.success(responseConverter.createDTO(
				customerService.createCustomer(requestConverter.createBO(customer))), CustomerDTO.class);
	}

	@GetMapping("/api/v1/customer/{id}")
	public ResponseEntity getCustomer(@PathVariable Integer id){
		return responseFactory.success(responseConverter.createDTO(
				customerService.getById(id)), CustomerDTO.class);
	}
}
