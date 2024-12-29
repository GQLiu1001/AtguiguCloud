package com.atguigu.cloud.service.impl;

import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.mapper.PayMapper;
import com.atguigu.cloud.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayServiceImpl implements PayService {

    @Autowired
    private PayMapper payMapper;

    @Override
    public int pay(Pay pay) {
        int insert = payMapper.insert(pay);
        return insert;
    }

    @Override
    public int delete(Integer id) {
        int i = payMapper.deleteByPrimaryKey(id);
        return i;
    }

    @Override
    public int update(Pay pay) {
        int i = payMapper.updateByKey(pay);
        return i;
    }

    @Override
    public Pay getById(Integer id) {
        Pay pay = payMapper.selectByPrimaryKey(id);
        return pay;
    }

    @Override
    public List<Pay> getAll() {
        List<Pay> list = payMapper.selectAll();
        return list;
    }
}
