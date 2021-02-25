package io.dobson.rpcx;

public class StudentServiceImpl implements StudentService{
    @Override
    public Student findById(int id) {
        return Student.builder().id(1001).studentName("张三").build();
    }
}
