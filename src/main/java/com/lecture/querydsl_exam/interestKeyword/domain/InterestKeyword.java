package com.lecture.querydsl_exam.interestKeyword.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InterestKeyword {

    @Id
    private String content;

    //중복된 것들이 삭제 됨.
    @Override
    public boolean equals(Object o) {
        if ( this == o )  return true;
        //중복되면 false로 값을 받지 않음.
        if ( !(o instanceof InterestKeyword) ) return false;
        InterestKeyword interestKeyword = (InterestKeyword) o;
        return content.equals(interestKeyword.content);
    }

    @Override
    public int hashCode() {

        return content.hashCode();
    }
}
