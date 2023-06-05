package com.example.demotest.entity.not_found;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.*;

import javax.persistence.Entity;
import javax.persistence.Table;
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
@Table(name = "student_book")
@SQLDelete(sql = "UPDATE student_book SET is_delete=1 WHERE id=?")
@Where(clause = "is_delete=0")
public class StudentBooksNotFoundManyToOneEntity {
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
     * 标题
     */
    private String title;
    /**
     * 价格
     */
    private float price = 0.1f;
    /**
     * 学生
     * 单向主动关联,使用JoinColumn物理属性student_id
     * (由于已经声明过student_book映射的对象,并且对象中含有studentId,所有使用逻辑属性studentId)
     */
    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "studentId")
    private StudentNotFoundManyToOneEntity student;
}
