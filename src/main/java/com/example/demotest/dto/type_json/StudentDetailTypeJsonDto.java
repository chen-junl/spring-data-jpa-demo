package com.example.demotest.dto.type_json;

import com.example.demotest.dto.StudentDescriptionDto;
import lombok.Data;

import java.sql.Timestamp;

/**
 * @author chenjunl
 * @Description 表实体类
 * @date 2022-12-08 10:37:11
 */
@Data
public class StudentDetailTypeJsonDto {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 创建时间
     */
    private Timestamp gmtCreate;
    /**
     * 修改时间
     */
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
    private Integer studentId;
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
     * 描述json字段
     */
    private StudentDescriptionDto description;
}
