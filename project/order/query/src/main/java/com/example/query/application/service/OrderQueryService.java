package com.example.query.application.service;

import com.example.query.application.port.in.OrderQueryUseCase;
import com.example.query.application.port.in.dto.FindOrderQueryDto;
import com.example.query.application.service.info.BuyerInfo;
import com.example.query.application.service.info.ItemInfo;
import com.example.query.application.service.info.OrderInfo;
import com.example.query.application.service.info.ShippingInfo;
import com.example.query.application.service.query.FindOrderByIdQuery;
import com.example.query.application.service.query.dispatcher.QueryDispatcher;
import com.example.query.domain.entity.Order;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderQueryService implements OrderQueryUseCase {
  private final QueryDispatcher queryDispatcher;

  @Override
  public FindOrderQueryDto.Response getOrder(FindOrderQueryDto.ByIdRequest dto) {

    FindOrderByIdQuery query = new FindOrderByIdQuery(dto.getId());
    List<Order> orders = queryDispatcher.send(query);
    Order order = orders.get(0);

    BuyerInfo buyerInfo = new BuyerInfo(order.getBuyer());
    ShippingInfo shippingInfo = new ShippingInfo(order.getShipping());
    ItemInfo itemInfo = new ItemInfo(order.getItem());
    OrderInfo orderInfo =
        OrderInfo.builder()
            .orderStatus(order.getOrderStatus())
            .totalPrice(order.getTotalPrice())
            .cancelInfo(order.getCancelInfo())
            .orderedAt(order.createdAt)
            .build();

    return new FindOrderQueryDto.Response(buyerInfo, shippingInfo, orderInfo, itemInfo);
  }
}
