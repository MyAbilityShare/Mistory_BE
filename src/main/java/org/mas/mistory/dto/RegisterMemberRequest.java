package org.mas.mistory.dto;

import lombok.Getter;

@Getter
public class RegisterMemberRequest {
    private String username;
    private String password;
    private String nickname;
    private String role;
}
