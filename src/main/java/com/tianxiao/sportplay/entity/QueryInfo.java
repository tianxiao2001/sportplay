package com.tianxiao.sportplay.entity;

import lombok.Data;

@Data
public class QueryInfo {
    private String query;//查询信息 username
    private int pageNum=1;//当前页
    private int pageSize=5;//每页最大数
}
