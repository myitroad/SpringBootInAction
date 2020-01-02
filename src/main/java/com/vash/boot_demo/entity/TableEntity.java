package com.vash.boot_demo.entity;

import lombok.Data;

/**
 * 此类没有entity table id 等注解，使用jpa试
 */
@Data
public class TableEntity {

    private Integer id;

    private String name;

    private Integer age;

}
