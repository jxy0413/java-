package cn.test.druid.model;

import lombok.Data;
import lombok.ToString;

/**
 * @Auther jxy
 * @Date 2020-04-20
 */
@Data
@ToString
public class Employee {
    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;
    private Integer dId;
}
