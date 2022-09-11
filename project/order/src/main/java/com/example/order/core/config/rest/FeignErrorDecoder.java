package com.example.order.core.config.rest;

import com.example.core.exceptions.ApiException;
import com.example.core.exceptions.GlobalErrorCode;
import com.example.core.exceptions.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import java.nio.charset.Charset;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FeignErrorDecoder implements ErrorDecoder {
  private final ObjectMapper objectMapper;

  @Override
  public Exception decode(String methodKey, Response response) {
    ErrorResponse errorResponse = null;
    try {
      errorResponse =
          objectMapper.readValue(
              response.body().asReader(Charset.defaultCharset()), ErrorResponse.class);
      return new ApiException(errorResponse.getCode(), errorResponse.getMessage());
    } catch (Throwable throwable) {
      throw new ApiException(GlobalErrorCode.INTERNAL_SERVER_ERROR.getCode(), throwable.getMessage());
    }
  }
}
