package com.act.infinity.customer.service;

import com.act.infinity.customer.entity.OrderEntity;
import com.act.infinity.customer.entity.bo.OrderBO;
import com.act.infinity.customer.repository.OrderRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

  @Autowired
  OrderRepository orderRepository;

  public OrderBO getById(Integer id){
    Optional<OrderEntity> found = orderRepository.findById(id);
    if (found.isPresent()){
      OrderEntity entity = found.get();
      OrderBO ob = new OrderBO(entity.getId(), entity.getCustomerId(), entity.getOrderNumber());
      return ob;
    }

    return null;
  }
  public List<OrderBO> getByCustomerId(Integer customerId){
    Optional<List<OrderEntity>> found = orderRepository.findOrderEntitiesByCustomerId(customerId);

    List<OrderBO> orderBOList = new ArrayList<>();
    if (found.isPresent()){
      List<OrderEntity> entities = found.get();
      entities.stream().forEach(entity ->{
          OrderBO bo = new OrderBO(entity.getId(), entity.getCustomerId(), entity.getOrderNumber());
          orderBOList.add(bo);
        }
      );
    }

    return orderBOList;
  }
}
