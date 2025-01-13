package com.atguigu.cloud.api;

import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("cloud-payment-service")
public interface PayFeignApi
{
    @PostMapping("/pay/add")
    public ResultData addPay(@RequestBody PayDTO payDTO);
    @GetMapping("/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id);
    @GetMapping(value = "/pay/get/info")
    public String mylb();
}
