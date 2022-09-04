package com.example.item.adapter.in.web;

import com.example.item.application.port.in.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ItemController {

  private final ItemService itemService;
}
