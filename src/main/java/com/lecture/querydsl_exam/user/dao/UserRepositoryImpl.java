package com.lecture.querydsl_exam.user.dao;


import com.lecture.querydsl_exam.interestKeyword.domain.QInterestKeyword;
import com.lecture.querydsl_exam.user.QSiteUser;
import com.lecture.querydsl_exam.user.domain.SiteUser;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.lecture.querydsl_exam.interestKeyword.domain.QInterestKeyword.interestKeyword;
import static com.lecture.querydsl_exam.user.domain.QSiteUser.siteUser;

@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public SiteUser getQslUser(Long id) {
        /*
        SELECT *
        FROM site_user
        WHERE id = 1
         */

        return jpaQueryFactory
                .select(QSiteUser.siteUser)
                .from(QSiteUser.siteUser)
                .where(QSiteUser.siteUser.id.eq(id))
                .fetchOne();
    }

    @Override
    public long getQslUserCount() {
        return jpaQueryFactory
                .select(siteUser.count())
                .from(siteUser)
                .fetchOne();

    }

    @Override
    public List<SiteUser> getQslUsersOrderByAsc() {
        return jpaQueryFactory
                .select(siteUser)
                .from(siteUser)
                .orderBy(siteUser.id.asc())
                .fetch();
    }

    @Override
    public List<SiteUser> getQslUsersByInterestKeyword(String keywordContent) {
        return jpaQueryFactory
                .select(siteUser)
                .from(siteUser)
                .innerJoin(siteUser.interestKeywords, interestKeyword)
                .where(interestKeyword.content.eq(keywordContent))

                .fetch();
    }
}
