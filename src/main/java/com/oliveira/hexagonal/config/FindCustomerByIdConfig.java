package com.oliveira.hexagonal.config;

import com.oliveira.hexagonal.adapters.out.FindAddressByZipCodeAdapter;
import com.oliveira.hexagonal.adapters.out.FindCustomerByIdAdapter;
import com.oliveira.hexagonal.adapters.out.InsertCustomerAdapter;
import com.oliveira.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.oliveira.hexagonal.application.core.usecase.InsertCustomerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FindCustomerByIdConfig {

    @Bean
    public FindCustomerByIdUseCase findCustomerByIdUseCase(
           FindCustomerByIdAdapter findCustomerByIdAdapter
    ){
        return new FindCustomerByIdUseCase(findCustomerByIdAdapter);
    }
}
