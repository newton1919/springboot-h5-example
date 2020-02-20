package com.yxy.controller;

import com.yxy.DTO.EntryUserInputDTO;
import com.yxy.base.BusinessException;
import com.yxy.base.RestResponse;
import com.yxy.model.EntryUser;
import com.yxy.service.EntryUserService;
import com.yxy.utils.FieldNoGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/user")
public class EntryUserController {

  @Autowired
  private EntryUserService functionService;

  @PostMapping("/add")
  @Transactional(rollbackFor = Exception.class)
  public RestResponse addUser(@RequestBody EntryUserInputDTO inputDTO) throws Exception {
    RestResponse restResponse = new RestResponse(200, "");
    EntryUser newestRow = functionService.addUser(inputDTO);
    restResponse.setContent(newestRow);
    return restResponse;
  }
}
