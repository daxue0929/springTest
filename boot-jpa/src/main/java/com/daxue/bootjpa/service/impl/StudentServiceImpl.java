package com.daxue.bootjpa.service.impl;

import com.daxue.bootjpa.dao.StudentDao;
import com.daxue.bootjpa.pojo.Student;
import com.daxue.bootjpa.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDao studentDao;

    @Override
    public List<Student> findAll() {
        return studentDao.findAll();
    }
}
