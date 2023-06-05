package com.example.demotest.service;

import cn.hutool.core.bean.BeanUtil;
import com.example.demotest.dto.association.CourseAssociationStudentDto;
import com.example.demotest.dto.association.StudentAssociationCourseDto;
import com.example.demotest.entity.many_to_many.attribute.cascade.CourseManyToManyAttributeCascade0Entity;
import com.example.demotest.entity.many_to_many.attribute.cascade.CourseManyToManyAttributeCascade1Entity;
import com.example.demotest.entity.many_to_many.attribute.fetch.CourseManyToManyAttributeFetch1Entity;
import com.example.demotest.entity.many_to_many.attribute.fetch.CourseManyToManyAttributeFetch2Entity;
import com.example.demotest.entity.many_to_many.type1.CourseManyToManyType1Entity;
import com.example.demotest.entity.many_to_many.type1.StudentManyToManyType1Entity;
import com.example.demotest.entity.many_to_many.type2.CourseManyToManyType2Entity;
import com.example.demotest.entity.many_to_many.type2.StudentManyToManyType2Entity;
import com.example.demotest.entity.many_to_many.where_join_table.CourseManyToManyWhereEntity;
import com.example.demotest.entity.many_to_many.where_join_table.CourseManyToManyWhereJoinTableEntity;
import com.example.demotest.repository.many_to_many.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenjunl
 * @description
 * @date 2023/6/2
 */
@Service
public class ManyToManyService {

    @Autowired
    private CourseManyToManyType1EntityRepository courseManyToManyType1EntityRepository;
    @Autowired
    private StudentManyToManyType1EntityRepository studentManyToManyType1EntityRepository;
    @Autowired
    private CourseManyToManyType2EntityRepository courseManyToManyType2EntityRepository;
    @Autowired
    private StudentManyToManyType2EntityRepository studentManyToManyType2EntityRepository;
    @Autowired
    private CourseManyToManyAttributeFetch1EntityRepository courseManyToManyAttributeFetch1EntityRepository;
    @Autowired
    private CourseManyToManyAttributeFetch2EntityRepository courseManyToManyAttributeFetch2EntityRepository;
    @Autowired
    private CourseManyToManyAttributeCascade0EntityRepository courseManyToManyAttributeCascade0EntityRepository;
    @Autowired
    private CourseManyToManyAttributeCascade1EntityRepository courseManyToManyAttributeCascade1EntityRepository;
    @Autowired
    private CourseManyToManyWhereJoinTableEntityRepository courseManyToManyWhereJoinTableEntityRepository;
    @Autowired
    private CourseManyToManyWhereEntityRepository courseManyToManyWhereEntityRepository;

    public CourseAssociationStudentDto findCourse1ById(Integer id) {
        CourseManyToManyType1Entity entity = courseManyToManyType1EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, CourseAssociationStudentDto.class);
    }


    public StudentAssociationCourseDto findStudent1ById(Integer id) {
        StudentManyToManyType1Entity entity = studentManyToManyType1EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, StudentAssociationCourseDto.class);
    }

    public CourseAssociationStudentDto findCourse2ById(Integer id) {
        CourseManyToManyType2Entity entity = courseManyToManyType2EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, CourseAssociationStudentDto.class);
    }


    public StudentAssociationCourseDto findStudent2ById(Integer id) {
        StudentManyToManyType2Entity entity = studentManyToManyType2EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, StudentAssociationCourseDto.class);
    }


    //第0种类型 什么都不指定
    public CourseAssociationStudentDto findCourseAttributeCascade0ById(Integer id) {
        CourseManyToManyAttributeCascade0Entity entity = courseManyToManyAttributeCascade0EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, CourseAssociationStudentDto.class);
    }

    public CourseAssociationStudentDto insertCourseAttributeCascade0ById(CourseAssociationStudentDto dto) {
        //什么都不指定的时候,新增时必须传入student.id,新增course表,并且新增course_student表,不会校验student表中是否存在id为student.id的数据
        CourseManyToManyAttributeCascade0Entity entity = BeanUtil.copyProperties(dto, CourseManyToManyAttributeCascade0Entity.class);
        entity.setId(null);
        courseManyToManyAttributeCascade0EntityRepository.save(entity);
        return BeanUtil.copyProperties(entity, CourseAssociationStudentDto.class);
    }

    public CourseAssociationStudentDto updateCourseAttributeCascade0ById(Integer id, CourseAssociationStudentDto dto) {
        //什么都不指定的时候,更新时必须传入student.id,更新course表
        //数据库中存在1--->[a,b,c]
        //更新    1--->[]       a,b,c三条从course_student被物理删除
        //更新    1--->[a,b]    c从course_student被物理删除
        //更新    1--->[a,d]    c被物理删除 d新增
        //更新    1--->[a,b,c]  还是a,b,c三条数据
        //更新    1--->[e,f,g]  e,f,g三条数据
        //******注意更新的原理,是将原数据全部物理删除,然后在进行新增.无论本次值有没有变化,都是将旧数据全量删除,再新增本次的数据
        CourseManyToManyAttributeCascade0Entity entity = BeanUtil.copyProperties(dto, CourseManyToManyAttributeCascade0Entity.class);
        entity.setId(id);
        courseManyToManyAttributeCascade0EntityRepository.save(entity);
        return BeanUtil.copyProperties(entity, CourseAssociationStudentDto.class);
    }

    public boolean deleteCourseAttributeCascade0ById(Integer id) {
        //什么都不指定的时候,删除时,逻辑删除course表,同时将中间表级联数据全部物理删除
        courseManyToManyAttributeCascade0EntityRepository.deleteById(id);
        return true;
    }


    //第一种类型 CascadeType.ALL
    public CourseAssociationStudentDto findCourseAttributeCascade1ById(Integer id) {
        CourseManyToManyAttributeCascade1Entity entity = courseManyToManyAttributeCascade1EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, CourseAssociationStudentDto.class);
    }


    public CourseAssociationStudentDto insertCourseAttributeCascade1ById(CourseAssociationStudentDto dto) {
        //使用CascadeType.ALL,新增的时候,同时新增course,course_student,和student三张表,course的id和级联出来的student的id都要设置为null,否则报错******不推荐使用*******
        CourseManyToManyAttributeCascade1Entity entity = BeanUtil.copyProperties(dto, CourseManyToManyAttributeCascade1Entity.class);
        entity.setId(null);
        courseManyToManyAttributeCascade1EntityRepository.save(entity);
        return BeanUtil.copyProperties(entity, CourseAssociationStudentDto.class);
    }

    public CourseAssociationStudentDto updateCourseAttributeCascade1ById(Integer id, CourseAssociationStudentDto dto) {
        //使用CascadeType.ALL,更新的时候,同时更新course,course_student,和student三张表,级联出来的student.id如果为null就新增student,如果不为null就会更新student对象)
        CourseManyToManyAttributeCascade1Entity entity = BeanUtil.copyProperties(dto, CourseManyToManyAttributeCascade1Entity.class);
        entity.setId(id);
        courseManyToManyAttributeCascade1EntityRepository.save(entity);
        return BeanUtil.copyProperties(entity, CourseAssociationStudentDto.class);
    }

    public boolean deleteCourseAttributeCascade1ById(Integer id) {
        //使用CascadeType.ALL 删除时,逻辑删除course表,逻辑删除student表,物理删除course_student
        courseManyToManyAttributeCascade1EntityRepository.deleteById(id);
        return true;
    }


    //fetch第一种类型 Fetch.EAGER
    public CourseAssociationStudentDto findCourseAttributeFetch1ById(Integer id) {
        //生成查询SQL 一条语句 三张表并表连接
        //select coursemany0_.id as id1_0_0_, coursemany0_.creator as creator2_0_0_, coursemany0_.gmt_create as gmt_crea3_0_0_, coursemany0_.gmt_modified as gmt_modi4_0_0_, coursemany0_.is_delete as is_delet5_0_0_, coursemany0_.modifier as modifier6_0_0_, coursemany0_.sort_index as sort_ind7_0_0_, coursemany0_.title as title8_0_0_, students1_.course_id as course_i1_1_1_, studentman2_.id as student_2_1_1_, studentman2_.id as id1_2_2_, studentman2_.creator as creator2_2_2_, studentman2_.gmt_create as gmt_crea3_2_2_, studentman2_.gmt_modified as gmt_modi4_2_2_, studentman2_.is_delete as is_delet5_2_2_, studentman2_.modifier as modifier6_2_2_, studentman2_.sort_index as sort_ind7_2_2_, studentman2_.title as title8_2_2_ from course coursemany0_ left outer join course_student students1_ on coursemany0_.id=students1_.course_id left outer join student studentman2_ on students1_.student_id=studentman2_.id and ( studentman2_.is_delete=0) where coursemany0_.id=? and ( coursemany0_.is_delete=0);
        CourseManyToManyAttributeFetch1Entity entity = courseManyToManyAttributeFetch1EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, CourseAssociationStudentDto.class);
    }

    public List<CourseAssociationStudentDto> findCourseAttributeFetch1() {
        //一条查询course全部记录的语句+n条查询course_student和student连表查询的语句
        List<CourseManyToManyAttributeFetch1Entity> entityList = courseManyToManyAttributeFetch1EntityRepository.findAll();
        return BeanUtil.copyToList(entityList, CourseAssociationStudentDto.class);
    }

    //fetch第二种类型 Fetch.LAZY
    public CourseAssociationStudentDto findCourseAttributeFetch2ById(Integer id) {
        //生成查询SQL 两条语句,一条查询course表全部字段,另一条查询course_student和student并表查询两张表字段
        //select coursemany0_.id as id1_0_0_, coursemany0_.creator as creator2_0_0_, coursemany0_.gmt_create as gmt_crea3_0_0_, coursemany0_.gmt_modified as gmt_modi4_0_0_, coursemany0_.is_delete as is_delet5_0_0_, coursemany0_.modifier as modifier6_0_0_, coursemany0_.sort_index as sort_ind7_0_0_, coursemany0_.title as title8_0_0_ from course coursemany0_ where coursemany0_.id=? and ( coursemany0_.is_delete=0);
        //select students0_.course_id as course_i1_1_0_, students0_.student_id as student_2_1_0_, studentman1_.id as id1_2_1_, studentman1_.creator as creator2_2_1_, studentman1_.gmt_create as gmt_crea3_2_1_, studentman1_.gmt_modified as gmt_modi4_2_1_, studentman1_.is_delete as is_delet5_2_1_, studentman1_.modifier as modifier6_2_1_, studentman1_.sort_index as sort_ind7_2_1_, studentman1_.title as title8_2_1_ from course_student students0_ inner join student studentman1_ on students0_.student_id=studentman1_.id and ( studentman1_.is_delete=0) where students0_.course_id=?;
        CourseManyToManyAttributeFetch2Entity entity = courseManyToManyAttributeFetch2EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, CourseAssociationStudentDto.class);
    }

    public List<CourseAssociationStudentDto> findCourseAttributeFetch2() {
        //一条查询course全部记录的语句+n条查询course_student和student连表查询的语句
        List<CourseManyToManyAttributeFetch2Entity> entityList = courseManyToManyAttributeFetch2EntityRepository.findAll();
        return BeanUtil.copyToList(entityList, CourseAssociationStudentDto.class);
    }


    public CourseAssociationStudentDto findCourseWhereById(Integer id) {
        //使用Where生成的sql
        //select students0_.course_id as course_i1_1_0_, students0_.student_id as student_2_1_0_, studentman1_.id as id1_2_1_, studentman1_.creator as creator2_2_1_, studentman1_.gmt_create as gmt_crea3_2_1_, studentman1_.gmt_modified as gmt_modi4_2_1_, studentman1_.is_delete as is_delet5_2_1_, studentman1_.modifier as modifier6_2_1_, studentman1_.sort_index as sort_ind7_2_1_, studentman1_.title as title8_2_1_ from course_student students0_ inner join student studentman1_ on students0_.student_id=studentman1_.id and ( ( studentman1_.is_delete=0 ) and ( studentman1_.gmt_create >'2023-06-02 10:49:46' )) where students0_.course_id=?
        CourseManyToManyWhereEntity entity = courseManyToManyWhereEntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, CourseAssociationStudentDto.class);
    }

    /**
     * 和Where对比
     * 两者获取结果相同,
     *
     * @param id
     * @return
     */
    public CourseAssociationStudentDto findCourseWhereJoniTableById(Integer id) {
        //使用WhereJoniTable生成的sql,获得结果相同,不同的是Where的查询条件是加在SQL最后,WhereJoniTable的条件是加在并表的时候,优化了并表产生的笛卡尔积大小
        //select students0_.course_id as course_i1_1_0_, students0_.student_id as student_2_1_0_, studentman1_.id as id1_2_1_, studentman1_.creator as creator2_2_1_, studentman1_.gmt_create as gmt_crea3_2_1_, studentman1_.gmt_modified as gmt_modi4_2_1_, studentman1_.is_delete as is_delet5_2_1_, studentman1_.modifier as modifier6_2_1_, studentman1_.sort_index as sort_ind7_2_1_, studentman1_.title as title8_2_1_ from course_student students0_ inner join student studentman1_ on students0_.student_id=studentman1_.id and ( studentman1_.is_delete=0) where ( students0_.gmt_create >'2023-06-02 10:49:46') and students0_.course_id=?
        CourseManyToManyWhereJoinTableEntity entity = courseManyToManyWhereJoinTableEntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, CourseAssociationStudentDto.class);
    }

}
