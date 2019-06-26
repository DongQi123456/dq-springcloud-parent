package com.custom;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * 自定义的token对象
 * @author dongqi
 * @date 2019/5/11 15:16
 * @params 
 * @return 
 */
public class OAuth2Token implements AuthenticationToken {

    private String token;

    public OAuth2Token(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
