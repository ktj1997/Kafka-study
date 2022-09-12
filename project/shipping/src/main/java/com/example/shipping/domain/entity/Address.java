package com.example.shipping.domain.entity;

import com.example.core.domain.BaseEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Cleanup;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@Table(name = "addresses")
@NoArgsConstructor
@AllArgsConstructor
public class Address extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "user_id")
  private String userId;

  @Column(name = "post_no")
  private String postNo;

  @Column(name = "street_address")
  private String streetAddress;

  @Column(name = "address_detail")
  private String addressDetail;

  @Column(name = "is_deleted")
  private boolean isDeleted;

  public void delete() {
    this.isDeleted = false;
  }
}
