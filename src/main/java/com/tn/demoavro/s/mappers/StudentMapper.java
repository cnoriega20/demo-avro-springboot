package com.tn.demoavro.s.mappers;

import com.tn.demoavro.s.generated.AvroStudent;
import com.tn.demoavro.s.model.Student;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper
public interface StudentMapper {
    @Mapping(source = "studentName", target = "studentName", qualifiedByName = "charSequenceToString" )
    @Mapping(source = "studentId", target = "studentId", qualifiedByName = "charSequenceToString")
    @Mapping(source = "age", target = "age")
    Student  convertAvroToStudent(AvroStudent avroStudent);

    @Named("charSequenceToString")
    default String map(CharSequence value) {
        return value != null ? value.toString() : null;
    }

    AvroStudent convertStudentToAvro(Student student);
}
