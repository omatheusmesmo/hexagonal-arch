package com.oliveira.hexagonal.adapters.out;

import com.oliveira.hexagonal.adapters.out.mapper.CustomerEntityMapper;
import com.oliveira.hexagonal.adapters.out.repository.CustomerRepository;
import com.oliveira.hexagonal.application.core.domain.Customer;
import com.oliveira.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public void update(Customer customer) {
        var customerEntity = customerEntityMapper.toCustomerEntity(customer);
        customerRepository.save(customerEntity);

    }
}
