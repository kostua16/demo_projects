package com.example.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.codec.ServerCodecConfigurer;
import org.springframework.web.client.RestTemplate;

@Configuration
public class GatewayConfig {

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

//  @Bean
//  RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
//    return builder.routes()
//        .route("hero",
//            route -> route.path("/hero/**")
//                .uri("lb://HERO"))
//        .route("enemy",
//            route -> route.path("/enemy/**")
//                .uri("lb://ENEMY"))
//        .route("other",
//            route -> route.path("/other/**")
//                .uri("lb://OTHER"))
//        .build();
//  }

//  @Bean
//  public ServerCodecConfigurer serverCodecConfigurer() {
//    return ServerCodecConfigurer.create();
//  }


//  @Bean
//  public CorsConfigurationSource corsConfigurationSource() {
//    CorsConfiguration configuration = new CorsConfiguration();
//    configuration.setAllowedOrigins(Arrays.asList("https://127.0.0.1:3000"));
//    configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT"));
//    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//    source.registerCorsConfiguration("/**", configuration);
//    return source;
//  }
}
