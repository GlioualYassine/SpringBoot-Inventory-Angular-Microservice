package com.example.Billing;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RefreshScope
public class ConsulConfigRestController {
//  méthode ancienne
//    @Value("${Token.accessTokenTimeout}")
//    private Long accessTokenTimeout;
//
//    @Value("${Token.refreshTokenTimeout}")
//    private Long refreshTokenTimeout;
//     @GetMapping("/myConfig")
//    public Map<String,Object>myConfig(){
//        return Map.of("accessTokenTimeout",myConsulConfig.getAccessTokenTimeout(),"refreshTokenTimeout",myConsulConfig.getRefreshTokenTimeout());
//    }

    // méthode récente
    private MyConsulConfig myConsulConfig ;
    private MyVaultConfig myVaultConfig;

    public ConsulConfigRestController(MyConsulConfig myConsulConfig, MyVaultConfig myVaultConfig) {
        this.myConsulConfig = myConsulConfig;
        this.myVaultConfig = myVaultConfig;
    }

    @GetMapping("/myConfig")
    public Map<String,Object> myConfig(){

        return Map.of("my Consul Config " ,myConsulConfig , "My Vault Config",myVaultConfig);
    }

}
