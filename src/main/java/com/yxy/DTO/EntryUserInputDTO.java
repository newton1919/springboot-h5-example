package com.yxy.DTO;

import lombok.Data;

@Data
public class EntryUserInputDTO {
  // 姓名
  private String name;

  //性别 : male or female
  private String gender;

  //年龄
  private Long age;

  //用户个人介绍
  private String description;
}
