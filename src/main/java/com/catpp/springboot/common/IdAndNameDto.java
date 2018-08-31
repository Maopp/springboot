package com.catpp.springboot.common;

import lombok.Data;

import java.io.Serializable;

/**
 * com.catpp.springboot.common
 *
 * @Author cat_pp
 * @Date 2018/8/31
 * @Description
 */
@Data
public class IdAndNameDto implements Serializable {

    private static final long serialVersionUID = -6367438004569115160L;

    private Long id;
    private String name;
}
