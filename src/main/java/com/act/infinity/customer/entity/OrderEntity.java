package com.act.infinity.customer.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Orders")
public class OrderEntity {

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Integer id;

  private Integer customerId;

  private Integer orderNumber;

}
