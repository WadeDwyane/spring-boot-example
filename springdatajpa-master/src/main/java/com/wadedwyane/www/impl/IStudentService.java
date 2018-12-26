package com.wadedwyane.www.impl;

import com.wadedwyane.www.entity.StudentEntity;
import org.springframework.data.domain.Page;

public interface IStudentService {

    Page<StudentEntity> findStudents(Integer page, Integer pageSize, StudentEntity entity);
}
