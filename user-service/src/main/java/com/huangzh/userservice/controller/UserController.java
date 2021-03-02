package com.huangzh.userservice.controller;

import com.huangzh.userservice.dto.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huangzh
 * @date 2021/3/2
 */

@RestController
@RequestMapping("/user")
public class UserController {


    @GetMapping("/{id}")
    public UserDTO get(@PathVariable String id){
        return new UserDTO("帅哥", 18);
    }
}
