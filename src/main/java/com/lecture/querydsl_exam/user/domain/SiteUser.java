package com.lecture.querydsl_exam.user.domain;

import com.lecture.querydsl_exam.interestKeyword.domain.InterestKeyword;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SiteUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;
    private String password;

    @Column(unique = true)
    private String email;

    //관심사는 중복되면 안됨. →  Set사용
    @ManyToMany(cascade = CascadeType.ALL) //여러 사람이 여러 관심사를 가질 수 있음 → N대 N 매핑
    @Builder.Default //다 null로 들어가는데 기본값을 입력하면 기본 입력값으로 들어가게 됨.(빈 셋)
    private Set<InterestKeyword> interestKeywords = new HashSet<>();
    public void addInterestKeywordContent(String keywordContent) {
        interestKeywords.add(new InterestKeyword(keywordContent));

    }



}