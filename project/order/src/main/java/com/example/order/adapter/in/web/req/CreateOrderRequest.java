package com.example.order.adapter.in.web.req;

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
