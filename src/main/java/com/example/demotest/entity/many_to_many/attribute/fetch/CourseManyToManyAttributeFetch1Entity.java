package com.example.demotest.entity.many_to_many.attribute.fetch;

import com.example.demotest.entity.many_to_many.attribute.StudentManyToManyAttributeEntity;
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
@Table(name = "course")
@SQLDelete(sql = "UPDATE course SET is_delete=1 WHERE id=?")
@Where(clause = "is_delete=0")
public class CourseManyToManyAttributeFetch1Entity {
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
     * 学生对象
     */
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "course_student",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id")
    )
    private List<StudentManyToManyAttributeEntity> students;
}
