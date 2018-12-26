package com.wadedwyane.www.service;

import com.wadedwyane.www.entity.Address;
import com.wadedwyane.www.impl.IAddressService;
import com.wadedwyane.www.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService implements IAddressService {

    @Autowired
    AddressRepository addressRepository;

    @Override
    public void saveAddress(Address address) {
        addressRepository.save(address);
    }
}
