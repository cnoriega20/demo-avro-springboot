package com.tn.demoavro.s.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String studentName;
    private String  studentId;
    private Integer age;
}
