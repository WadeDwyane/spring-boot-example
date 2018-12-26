package com.wadedwyane.www.repository;

import com.wadedwyane.www.entity.Project;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long>, JpaSpecificationExecutor<Project> {
}
