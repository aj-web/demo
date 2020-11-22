package com.chezj.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotNull(message = "年龄不能为空")
    private Integer age;

    @NotBlank(message = "手机号不能为空")
    @Length(min = 6,max = 11)
    private String phone;

    @Email(message = "请输入邮箱")
    @NotBlank(message = "邮箱不能为空")
    private String email;

    private static final long serialVersionUID = 1L;


}