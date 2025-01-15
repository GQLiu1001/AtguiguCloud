package com.atguigu.cloud.api;

import com.atguigu.cloud.resp.ResultData;
import org.springframework.stereotype.Component;

//fallback自定义 PayFeignSentinelApi的实现类
@Component
public class PayFeignSentinelApiFallBack implements PayFeignSentinelApi
{
    @Override
    public ResultData<?> getPayByOrderNo(String orderNo)
    {
        return ResultData.fail("500","对方服务宕机或不可用，FallBack服务降级o(╥﹏╥)o");
    }
}