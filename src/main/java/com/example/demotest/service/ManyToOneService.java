package com.example.demotest.service;

import cn.hutool.core.bean.BeanUtil;
import com.example.demotest.dto.association.BookAssociationStudentDto;
import com.example.demotest.dto.association.StudentAssociationBooksDto;
import com.example.demotest.entity.many_to_one.attribute.fetch.StudentBooksManyToOneAttributeFetch1Entity;
import com.example.demotest.entity.many_to_one.attribute.fetch.StudentBooksManyToOneAttributeFetch2Entity;
import com.example.demotest.entity.many_to_one.attribute.optional.StudentBooksManyToOneAttributeOptional1Entity;
import com.example.demotest.entity.many_to_one.attribute.optional.StudentBooksManyToOneAttributeOptional2Entity;
import com.example.demotest.entity.many_to_one.type1.StudentBooksManyToOneType1Entity;
import com.example.demotest.entity.many_to_one.type1.StudentManyToOneType1Entity;
import com.example.demotest.entity.many_to_one.type2.StudentBooksManyToOneType2Entity;
import com.example.demotest.entity.many_to_one.type2.StudentManyToOneType2Entity;
import com.example.demotest.repository.many_to_one.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenjunl
 * @description
 * @date 2023/5/31
 */
@Service
public class ManyToOneService {

    @Autowired
    private StudentManyToOneType1EntityRepository studentManyToOneType1EntityRepository;
    @Autowired
    private StudentBooksManyToOneType1EntityRepository studentBooksManyToOneType1EntityRepository;
    @Autowired
    private StudentManyToOneType2EntityRepository studentManyToOneType2EntityRepository;
    @Autowired
    private StudentBooksManyToOneType2EntityRepository studentBooksManyToOneType2EntityRepository;
    @Autowired
    private StudentBooksManyToOneAttributeFetch1EntityRepository studentBooksManyToOneAttributeFetch1EntityRepository;
    @Autowired
    private StudentBooksManyToOneAttributeFetch2EntityRepository studentBooksManyToOneAttributeFetch2EntityRepository;
    @Autowired
    private StudentBooksManyToOneAttributeOptional1EntityRepository studentBooksManyToOneAttributeOptional1EntityRepository;
    @Autowired
    private StudentBooksManyToOneAttributeOptional2EntityRepository studentBooksManyToOneAttributeOptional2EntityRepository;


    public BookAssociationStudentDto findBook1ById(Integer id) {
        StudentBooksManyToOneType1Entity entity = studentBooksManyToOneType1EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, BookAssociationStudentDto.class);
    }


    public StudentAssociationBooksDto findStudent1ById(Integer id) {
        StudentManyToOneType1Entity entity = studentManyToOneType1EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, StudentAssociationBooksDto.class);
    }


    public StudentAssociationBooksDto findStudent2ById(Integer id) {
        StudentManyToOneType2Entity entity = studentManyToOneType2EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, StudentAssociationBooksDto.class);
    }


    public BookAssociationStudentDto findBook2ById(Integer id) {
        StudentBooksManyToOneType2Entity entity = studentBooksManyToOneType2EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, BookAssociationStudentDto.class);
    }

    //fetch第一种类型 Fetch.EAGER
    public BookAssociationStudentDto findBookAttributeFetch1ById(Integer id) {
        //生成查询SQL 一条语句两张表并起来,返回所有字段
        //select studentboo0_.id as id1_3_0_, studentboo0_.creator as creator2_3_0_, studentboo0_.gmt_create as gmt_crea3_3_0_, studentboo0_.gmt_modified as gmt_modi4_3_0_, studentboo0_.is_delete as is_delet5_3_0_, studentboo0_.modifier as modifier6_3_0_, studentboo0_.price as price10_3_0_, studentboo0_.sort_index as sort_ind7_3_0_, studentboo0_.student_id as student_8_3_0_, studentboo0_.title as title9_3_0_, studentman1_.id as id1_2_1_, studentman1_.creator as creator2_2_1_, studentman1_.gmt_create as gmt_crea3_2_1_, studentman1_.gmt_modified as gmt_modi4_2_1_, studentman1_.is_delete as is_delet5_2_1_, studentman1_.modifier as modifier6_2_1_, studentman1_.sort_index as sort_ind7_2_1_, studentman1_.title as title8_2_1_ from student_book studentboo0_ left outer join student studentman1_ on studentboo0_.student_id=studentman1_.id where studentboo0_.id=? and ( studentboo0_.is_delete=0);
        StudentBooksManyToOneAttributeFetch1Entity entity = studentBooksManyToOneAttributeFetch1EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, BookAssociationStudentDto.class);
    }

    public List<BookAssociationStudentDto> findBookAttributeFetch1() {
        //一条查询book全部记录的语句+n条查询student的语句
        List<StudentBooksManyToOneAttributeFetch1Entity> entityList = studentBooksManyToOneAttributeFetch1EntityRepository.findAll();
        return BeanUtil.copyToList(entityList, BookAssociationStudentDto.class);
    }


    //fetch第二种类型 Fetch.LAZY
    public BookAssociationStudentDto findBookAttributeFetch2ById(Integer id) {
        //生成查询SQL 两条语句,两张表分别查询各自字段
        //select studentboo0_.id as id1_3_0_, studentboo0_.creator as creator2_3_0_, studentboo0_.gmt_create as gmt_crea3_3_0_, studentboo0_.gmt_modified as gmt_modi4_3_0_, studentboo0_.is_delete as is_delet5_3_0_, studentboo0_.modifier as modifier6_3_0_, studentboo0_.price as price10_3_0_, studentboo0_.sort_index as sort_ind7_3_0_, studentboo0_.student_id as student_8_3_0_, studentboo0_.title as title9_3_0_ from student_book studentboo0_ where studentboo0_.id=? and ( studentboo0_.is_delete=0);
        //select studentman0_.id as id1_2_0_, studentman0_.creator as creator2_2_0_, studentman0_.gmt_create as gmt_crea3_2_0_, studentman0_.gmt_modified as gmt_modi4_2_0_, studentman0_.is_delete as is_delet5_2_0_, studentman0_.modifier as modifier6_2_0_, studentman0_.sort_index as sort_ind7_2_0_, studentman0_.title as title8_2_0_ from student studentman0_ where studentman0_.id=? and ( studentman0_.is_delete=0);
        StudentBooksManyToOneAttributeFetch2Entity entity = studentBooksManyToOneAttributeFetch2EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, BookAssociationStudentDto.class);
    }

    public List<BookAssociationStudentDto> findBookAttributeFetch2() {
        //一条查询book全部记录的语句+n条查询student的语句
        List<StudentBooksManyToOneAttributeFetch2Entity> entityList = studentBooksManyToOneAttributeFetch2EntityRepository.findAll();
        return BeanUtil.copyToList(entityList, BookAssociationStudentDto.class);
    }


    //optional第一种类型 optional=true
    public BookAssociationStudentDto findBookAttributeOptional1ById(Integer id) {
        //如果数据库中studentDetail表的student_id为null 数据可以查询出来,只是级联出来的student对象为null
        //如果数据库中studentDetail表的student_id为一条不存在的student数据 整个entity对象都查询不出来
        StudentBooksManyToOneAttributeOptional1Entity entity = studentBooksManyToOneAttributeOptional1EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, BookAssociationStudentDto.class);
    }

    public BookAssociationStudentDto insertBookAttributeOptional1ById(BookAssociationStudentDto dto) {
        //新增的时候允许级联字段为null,新增出来的studentBook记录的studentId为null
        //新增的时候不会检查student.id对应的student是否存在,如果不存在查询的时候会整条数据找不到
        StudentBooksManyToOneAttributeOptional1Entity entity = BeanUtil.copyProperties(dto, StudentBooksManyToOneAttributeOptional1Entity.class);
        entity.setId(null);
        studentBooksManyToOneAttributeOptional1EntityRepository.save(entity);
        return BeanUtil.copyProperties(entity, BookAssociationStudentDto.class);
    }


    //optional第二种类型 optional=false
    public BookAssociationStudentDto findBookAttributeOptional2ById(Integer id) {
        //如果数据库中studentDetail表的student_id为null 整个entity对象都查询不出来
        //如果数据库中studentDetail表的student_id为一条不存在的student数据 整个entity对象都查询不出来
        StudentBooksManyToOneAttributeOptional2Entity entity = studentBooksManyToOneAttributeOptional2EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, BookAssociationStudentDto.class);
    }

    public BookAssociationStudentDto insertBookAttributeOptional2ById(BookAssociationStudentDto dto) {
        //新增的时候允许级联字段为null,新增出来的studentDetail记录的studentId为null
        //新增的时候不会检查student.id对应的student是否存在,如果不存在查询的时候会整条数据找不到
        StudentBooksManyToOneAttributeOptional2Entity entity = BeanUtil.copyProperties(dto, StudentBooksManyToOneAttributeOptional2Entity.class);
        entity.setId(null);
        studentBooksManyToOneAttributeOptional2EntityRepository.save(entity);
        return BeanUtil.copyProperties(entity, BookAssociationStudentDto.class);
    }
}
