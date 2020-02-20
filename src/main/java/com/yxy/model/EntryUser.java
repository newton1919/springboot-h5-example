package com.yxy.model;


import lombok.Data;
import java.util.Date;
import java.math.BigDecimal;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Column;


@Data
@Entity
@Table(name = "entry_user")
public class EntryUser {

  //主键
  @Id
  @Column(name = "id")
  private Long id;

  //用户名
  @Column(name = "name")
  private String name;

  //性别 : male or female
  @Column(name = "gender")
  private String gender;

  //年龄
  @Column(name = "age")
  private Long age;

  //用户个人介绍
  @Column(name = "description")
  private String description;

  //0 有效  1 逻辑删除
  @Column(name = "status")
  private Long status;

  //描述(保留字段)
  @Column(name = "misc")
  private String misc;

  //创建者id
  @Column(name = "create_user_id")
  private Long createUserId;

  //创建时间
  @Column(name = "create_date")
  private Date createDate;

  //修改人id
  @Column(name = "update_user_id")
  private Long updateUserId;

  //更新时间
  @Column(name = "update_date")
  private Date updateDate;


}
