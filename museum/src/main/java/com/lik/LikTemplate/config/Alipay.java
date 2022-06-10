package com.lik.LikTemplate.config;

import com.alibaba.fastjson.JSON;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

public class Alipay {


    private final String format = "json";

    /**
     * appId
     */
    private String appId = "2021000120600734";

    /**
     * 商户私钥
     */
    private String privateKey= "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCJsEgfk4ONd5el259r2ZbaXL+jxE0NAfUGiLlKE3ZyXYqKCNXEWJx+tc/B4d0Ziyni/WmzY/FFwGIxIM6tG0BQF6E85mzLe4U7kttV0mmsXw4DXXd7VwpluZz1aRFkKUY6IsImhschIwf5t90rRnCEwH8qN6uGTrQecLEYsK2e4dv/d89LqVUzGqj6/vPEt/WFAx2XJFhreQrdqxWLvrCSFkzdzcsHS9bXy5XXj9otcwHQmTWmE3y4FKPlUFyYQ5X3IHYTsnGvVtaT2gAmqFQXSX69vRrGGHqIlSLIkw0a0DM+JQHCSUJyV5Kv6j3pwLX5otZ7eylcxRlIqik0DGYJAgMBAAECggEAIaTvmrei95h3d9G4nNPoZqcvNMcsxLbrtpMGI7GpybxNs/kAsx+r7dJjV87nBezZaVvezjTnqdGerL6FggscpfWAMq9jej1OiwYRjmEB7Vq0w+G85miYY879KYJo+36SaHZB1sQsOE6lDkH9SyvFJssax6gew4zLunxy6cOSSTYvTIH63YddVAIywYFz+H0mzfvd4Psa0kznAGuFWCx3n8IIweYIxDVJ/OrPbFhdKZ+4hRMPeA3sc30gYbtHORVESrWGCRUji9nk6OTDaanfC28ISK2RoovY+iyP9O1e3L3cS9k+kIoObEuM+LWnCDQ9S8tWPxOUXNYPFqNRKJ+i4QKBgQDLhf3iIB7G4EryKfq1i5+AdFsaCVuKv6QvBsUKBNS+PS3DXP7GSw2IB5qqjz+3pX2LhOM4CDE56GSkJMBTKxZ11dux9ULTS/eSrYxPJ2oKU6tNUXMsZngqYdSH2Owf5R970oncqAxRaMyYHpxRJwGpPfG9ieOoZ9lmN1Q3afSfzQKBgQCtMLgvnaVNhrWlC3VFxPSIMrpN1+E7sktThYV+R4xeI0LhvzzEkEftpZ+h++9taOZedsCANGLHytWh1i5hBieShrgDae9mnPZy4sqydf+1IyYssh44az2G83oCRyNlpYRSngBUbK8ZKBObYfnPgjTXuReI/8IZdOXhvFj8LmiLLQKBgHCbiZak2QKGtVD54yqxvyXOu11Tkh/Z2xjd8QWTGLbNmNWATcMfYbRDKNN4APQ2j5kzhJjLB5mXuJ+NahBaRcoa8ryrDDdmz+uLNJfTIfvmwWA9UbFeXNxuVq53WmZnWp0jJ348SNx+VL1SKoFISMYAbRHHCnxyQToqIOGsMVp9AoGBAIyMahzyQZENzmGXT9+D+7KAAGNl23o3shug0vntFIPc98z+BlG6iTTZ4RdyvhY7OCDXHFeuq69Z80734wGIHhsySykyEj9jCDmpxTdYvWCBmtxQ3GeK2A6pjo1Er/wwe5cUdE4POXYf6PGDbFizYTDkG65paFqCXIB5+nkFLIAtAoGAcXTHZxklHYDad3TwkOhUCrMT7b5s7D/xwxFTvjag8Vmubwz/pUqeVNc7yDUbMc3aYjpZQro3gIRXgaM+Y1tpI+gMwk2gjZayD85PjT2HLtJtJD3VxbGxxU36sVrum1hKy+lyIZiJO+DCvvkLm/vlFxyrK//9aBMUMESfgt6N93Q=";
    /**
     * 支付宝公钥
     */
    private String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAit+tG79SUmqXPCBRtnRqTJ5StIZ8FG+/xl2sG8e1PcTGAnRzmmbRljIYhQBHIwpCzFtT+fYIZLG/eR4CLIuU5Auf9YcmKHTPVxb2wTLySXEeRXpC8eXao7jhjrqH779dQJ2MsY++0Xyi+sptgE2F4fM7Or/JX9b+lmYS632XvDIcQeclZ3YhFQV/DjwsTaEN82aGzA5ope5vnv3cO4ZJWjpsh3ND3w8zgTVoLfhkgmk9xJ3Yd2pRxK9W6y4jBf5Bk/eATH991J7F4NDSpjWLVpoBcj1sFsKgFk0uTubPy9HxYXmSM6Z/sbeSM3DWnwDZybFZfPherJCef29o4uUIYwIDAQAB";
    /**
     * 服务器异步通知页面路径，需要公网能访问到
     */
    private String notifyUrl = "http://qz25at.natappfree.cc/order/success";

    /**
     * 服务器同步通知页面路径，填写自己的成功页面路径
     */
    private String returnUrl = "http://localhost:8080/#/Order";

    /**
     * 签名方式
     */
    private String signType = "RSA2";

    /**
     * 字符编码格式
     */
    private String charset;

    /**
     * 支付宝网关
     */
    private String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    public String pay(AliPayBean aliPayBean) throws AlipayApiException {

        AlipayClient alipayClient = new DefaultAlipayClient(
                gatewayUrl, appId, privateKey, format, charset, publicKey, signType);

        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(returnUrl);
        alipayRequest.setNotifyUrl(notifyUrl);
        alipayRequest.setBizContent(JSON.toJSONString(aliPayBean));

        String result = alipayClient.pageExecute(alipayRequest).getBody();

        return result;
    }
}