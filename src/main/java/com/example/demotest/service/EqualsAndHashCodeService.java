package com.example.demotest.service;

import com.example.demotest.entity.StudentEntity;
import com.example.demotest.entity.equals_and_hashcode.StudentExtendBase1Entity;
import com.example.demotest.entity.equals_and_hashcode.StudentExtendBase2Entity;
import com.example.demotest.entity.equals_and_hashcode.StudentExtendBase3Entity;
import com.example.demotest.entity.equals_and_hashcode.StudentWithoutHashCodeEntity;
import com.example.demotest.entity.equals_and_hashcode.association.StudentAssociationHashCodeEntity;
import com.example.demotest.entity.equals_and_hashcode.association.StudentDetailAssociationHashCode1Entity;
import com.example.demotest.entity.equals_and_hashcode.association.StudentDetailAssociationHashCode2Entity;
import com.example.demotest.repository.equals_and_hashcode.StudentDetailAssociationHashCode1EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author chenjunl
 * @description
 * @date 2023/4/23
 */
@Service
public class EqualsAndHashCodeService {

    @Autowired
    private StudentDetailAssociationHashCode1EntityRepository studentDetailAssociationHashCode1EntityRepository;

    public boolean testEqualsAndHashCode() {
        StudentWithoutHashCodeEntity student1 = new StudentWithoutHashCodeEntity();
        student1.setId(1);
        student1.setTitle("cjl");
        StudentWithoutHashCodeEntity student2 = new StudentWithoutHashCodeEntity();
        student2.setId(1);
        student2.setTitle("cjl");
        //false *****对比的是地址******* 直接使用引用地址对比
        System.out.println("没有继承,没有重写hashCode,equals对比结果--->" + student1.equals(student2));


        StudentEntity student3 = new StudentEntity();
        student3.setId(1);
        student3.setTitle("cjl");
        StudentEntity student4 = new StudentEntity();
        student4.setId(1);
        student4.setTitle("cjl");
        //true √ 使用属性的值对比
        System.out.println("没有继承,重写hashCode,equals对比结果--->" + student3.equals(student4));

        StudentEntity student31 = new StudentEntity();
        student31.setId(1);
        student31.setTitle("cjl");
        StudentEntity student41 = new StudentEntity();
        student41.setId(2);
        student41.setTitle("cjl");
        //false √ 使用属性的值对比
        System.out.println("没有继承,重写hashCode,id不同,equals对比结果--->" + student31.equals(student41));


        StudentExtendBase1Entity student5 = new StudentExtendBase1Entity();
        student5.setId(1);
        student5.setTitle("cjl");
        StudentExtendBase1Entity student6 = new StudentExtendBase1Entity();
        student6.setId(1);
        student6.setTitle("cjl");
        //true √ 子类和父类的共有属性都使用值取对比
        System.out.println("有继承,重写hashCode,父类重写hashcode,子类callSuper=true,equals对比结果--->" + student5.equals(student6));

        StudentExtendBase1Entity student51 = new StudentExtendBase1Entity();
        student51.setId(1);
        student51.setTitle("cjl");
        StudentExtendBase1Entity student61 = new StudentExtendBase1Entity();
        student61.setId(2);
        student61.setTitle("cjl");
        //false √ 子类和父类的共有属性都使用值取对比
        System.out.println("有继承,重写hashCode,父类重写hashcode,id不同,子类callSuper=true,equals对比结果--->" + student51.equals(student61));


        StudentExtendBase2Entity student7 = new StudentExtendBase2Entity();
        student7.setId(1);
        student7.setTitle("cjl");
        StudentExtendBase2Entity student8 = new StudentExtendBase2Entity();
        student8.setId(2);
        student8.setTitle("cjl");
        //true *****究极严重错误******* 忽略掉了父类属性,相当于没有id
        System.out.println("有继承,重写hashCode,父类没有重写hashcode,id不同,子类callSuper=false,equals对比结果--->" + student7.equals(student8));


        StudentExtendBase3Entity student9 = new StudentExtendBase3Entity();
        student9.setId(1);
        student9.setTitle("cjl");
        StudentExtendBase3Entity student10 = new StudentExtendBase3Entity();
        student10.setId(2);
        student10.setTitle("cjl");
        //true *****究极严重错误******* 忽略掉了父类属性,相当于没有id
        System.out.println("有继承,重写hashCode,父类重写hashcode,id不同,子类callSuper=false,equals对比结果--->" + student9.equals(student10));


        StudentDetailAssociationHashCode1Entity studentDetailEntity1 = new StudentDetailAssociationHashCode1Entity();
        studentDetailEntity1.setId(1);
        studentDetailEntity1.setAge(18);
        StudentAssociationHashCodeEntity student11 = new StudentAssociationHashCodeEntity();
        student11.setId(1);
        studentDetailEntity1.setStudent(student11);

        StudentDetailAssociationHashCode1Entity studentDetailEntity2 = new StudentDetailAssociationHashCode1Entity();
        studentDetailEntity2.setId(1);
        studentDetailEntity2.setAge(18);
        StudentAssociationHashCodeEntity student12 = new StudentAssociationHashCodeEntity();
        student12.setId(2);
        studentDetailEntity2.setStudent(student12);
        //true *****普通严重错误******* 由于级联对象被排除 相当于没有级联属性, 即使级联出来是不同的对象,也还是认为相等
        System.out.println("有级联,重写hashCode,排除级联字段,并且级联对象不同,equals对比结果--->" + studentDetailEntity1.equals(studentDetailEntity2));


        StudentDetailAssociationHashCode2Entity studentDetailEntity3 = new StudentDetailAssociationHashCode2Entity();
        studentDetailEntity3.setId(1);
        studentDetailEntity3.setAge(18);
        StudentAssociationHashCodeEntity student13 = new StudentAssociationHashCodeEntity();
        student13.setId(1);
        studentDetailEntity3.setStudent(student13);
        studentDetailEntity3.setStudentId(1);

        StudentDetailAssociationHashCode2Entity studentDetailEntity4 = new StudentDetailAssociationHashCode2Entity();
        studentDetailEntity4.setId(1);
        studentDetailEntity4.setAge(18);
        StudentAssociationHashCodeEntity student14 = new StudentAssociationHashCodeEntity();
        student14.setId(2);
        studentDetailEntity4.setStudent(student14);
        studentDetailEntity4.setStudentId(2);
        //false √ 由于级联对象被排除 但是手动声明级联的字段,还是使用字段值进行比较
        System.out.println("有级联,重写hashCode,排除级联字段,并且级联对象不同,equals对比结果--->" + studentDetailEntity3.equals(studentDetailEntity4));

        return true;
    }

}
