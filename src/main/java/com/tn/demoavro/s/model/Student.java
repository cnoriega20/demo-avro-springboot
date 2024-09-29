package com.tn.demoavro.s.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {
    private String studentName;
    private String  studentId;
    private Integer age;
}
