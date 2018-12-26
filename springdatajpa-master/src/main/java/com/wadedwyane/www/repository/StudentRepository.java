package com.wadedwyane.www.repository;

import com.wadedwyane.www.entity.StudentEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface StudentRepository extends PagingAndSortingRepository<StudentEntity, Long>,JpaSpecificationExecutor<StudentEntity> {

    List<StudentEntity> findStudentEntitiesByAgeAndSex(int age, int sex);

    Page<StudentEntity> findAll(Pageable pageable);

    Page<StudentEntity> queryFisrt10ByAge(int age, Pageable pageable);

    Page<StudentEntity> findTop10BySex(int sex, Pageable pageable);

    @Transactional
    @Query("select stu from StudentEntity as stu where stu.age = ?1 and stu.score = ?2")
    StudentEntity findByAgeAndScore(int age, int score);

    @Transactional(timeout = 1000)
    @Modifying
    @Query("delete from StudentEntity where name = ?1 and sex = ?2")
    void deleteStudentEntityByNameAndSex(String name, int sex);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("update StudentEntity stu set stu.name = ?1 where stu.id = ?2")
    void updateName(String name, long id);

}
