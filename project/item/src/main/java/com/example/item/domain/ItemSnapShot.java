package com.example.item.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ItemSnapShot {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private int transaction_id;
  private long item_id;
  private int price;
}
