package com.atguigu.cloud.controller;

import cn.hutool.core.bean.BeanUtil;
import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.PayService;
import com.atguigu.cloud.utils.SetPay;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

@CrossOrigin
@RestController
@Slf4j //日志
//swagger 与 h5工程师交互
//Tag用在Controller上 Operation用在方法上 Schema用在实体类上
@Tag(name="支付微服务模块",description = "支付CRUD") // swagger3
public class PayController {
    @Resource
    private PayService payService;

    @PostMapping("/pay/add")
    @Operation(summary="新增",description = "新增支付流水方法，JSON串做参数")
    public ResultData<?> addPay(@RequestBody Pay pay) {
        Pay pay2 = SetPay.setPay(pay);
        System.out.println("addPay方法");
        System.out.println(pay2);
        int i = payService.pay(pay2);
        if (i==0){
            return ResultData.fail("400","失败");
        }else {
            System.out.println("成功插入记录 返回值：" + i);
            return ResultData.success("成功插入记录 返回值：" + i);
        }
    }

    @DeleteMapping("/pay/del/{id}")
    @Operation(summary="删除",description = "删除支付流水方法")
    public ResultData<?> deletePay(@PathVariable("id") Integer id) {
        System.out.println("deletePay方法");
        int delete = payService.delete(id);
        if (delete==0){
            return  ResultData.fail("400","错误");
        }else {
            System.out.println("成功删除记录 返回值：" + delete);
            return ResultData.success("成功删除记录 返回值：" + delete);
        }
    }
    //前端给的整个Json串封装成DTO
    @PutMapping("/pay/update")
    @Operation(summary="修改",description = "修改支付流水方法")
    public ResultData<?> updatePay(@RequestBody  PayDTO payDTO) {
        Pay pay = new Pay();
        //分层对象规范  DTO不要传到后面
        BeanUtil.copyProperties(payDTO, pay);
        System.out.println("updatePay方法");
        int update = payService.update(pay);
        if (update==0){
            return ResultData.fail("400","错误");
        }else {
        System.out.println("成功修改记录 返回值："+update);
        return ResultData.success("成功修改记录 返回值："+update);
        }
    }
    @GetMapping("/pay/get/{id}")
    @Operation(summary="查询byId",description = "查询id支付流水方法")
    public ResultData<?> getPayById(@PathVariable("id")  Integer id) {
        if (id < 0 ){
            throw new RuntimeException("id不能为负数");
        }
        //暂停62s线程 故意写bug 测试feign默认超时时间 which is 60s 80端口的yaml更改参数
        try {TimeUnit.SECONDS.sleep(62);}catch (Exception e){e.printStackTrace();}

        System.out.println("getPayById方法");
        Pay byId = payService.getById(id);
        if (byId==null){
            return ResultData.fail("500","错误");
        }else {
            System.out.println(byId);
            //???应该返回VO 不然私密信息也打包返回了
            return ResultData.success(byId);
        }
    }
    @GetMapping("/pay/getAll")
    public ResultData<?> getAllPay() {
        System.out.println("getAllPay方法");
        List<Pay> payList = payService.getAll();
        payList.forEach(System.out::println);
        return ResultData.success(payList);
    }


    @Value("${server.port}")
    private String   port;
    @RefreshScope
    @GetMapping("/pay/get/info")
    //通过改APPLICATION.YAML的环境可以变换
    public String getPortByConusl(@Value("${atguigu.info}") String info)  {
        return "atguigu info:"+info+"port:"+port;
    }



}
