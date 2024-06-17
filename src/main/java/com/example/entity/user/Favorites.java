package com.example.entity.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * author:Ben
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Favorites {
    private static final long serialVersionUID = 1L;
    @TableId(value = "id",type = IdType.AUTO)
    private long id;

    @NotBlank(message  = "name your favorite")
    private String name;

    private String description;

    private Long userId;

    @TableField(exist = false)
    private Long vedioCount;
}
