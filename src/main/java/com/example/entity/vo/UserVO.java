package com.example.entity.vo;

import lombok.Data;

/**
 * author:Ben
 */
@Data
public class UserVO {
    private Long id;

    private String nickName;

    private Long avatar;

    private Boolean sex;

    private String description;

    private Long follow;

    private Long fans;
}
