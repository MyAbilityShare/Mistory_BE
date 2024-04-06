package org.mas.mistory.controller;

import org.mas.mistory.dto.AddUserRequest;
import org.mas.mistory.entity.User;
import org.mas.mistory.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService; // User 서비스 객체 주입

    @PostMapping("/users/add")
    public ResponseEntity<User> addUser(@RequestBody AddUserRequest request) { // @RequestBody: http 요청의 본문을 자바 객체로 변환
        User created = userService.save(request);

        return (created != null) ? // 들어온 요청의 정보가 비어있지 않으면
                ResponseEntity.status(HttpStatus.OK).body(created) :
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    }

}
