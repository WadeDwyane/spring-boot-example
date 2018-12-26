package com.wadedwyane.www.service;

import com.wadedwyane.www.entity.StudentEntity;
import com.wadedwyane.www.impl.IStudentService;
import com.wadedwyane.www.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public Page<StudentEntity> findStudents(Integer page, Integer pageSize, StudentEntity entity) {
        Pageable pageAble = new PageRequest(page, pageSize, Sort.Direction.ASC, "id");
        Page<StudentEntity> studentEntityPage = studentRepository.findAll(new Specification<StudentEntity>() {
            @Override
            public Predicate toPredicate(Root<StudentEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> list = new ArrayList<Predicate>();
                if (null != entity.getName() && !"".equals(entity.getName())) {
                    list.add(criteriaBuilder.equal(root.get("name").as(String.class), entity.getName()));
                }
                if (null != entity.getRemark1() && !"".equals(entity.getRemark1())) {
                    list.add(criteriaBuilder.equal(root.get("remark1").as(String.class), entity.getRemark1()));
                }

                Predicate[] p = new Predicate[list.size()];
                return criteriaBuilder.and(list.toArray(p));
            }
        }, pageAble);
        return studentEntityPage;
    }
}
