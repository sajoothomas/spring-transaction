package com.sajoo.txn.service;

import com.sajoo.txn.dto.CustomerDTO;
import com.sajoo.txn.model.AddressDAO;
import com.sajoo.txn.model.Customer;
import com.sajoo.txn.model.CustomerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl {

    @Autowired
    CustomerDAO customerDAO;

    @Autowired
    AddressServiceImpl addressService;

    @Transactional(propagation = Propagation.REQUIRED)
    public CustomerDTO addCustomer(CustomerDTO customerDTO){

        Customer customer = new Customer(customerDTO.getName(), customerDTO.getAge());
        customerDAO.save(customer);
        customerDTO.setId(customer.getId());

        try {
            addressService.addAddress(customerDTO);
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        return customerDTO;
    }




}
