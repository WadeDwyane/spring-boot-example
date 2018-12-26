package com.wadedwyane.www.repository;

import com.wadedwyane.www.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends JpaRepository<User, Long> {
    User findById(long id);
}
