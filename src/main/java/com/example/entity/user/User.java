package com.example.entity.user;

import com.baomidou.mybatisplus.annotation.TableField;
import com.example.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.Set;

/**
 * author:Ben
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User extends BaseEntity {
    private static final long serialVersionID = 1L;
    private String nickname;

    @Email
    private String email;

    @NotBlank
    private String password;

    private Boolean sex;

    private Long defaultFavoritesId;

    private Long avatar;

    @TableField(exist = false)
    private Boolean each;

    @TableField(exist = false)
    private Set<String> roleName;

}
