package com.lecture.querydsl_exam.dao;

import com.lecture.querydsl_exam.user.dao.UserRepository;
import com.lecture.querydsl_exam.user.domain.SiteUser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@ActiveProfiles("test")
//        @Transactional //Test가 끝나고 롤백됨
public class UserRepositoryTests {

        @Autowired
        private UserRepository userRepository;

        @Test
        @DisplayName("회원 생성")
        void t1() {

            SiteUser u3 = SiteUser.builder()
                    .username("user3")
                    .password("{noop}1234")
                    .email("user3@test.com")
                    .build();
            SiteUser u4 = SiteUser.builder()
                    .username("user4")
                    .password("{noop}1234")
                    .email("user4@test.com")
                    .build();
            SiteUser u5 = SiteUser.builder()
                    .username("user5")
                    .password("{noop}1234")
                    .email("user5@test.com")
                    .build();
            SiteUser u6 = SiteUser.builder()
                    .username("user6")
                    .password("{noop}1234")
                    .email("user6@test.com")
                    .build();

            userRepository.saveAll(Arrays.asList(u3, u4, u5, u6));
            System.out.println("ArraysList : " + Arrays.asList());
        }

        @Test
        @DisplayName("1번 회원 조회")
        void t2() {
                SiteUser su = userRepository.getQslUser(1L);

                assertThat(su.getId()).isEqualTo(1L);
                assertThat(su.getUsername()).isEqualTo("user1");
                assertThat(su.getPassword()).isEqualTo("{noop}1234");
                assertThat(su.getEmail()).isEqualTo("user1@test.com");
            }

    @Test
    @DisplayName("회원 수 조회")
    void t3() {
        long count = userRepository.getQslUserCount();
        assertThat(count)
                .isEqualTo(2);
    }


    @Test
    @DisplayName("회원 가장오래된순으로 정렬후 조회")
    void t4() {
        List<SiteUser> users = userRepository.getQslUsersOrderByAsc();
        assertThat(users.get(0).getId())
                .isEqualTo(1);
    }

    @Test
    @DisplayName("회원에게 관심사 등록")
    @Rollback(value = false)
    void t5() {
            SiteUser su = userRepository.findById(2L).orElseThrow();

            su.addInterestKeywordContent("축구");
            su.addInterestKeywordContent("농구");
            su.addInterestKeywordContent("달리기");
            su.addInterestKeywordContent("달리기");


    }




    }


