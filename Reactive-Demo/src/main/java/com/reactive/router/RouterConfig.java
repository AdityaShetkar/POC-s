package com.reactive.router;

import com.reactive.handler.CustomerHandler;
import com.reactive.handler.CustomerStreamHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class RouterConfig {

    @Autowired
    private CustomerHandler customerHandler;

    @Autowired
    private CustomerStreamHandler streamHandler;

    @Bean
    public RouterFunction<ServerResponse> routerFunction(){
        return RouterFunctions.route()
//                .GET("/router/customers", customerHandler::loadCustomerList)
                .GET("/router/customers", customerHandler::loadCustomerList)
                .GET("/router/customers/stream", streamHandler::getCustomers)
                .GET("/router/customer/stream/{input}",customerHandler::findCustomer )
                .POST("/router/customer/save", customerHandler::saveCustomer)
                .build();


    }
}
