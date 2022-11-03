package com.lecture.querydsl_exam.dao;

import com.lecture.querydsl_exam.user.domain.SiteUser;
import com.lecture.querydsl_exam.user.domain.dao.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
public class UserRepositoryTests {

        @Autowired
        private UserRepository userRepository;

        @Test
        @DisplayName("회원 생성")
        void t1() {
            SiteUser u1 = SiteUser.builder()
                    .username("user1")
                    .password("{noop}1234")
                    .email("user1@test.com")
                    .build();
            SiteUser u2 = SiteUser.builder()
                    .username("user2")
                    .password("{noop}1234")
                    .email("user2@test.com")
                    .build();

            userRepository.saveAll(Arrays.asList(u1, u2));
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
    }


