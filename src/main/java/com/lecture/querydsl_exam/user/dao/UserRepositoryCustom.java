package com.lecture.querydsl_exam.user.dao;

import com.lecture.querydsl_exam.user.domain.SiteUser;

import java.util.List;

public interface UserRepositoryCustom {
    SiteUser getQslUser(Long id);


    //전체 회원수를 반환하는 코딩 제작. 커스텀에서 만들고 임플에서 구현
    long getQslUserCount();


    List<SiteUser> getQslUsersOrderByAsc();

    List<SiteUser> getQslUsersByInterestkeyword(String content);
}

