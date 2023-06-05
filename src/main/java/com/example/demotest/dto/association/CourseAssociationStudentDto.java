package com.example.demotest.dto.association;

import com.example.demotest.dto.StudentDto;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;

/**
 * @author chenjunl
 * @Description 表实体类
 * @date 2022-12-08 10:37:11
 */
@Data
public class CourseAssociationStudentDto {
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
     * 标题
     */
    private String title;
    /**
     * 学生
     */
    private List<StudentDto> students;
}
