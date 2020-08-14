package com.daxue.bootjpa.pojo;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@Entity
public class Student implements Serializable {
    private static final long serialVersionUID = -787312994984079173L;

    @Id
    @Column(nullable = false, columnDefinition = "varchar(20) default ''")
    private String id;

    private Long sNo; // 学号

    @Column(nullable = false, columnDefinition = "varchar(50) default ''")
    private String name; // 姓名

    @Column(nullable = false, columnDefinition = "varchar(10) default ''")
    private String sex; // 性别

}
