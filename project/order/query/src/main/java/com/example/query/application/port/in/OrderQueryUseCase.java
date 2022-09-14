package com.example.query.application.port.in;

import com.example.query.application.port.in.dto.FindOrderQueryDto;

public interface OrderQueryUseCase {
  FindOrderQueryDto.Response getOrder(FindOrderQueryDto.ByIdRequest dto);
}
