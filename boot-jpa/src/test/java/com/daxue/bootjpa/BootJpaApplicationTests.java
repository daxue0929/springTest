package com.daxue.bootjpa;

import com.daxue.bootjpa.pojo.Student;
import com.daxue.bootjpa.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Slf4j
class BootJpaApplicationTests {

    @Autowired
    StudentService studentService;


    @Test
    void contextLoads() {
        List<Student> list = studentService.findAll();
        log.info("result: {}", list.toString());
    }

}
