package com.example.spring_department_service.config;

import com.example.spring_department_service.client.EmployeeClient;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig {

    @Autowired
    private LoadBalancedExchangeFilterFunction filterFunction;

    @Bean
    public WebClient employeeWebClient() {
        return WebClient.builder()
                .baseUrl("http://spring_employee_service")
                .filter(filterFunction)
                .build();
    }

    private @NotNull HttpServiceProxyFactory factory(){
        WebClientAdapter adapter = WebClientAdapter.forClient(employeeWebClient());
        return HttpServiceProxyFactory.builder(adapter).build();
    }

    @Bean
    public EmployeeClient employeeClient() {
        HttpServiceProxyFactory factory = factory();
        return factory.createClient(EmployeeClient.class);
    }
}
