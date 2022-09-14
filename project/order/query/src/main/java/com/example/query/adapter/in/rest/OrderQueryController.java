package com.example.query.adapter.in.rest;

import com.example.query.application.port.in.OrderQueryUseCase;
import com.example.query.application.port.in.dto.FindOrderQueryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderQueryController {

  private final OrderQueryUseCase orderQueryUseCase;

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public ResponseEntity< FindOrderQueryDto.Response > getOrder(@PathVariable String id) {
    FindOrderQueryDto.ByIdRequest reqDto = new FindOrderQueryDto.ByIdRequest(id);
    FindOrderQueryDto.Response resDto = orderQueryUseCase.getOrder(reqDto);
    return ResponseEntity.ok(resDto);
  }
}
