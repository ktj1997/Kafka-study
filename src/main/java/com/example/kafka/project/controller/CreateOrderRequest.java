package com.example.kafka.project.controller;

import com.example.kafka.project.service.ItemDto;
import com.example.kafka.project.service.OrderDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CreateOrderRequest {
    private OrderDto order;
    private ItemDto item;
}
