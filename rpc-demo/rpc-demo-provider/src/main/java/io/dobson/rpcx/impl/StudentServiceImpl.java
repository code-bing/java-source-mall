package io.dobson.rpcx.impl;

import io.dobson.rpcx.api.Student;
import io.dobson.rpcx.api.StudentService;

public class StudentServiceImpl implements StudentService {
    @Override
    public Student findById(int id) {
        return new Student(10001,"张三");
    }
}
