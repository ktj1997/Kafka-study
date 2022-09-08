package com.example.order.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@AllArgsConstructor
@Table(name = "order_shipping")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderShipping {}
