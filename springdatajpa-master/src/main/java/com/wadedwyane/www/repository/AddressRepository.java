package com.wadedwyane.www.repository;

import com.wadedwyane.www.entity.Address;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends PagingAndSortingRepository<Address, Long>, JpaSpecificationExecutor<Address> {


}
