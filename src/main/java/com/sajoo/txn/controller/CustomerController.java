package com.sajoo.txn.controller;

import com.sajoo.txn.dto.CustomerDTO;
import com.sajoo.txn.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerService;

    @PostMapping("/customer")
    public CustomerDTO addCustomer(@RequestBody CustomerDTO customerDTO){
        System.out.println(customerDTO);
        customerDTO = customerService.addCustomer(customerDTO);


        return customerDTO;

    }
}
