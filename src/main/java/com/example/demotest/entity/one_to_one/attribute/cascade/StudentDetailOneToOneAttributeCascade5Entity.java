package com.example.demotest.entity.one_to_one.attribute.cascade;

import com.example.demotest.entity.one_to_one.attribute.StudentOneToOneAttributeEntity;
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
public class StudentDetailOneToOneAttributeCascade5Entity {
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
     * 使用CascadeType.REFRESH 从数据库中刷新实例的状态，覆盖对实体所做的更改（如果有）。当多个用户同时作操作一个实体，为了用户取到的数据是实时的会重新查询数据库中的最新数据
     * 假设场景 有一个订单,订单里面关联了许多商品,这个订单可以被很多人操作,那么这个时候A对此订单和关联的商品进行了修改,与此同时,B也进行了相同的操作,但是B先一步比A保存了数据,那么当A保存数据的时候,就需要先刷新订单信息及关联的商品信息后,再将订单及商品保存
     */
    @OneToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "studentId")
    private StudentOneToOneAttributeEntity student;
}
