package com.catpp.springboot.common;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * com.catpp.springboot.common
 *
 * @Author cat_pp
 * @Date 2018/8/31
 * @Description 账号信息
 */
@Data
public class AccountDto {

    // 员工id
    private Long id;
    // 中文名称
    private String name;
    // 工号
    private String staffNo;
    // 手机号
    private String mobile;
    // 头像
    private String avatar;
    // 岗位id
    private Long positionId;
    // 性别
    private Integer sex;

    private boolean isSuperAdmin = false;
}
