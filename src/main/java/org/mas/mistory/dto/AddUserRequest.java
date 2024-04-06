package org.mas.mistory.dto;

// User 가입 요청 데이터를 받는 dto

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.mas.mistory.entity.User;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AddUserRequest {
    private String loginId;
    private String userPw;
    private String userName;

    public User toEntity() {
        return User.builder()
                .loginId(loginId)
                .userPw(userPw)
                .userName(userName)
                .build();
    }
}
