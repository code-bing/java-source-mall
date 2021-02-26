package io.dobson.rpcx;

import io.dobson.rpcx.api.Student;
import io.dobson.rpcx.api.StudentService;
import io.dobson.rpcx.client.proxy.ClientProxy;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConsumerApplication {

    public static void main(String[] args) {
        StudentService studentService = ClientProxy.createProxy(StudentService.class, "http://localhost:8088/");
        Student student = studentService.findById(123);
        System.out.println(student);

    }
}
