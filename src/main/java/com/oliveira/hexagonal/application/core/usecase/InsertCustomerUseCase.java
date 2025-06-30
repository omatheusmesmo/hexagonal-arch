package com.oliveira.hexagonal.application.core.usecase;

import com.oliveira.hexagonal.application.core.domain.Customer;
import com.oliveira.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.oliveira.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort;
import com.oliveira.hexagonal.application.ports.out.InsertCustomerOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort;

    private final InsertCustomerOutputPort InsertCustomerOutputPort;

    public InsertCustomerUseCase(FindAddressByZipCodeOutputPort findAddressByZipCodeOutputPort, InsertCustomerOutputPort insertCustomerOutputPort) {
        this.findAddressByZipCodeOutputPort = findAddressByZipCodeOutputPort;
        this.InsertCustomerOutputPort = insertCustomerOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipcode){
        var address = findAddressByZipCodeOutputPort.find(zipcode);
        customer.setAddress(address);
        InsertCustomerOutputPort.insert(customer);
    }
}
