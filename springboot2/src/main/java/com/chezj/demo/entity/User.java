package com.chezj.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author bangsun
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors
public class User implements Serializable {
    private Integer id;

    private String username;

    private Integer age;

    private String phone;

    private String email;

    private static final long serialVersionUID = 1L;


}