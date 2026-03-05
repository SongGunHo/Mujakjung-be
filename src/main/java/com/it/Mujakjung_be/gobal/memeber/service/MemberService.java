package com.it.Mujakjung_be.gobal.memeber.service;

import com.it.Mujakjung_be.gobal.memeber.dto.JoinRequest;
import com.it.Mujakjung_be.gobal.memeber.entity.MemberEntity;
import com.it.Mujakjung_be.gobal.memeber.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

@Service
@RequiredArgsConstructor // final 필드 생성자 자동 생성 , 의존성 주입
public class MemberService {

    private final MemberRepository repository;
    private final PasswordEncoder encoder;


    public void save(JoinRequest request){
        MemberEntity member = new MemberEntity();
        member.setEmail(request.getEmail());
        member.setPassword(request.getPassword(encoder.encode(request.getPassword())));
        member.setName(request.getName());
    }




}
