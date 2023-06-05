package com.example.demotest.entity.one_to_one.type1;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author chenjunl
 * @Description 表实体类
 * @date 2022-12-08 10:37:11
 */
@Getter
@Setter
@Entity
@Table(name = "student_detail")
@SQLDelete(sql = "UPDATE student_detail SET is_delete=1 WHERE id=?")
@Where(clause = "is_delete=0")
public class StudentDetailOneToOneType1Entity {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 创建时间
     */
    @CreationTimestamp
    private Timestamp gmtCreate;
    /**
     * 修改时间
     */
    @UpdateTimestamp
    private Timestamp gmtModified;
    /**
     * 创建者
     */
    private String creator;
    /**
     * 修改者
     */
    private String modifier;
    /**
     * 是否删除
     */
    private boolean isDelete;
    /**
     * 排序
     */
    private float sortIndex = 99;
    /**
     *
     */
    private Integer age;
    /**
     * email
     */
    private String email;
    /**
     * 地址
     */
    private String address;
    /**
     * 学生详细信息
     * 单向主动关联,使用JoinColumn物理属性student_id
     * (由于已经声明过student_detail映射的对象,并且对象中含有studentId,所有使用逻辑属性studentId)
     */
    @OneToOne
    @JoinColumn(name = "studentId")
    private StudentOneToOneType1Entity student;

}
