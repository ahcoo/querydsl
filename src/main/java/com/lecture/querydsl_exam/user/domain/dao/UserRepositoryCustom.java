package com.lecture.querydsl_exam.user.domain.dao;

import com.lecture.querydsl_exam.user.domain.SiteUser;

public interface UserRepositoryCustom {
    SiteUser getQslUser(Long id);
}

