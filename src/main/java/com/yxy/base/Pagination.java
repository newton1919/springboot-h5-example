package com.yxy.base;

import lombok.Data;

@Data
public class Pagination {
    //第几页，从1开始
    private int pageNumber;

    //每页的条数
    private int pageSize;

    //已经逻辑删除的不查
    private int status;
}
