package io.dobson.rpcx;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
    private Integer id;
    private String studentName;
}
