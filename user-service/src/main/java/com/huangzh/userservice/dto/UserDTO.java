package com.huangzh.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author huangzh
 * @date 2021/3/2
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO {

    /**
     * 用户名称
     */
    private String userName;

    /**
     * 年龄
     */
    private Integer age;
}
