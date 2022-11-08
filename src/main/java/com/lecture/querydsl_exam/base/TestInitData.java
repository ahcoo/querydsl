package com.lecture.querydsl_exam.base;


import com.lecture.querydsl_exam.user.dao.UserRepository;
import com.lecture.querydsl_exam.user.domain.SiteUser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;
import java.util.List;

@Configuration
@Profile("test") //이 클래스에 정의된 Bean들은 test모드에서만 활성화 됨
public class TestInitData {

    //CommandLineRunner : 앱 실행 직후 초기 데이터 세팅 및 초기화에 사용하는 클래스
    @Bean
    CommandLineRunner init(UserRepository userRepository) {
        return args -> {
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

            userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));
        };
    }
}
