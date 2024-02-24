package com.example.Billing;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "token")
// avec configpropoerties , il va chercher tout les propriété qui commence par token
// c'est pas la paine d'utilise @Value("${token.refreshTokenTimeout}")
// il va chercher dans tout les source de configuration
@Data
public class MyConsulConfig {
    private long refreshTokenTimeout ;
    private long accessTokenTimeout;
}
