package com.sajoo.txn.service;

import com.sajoo.txn.dto.CustomerDTO;
import com.sajoo.txn.model.Address;
import com.sajoo.txn.model.AddressDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AddressServiceImpl {

    @Autowired
    AddressDAO addressDAO;

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public CustomerDTO addAddress(CustomerDTO customerDTO){


        Address address = new Address(customerDTO.getAddressLine(), customerDTO.getState());
        addressDAO.save(address);
        customerDTO.setAddressId(address.getId());

        if(customerDTO.getName().equals("error")){
            throw new RuntimeException("Name exception");
        }

        return customerDTO;
    }
}
