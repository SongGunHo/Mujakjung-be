package org.koreait.member.dto;

import lombok.Data;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class MemberDto {
    private Long mId; // 아이디
    private String password;// 비밀 번호
    private String PasswordConfirm;// 2차 비밀 번호
    private String Name;// 이름
    private String Rrn;// 주민 번호
    private String Address;// 주소
    private LocalDate BairthDate;// 생월 일

}
