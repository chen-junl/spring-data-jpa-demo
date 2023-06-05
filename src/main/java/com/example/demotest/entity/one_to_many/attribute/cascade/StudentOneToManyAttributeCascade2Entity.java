package com.example.demotest.entity.one_to_many.attribute.cascade;

import com.example.demotest.entity.one_to_many.attribute.StudentBookOneToManyAttributeEntity;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author chenjunl
 * @Description 表实体类
 * @date 2022-12-08 10:37:11
 */
@Getter
@Setter
@Entity
@Table(name = "student")
@SQLDelete(sql = "UPDATE student SET is_delete=1 WHERE id=?")
@Where(clause = "is_delete=0")
public class StudentOneToManyAttributeCascade2Entity {
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
     * 学生书本集合
     */
    @OneToMany(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "studentId")
    private List<StudentBookOneToManyAttributeEntity> books;
}
