package com.wadedwyane.www.repository;

import com.wadedwyane.www.entity.PaperworkEntity;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaperworkRepository extends PagingAndSortingRepository<PaperworkEntity, Long>, JpaSpecificationExecutor<PaperworkEntity> {
}
