package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/*
* 使用restTemplate访问restful接口非常的简单粗暴无脑。
* (url, requestMap, ResponseBean.class)这三个参数分别代表
* REST请求地址、请求参数、HTTP响应转换被转换成的对象类型。
* */
@CrossOrigin
@RestController
public class OrderController {
    // 先写死，硬编码
    //public static final String PaymentSrv_URL = "http://localhost:8001";

    //服务注册中心上的微服务名称
    public static final String PaymentSrv_URL = "http://cloud-payment-service";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/consumer/pay/add")
    public ResultData<?> addOrder(@RequestBody PayDTO payDTO) {
        return restTemplate.postForObject(PaymentSrv_URL+"/pay/add",
                payDTO,
                ResultData.class);
    }

    @DeleteMapping("/consumer/pay/del/{id}")
    public ResultData<?> delOrder(@PathVariable("id") String id) {
        restTemplate.delete(PaymentSrv_URL+"/pay/del/" + id);
        return ResultData.success("操作完成");

    }
    @PutMapping("/consumer/pay/update")
    public ResultData<?> updateOrder(@RequestBody PayDTO payDTO) {
        restTemplate.put(PaymentSrv_URL+"/pay/update", payDTO);
        return ResultData.success("操作完成");
    }


    @GetMapping("/consumer/pay/get/{id}")
    public ResultData<?> addOrder(@PathVariable("id") Integer id) {
        return restTemplate.getForObject(PaymentSrv_URL+"/pay/get/{id}",
                ResultData.class,
                id);
    }

}
