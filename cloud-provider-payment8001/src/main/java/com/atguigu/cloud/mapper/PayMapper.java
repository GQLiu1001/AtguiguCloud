package com.atguigu.cloud.mapper;

import com.atguigu.cloud.entities.Pay;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface PayMapper extends Mapper<Pay> {


    int updateByKey(Pay pay);
}