package com.lecture.querydsl_exam.user.domain.dao;

import com.lecture.querydsl_exam.user.domain.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SiteUser, Long>, UserRepositoryCustom {

}
