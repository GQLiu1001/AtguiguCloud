package com.atguigu.cloud.api;

import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient("cloud-payment-service")
//feign不直接找微服务 先找网关
@FeignClient("cloud-gateway")
public interface PayFeignApi
{
    @PostMapping("/pay/add")
    public ResultData addPay(@RequestBody PayDTO payDTO);
    @GetMapping("/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id);
    @GetMapping("/pay/get/info")
    public String mylb();
    @GetMapping("/pay/micrometer/{id}")
    public String myMicrometer(@PathVariable("id") Integer id);
    /**
     * GateWay进行网关测试案例01
     * @param id
     * @return
     */
    @GetMapping(value = "/pay/gateway/get/{id}")
    public ResultData getById(@PathVariable("id") Integer id);

    /**
     * GateWay进行网关测试案例02
     * @return
     */
    @GetMapping(value = "/pay/gateway/info")
    public ResultData<String> getGatewayInfo();
}
