
package com.it.Mujakjung_be.member;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

// ✅ Boot 4.x: 패키지가 바뀜 (여기가 핵심)
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
 SpringBootTest = 애플리케이션을 "통째로" 띄우는 통합 테스트
 - Controller + Service + Repository + (설정에 따라) DB 연결까지 전부 로딩됨
*/
@SpringBootTest(
        // MOCK = 톰캣 같은 실제 서버는 안 띄우고, 서블릿 환경만 흉내내서 테스트
        webEnvironment = SpringBootTest.WebEnvironment.MOCK
)

/*
 AutoConfigureMockMvc = MockMvc를 스프링이 자동으로 만들어서 빈으로 등록해줌
 - 그래서 아래 @Autowired MockMvc가 가능해짐
*/
@AutoConfigureMockMvc
class MemberApiTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void joinTest() throws Exception {

        // 컨트롤러로 보낼 JSON 바디
        String json = """
        {
          "email": "test@test.com",
          "password": "test1234!",
          "name": "name"
        }
        """;

        // MockMvc로 "가짜 HTTP 요청" 보내기
        mockMvc.perform(
                        post("/api/member/join")
                                .contentType(MediaType.APPLICATION_JSON) // Content-Type: application/json
                                .content(json)                            // Body: 위 JSON
                )
                // 응답이 200 OK인지 검증
                .andExpect(status().isOk());
    }
}