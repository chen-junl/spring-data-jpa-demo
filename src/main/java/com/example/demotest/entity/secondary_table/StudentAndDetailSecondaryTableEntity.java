package com.example.demotest.entity.secondary_table;

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
@Table(name = "student")
@SecondaryTable(name = "student_detail", pkJoinColumns = {
        @PrimaryKeyJoinColumn(name = "studentId")
})
@SQLDelete(sql = "UPDATE student SET is_delete=1 WHERE id=?")
@Where(clause = "is_delete=0")
public class StudentAndDetailSecondaryTableEntity {
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
     *
     */
    @Column(table = "student_detail")
    private Integer age;
    /**
     *
     */
    @Column(table = "student_detail")
    private String email;
    /**
     *
     */
    @Column(table = "student_detail")
    private String address;

}
