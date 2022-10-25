package com.sodse.trade.qq;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * qq 登陆常量配置类
 */

@Data
public class Constants {

    @Value("${constants.qqAppId}")
    private String qqAppId;

    @Value("${constants.qqAppSecret}")
    private String qqAppSecret;

    @Value("${constants.qqRedirectUrl}")
    private String qqRedirectUrl;

    @Value("${constants.weCatAppId}")
    private String weCatAppId;

    @Value("${constants.weCatAppSecret}")
    private String weCatAppSecret;

    @Value("${constants.weCatRedirectUrl}")
    private String weCatRedirectUrl;

    //自行生成set get方法
}
