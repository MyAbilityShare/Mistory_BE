package org.mas.mistory.dto;

import lombok.Getter;
import org.mas.mistory.entity.User;

@Getter
public class UserResponse {
    private String loginId;
    private String userPw;
    private String userName;

    public UserResponse(User user) {
        this.loginId = user.getLoginId();
        this.userPw = user.getUserPw();
        this.userName = user.getUserName();
    }
}
