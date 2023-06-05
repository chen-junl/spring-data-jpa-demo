package com.example.demotest.service;

import cn.hutool.core.bean.BeanUtil;
import com.example.demotest.dto.association.DetailAssociationStudentDto;
import com.example.demotest.dto.association.StudentAssociationDetailDto;
import com.example.demotest.entity.one_to_one.attribute.cascade.*;
import com.example.demotest.entity.one_to_one.attribute.fetch.StudentDetailOneToOneAttributeFetch1Entity;
import com.example.demotest.entity.one_to_one.attribute.fetch.StudentDetailOneToOneAttributeFetch2Entity;
import com.example.demotest.entity.one_to_one.attribute.optional.StudentDetailOneToOneAttributeOptional1Entity;
import com.example.demotest.entity.one_to_one.attribute.optional.StudentDetailOneToOneAttributeOptional2Entity;
import com.example.demotest.entity.one_to_one.type1.StudentDetailOneToOneType1Entity;
import com.example.demotest.entity.one_to_one.type1.StudentOneToOneType1Entity;
import com.example.demotest.entity.one_to_one.type2.StudentDetailOneToOneType2Entity;
import com.example.demotest.entity.one_to_one.type2.StudentOneToOneType2Entity;
import com.example.demotest.repository.one_to_one.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenjunl
 * @description
 * @date 2023/5/30
 */
@Service
public class OneToOneService {

    @Autowired
    private StudentOneToOneType1EntityRepository studentOneToOneType1EntityRepository;
    @Autowired
    private StudentOneToOneType2EntityRepository studentOneToOneType2EntityRepository;
    @Autowired
    private StudentDetailOneToOneType1EntityRepository studentDetailOneToOneType1EntityRepository;
    @Autowired
    private StudentDetailOneToOneType2EntityRepository studentDetailOneToOneType2EntityRepository;
    @Autowired
    private StudentDetailOneToOneAttributeCascade0EntityRepository studentDetailOneToOneAttributeCascade0EntityRepository;
    @Autowired
    private StudentDetailOneToOneAttributeCascade1EntityRepository studentDetailOneToOneAttributeCascade1EntityRepository;
    @Autowired
    private StudentDetailOneToOneAttributeCascade2EntityRepository studentDetailOneToOneAttributeCascade2EntityRepository;
    @Autowired
    private StudentDetailOneToOneAttributeCascade3EntityRepository studentDetailOneToOneAttributeCascade3EntityRepository;
    @Autowired
    private StudentDetailOneToOneAttributeCascade4EntityRepository studentDetailOneToOneAttributeCascade4EntityRepository;
    @Autowired
    private StudentDetailOneToOneAttributeCascade5EntityRepository studentDetailOneToOneAttributeCascade5EntityRepository;
    @Autowired
    private StudentDetailOneToOneAttributeCascade6EntityRepository studentDetailOneToOneAttributeCascade6EntityRepository;

    @Autowired
    private StudentDetailOneToOneAttributeFetch1EntityRepository studentDetailOneToOneAttributeFetch1EntityRepository;
    @Autowired
    private StudentDetailOneToOneAttributeFetch2EntityRepository studentDetailOneToOneAttributeFetch2EntityRepository;

    @Autowired
    private StudentDetailOneToOneAttributeOptional1EntityRepository studentDetailOneToOneAttributeOptional1EntityRepository;
    @Autowired
    private StudentDetailOneToOneAttributeOptional2EntityRepository studentDetailOneToOneAttributeOptional2EntityRepository;


    @Autowired
    private StudentOneToOneAttributeOrphanRemoval1EntityRepository studentOneToOneAttributeOrphanRemoval1EntityRepository;
    @Autowired
    private StudentOneToOneAttributeOrphanRemoval2EntityRepository studentOneToOneAttributeOrphanRemoval2EntityRepository;


    public StudentAssociationDetailDto findStudent1ById(Integer id) {
        StudentOneToOneType1Entity entity = studentOneToOneType1EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, StudentAssociationDetailDto.class);
    }

    public StudentAssociationDetailDto findStudent2ById(Integer id) {
        StudentOneToOneType2Entity entity = studentOneToOneType2EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, StudentAssociationDetailDto.class);
    }

    public DetailAssociationStudentDto findStudentDetail1ById(Integer id) {
        StudentDetailOneToOneType1Entity entity = studentDetailOneToOneType1EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, DetailAssociationStudentDto.class);
    }

    public DetailAssociationStudentDto findStudentDetail2ById(Integer id) {
        StudentDetailOneToOneType2Entity entity = studentDetailOneToOneType2EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, DetailAssociationStudentDto.class);
    }

    //第0种类型 什么都不指定
    public DetailAssociationStudentDto findStudentDetailAttributeCascade0ById(Integer id) {
        StudentDetailOneToOneAttributeCascade0Entity entity = studentDetailOneToOneAttributeCascade0EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, DetailAssociationStudentDto.class);
    }

    public DetailAssociationStudentDto insertStudentDetailAttributeCascade0ById(DetailAssociationStudentDto dto) {
        //什么都不指定的时候,新增时必须传入student.id,只保存studentDetail单表,没有任何级联student表操作,并且不会校验student表中是否存在id为student.id的数据
        StudentDetailOneToOneAttributeCascade0Entity entity = BeanUtil.copyProperties(dto, StudentDetailOneToOneAttributeCascade0Entity.class);
        entity.setId(null);
        studentDetailOneToOneAttributeCascade0EntityRepository.save(entity);
        return BeanUtil.copyProperties(entity, DetailAssociationStudentDto.class);
    }

    public DetailAssociationStudentDto updateStudentDetailAttributeCascade0ById(Integer id, DetailAssociationStudentDto dto) {
        //什么都不指定的时候,更新时必须传入student.id,只保存studentDetail单表,没有任何级联student表操作,但是会校验student表中是否存在id为oldStudentId和student.id的数据
        StudentDetailOneToOneAttributeCascade0Entity entity = BeanUtil.copyProperties(dto, StudentDetailOneToOneAttributeCascade0Entity.class);
        entity.setId(id);
        studentDetailOneToOneAttributeCascade0EntityRepository.save(entity);
        return BeanUtil.copyProperties(entity, DetailAssociationStudentDto.class);
    }

    public boolean deleteStudentDetailAttributeCascade0ById(Integer id) {
        //什么都不指定的时候,删除时,只删除studentDetail单表,没有任何级联student表操作,但是会校验student表中是否存在id为oldStudentId的数据
        studentDetailOneToOneAttributeCascade0EntityRepository.deleteById(id);
        return true;
    }


    //第一种类型 CascadeType.ALL
    public DetailAssociationStudentDto findStudentDetailAttributeCascade1ById(Integer id) {
        StudentDetailOneToOneAttributeCascade1Entity entity = studentDetailOneToOneAttributeCascade1EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, DetailAssociationStudentDto.class);
    }

    public DetailAssociationStudentDto insertStudentDetailAttributeCascade1ById(DetailAssociationStudentDto dto) {
        //使用CascadeType.ALL,新增的时候,同时新增studentDetail和student表,studentDetail的id和级联出来的student的id都要设置为null,否则报错
        StudentDetailOneToOneAttributeCascade1Entity entity = BeanUtil.copyProperties(dto, StudentDetailOneToOneAttributeCascade1Entity.class);
        entity.setId(null);
        studentDetailOneToOneAttributeCascade1EntityRepository.save(entity);
        return BeanUtil.copyProperties(entity, DetailAssociationStudentDto.class);
    }

    public DetailAssociationStudentDto updateStudentDetailAttributeCascade1ById(Integer id, DetailAssociationStudentDto dto) {
        //使用CascadeType.ALL,更新的时候,同时更新studentDetail和student表,级联出来的student.id如果为null就新增student,如果不为null就会更新student对象
        StudentDetailOneToOneAttributeCascade1Entity entity = BeanUtil.copyProperties(dto, StudentDetailOneToOneAttributeCascade1Entity.class);
        entity.setId(id);
        studentDetailOneToOneAttributeCascade1EntityRepository.save(entity);
        return BeanUtil.copyProperties(entity, DetailAssociationStudentDto.class);
    }

    public boolean deleteStudentDetailAttributeCascade1ById(Integer id) {
        //使用CascadeType.ALL 删除的时候,同时新增student和studentDetail表
        studentDetailOneToOneAttributeCascade1EntityRepository.deleteById(id);
        return true;
    }

    //第二种类型 CascadeType.PERSIST
    public DetailAssociationStudentDto findStudentDetailAttributeCascade2ById(Integer id) {
        StudentDetailOneToOneAttributeCascade2Entity entity = studentDetailOneToOneAttributeCascade2EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, DetailAssociationStudentDto.class);
    }

    public DetailAssociationStudentDto insertStudentDetailAttributeCascade2ById(DetailAssociationStudentDto dto) {
        //使用CascadeType.PERSIST,新增的时候,同时新增studentDetail和student表,studentDetail的id和级联出来的student的id都要设置为null
        StudentDetailOneToOneAttributeCascade2Entity entity = BeanUtil.copyProperties(dto, StudentDetailOneToOneAttributeCascade2Entity.class);
        entity.setId(null);
        studentDetailOneToOneAttributeCascade2EntityRepository.save(entity);
        return BeanUtil.copyProperties(entity, DetailAssociationStudentDto.class);
    }

    public DetailAssociationStudentDto updateStudentDetailAttributeCascade2ById(Integer id, DetailAssociationStudentDto dto) {
        //使用CascadeType.PERSIST,更新的时候,只会更新studentDetail表,如果student.id如果为null会报错
        StudentDetailOneToOneAttributeCascade2Entity entity = BeanUtil.copyProperties(dto, StudentDetailOneToOneAttributeCascade2Entity.class);
        entity.setId(id);
        studentDetailOneToOneAttributeCascade2EntityRepository.save(entity);
        return BeanUtil.copyProperties(entity, DetailAssociationStudentDto.class);
    }

    public boolean deleteStudentDetailAttributeCascade2ById(Integer id) {
        //使用CascadeType.PERSIST,删除的时候,只会删除studentDetail表
        studentDetailOneToOneAttributeCascade2EntityRepository.deleteById(id);
        return true;
    }


    //第三种类型 CascadeType.MERGE
    public DetailAssociationStudentDto findStudentDetailAttributeCascade3ById(Integer id) {
        StudentDetailOneToOneAttributeCascade3Entity entity = studentDetailOneToOneAttributeCascade3EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, DetailAssociationStudentDto.class);
    }

    public DetailAssociationStudentDto insertStudentDetailAttributeCascade3ById(DetailAssociationStudentDto dto) {
        //使用CascadeType.MERGE 新增的时候,只会更新studentDetail表,如果student.id如果为null会报错
        StudentDetailOneToOneAttributeCascade3Entity entity = BeanUtil.copyProperties(dto, StudentDetailOneToOneAttributeCascade3Entity.class);
        entity.setId(null);
        studentDetailOneToOneAttributeCascade3EntityRepository.save(entity);
        return BeanUtil.copyProperties(entity, DetailAssociationStudentDto.class);
    }

    public DetailAssociationStudentDto updateStudentDetailAttributeCascade3ById(Integer id, DetailAssociationStudentDto dto) {
        //使用CascadeType.MERGE 更新的时候 级联出来的student的id如果为null就新增student,如果不为null就会更新student对象
        StudentDetailOneToOneAttributeCascade3Entity entity = BeanUtil.copyProperties(dto, StudentDetailOneToOneAttributeCascade3Entity.class);
        entity.setId(id);
        studentDetailOneToOneAttributeCascade3EntityRepository.save(entity);
        return BeanUtil.copyProperties(entity, DetailAssociationStudentDto.class);
    }

    public boolean deleteStudentDetailAttributeCascade3ById(Integer id) {
        //使用CascadeType.MERGE,删除的时候,只会删除studentDetail表
        studentDetailOneToOneAttributeCascade3EntityRepository.deleteById(id);
        return true;
    }


    //第四种类型 CascadeType.REMOVE
    public DetailAssociationStudentDto findStudentDetailAttributeCascade4ById(Integer id) {
        StudentDetailOneToOneAttributeCascade4Entity entity = studentDetailOneToOneAttributeCascade4EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, DetailAssociationStudentDto.class);
    }

    public DetailAssociationStudentDto insertStudentDetailAttributeCascade4ById(DetailAssociationStudentDto dto) {
        //使用CascadeType.REMOVE 新增的时候,只会更新studentDetail表,如果student.id如果为null会报错
        StudentDetailOneToOneAttributeCascade4Entity entity = BeanUtil.copyProperties(dto, StudentDetailOneToOneAttributeCascade4Entity.class);
        entity.setId(null);
        studentDetailOneToOneAttributeCascade4EntityRepository.save(entity);
        return BeanUtil.copyProperties(entity, DetailAssociationStudentDto.class);
    }

    public DetailAssociationStudentDto updateStudentDetailAttributeCascade4ById(Integer id, DetailAssociationStudentDto dto) {
        //使用CascadeType.REMOVE,更新的时候,只会更新studentDetail表,如果student.id如果为null会报错
        StudentDetailOneToOneAttributeCascade4Entity entity = BeanUtil.copyProperties(dto, StudentDetailOneToOneAttributeCascade4Entity.class);
        entity.setId(id);
        studentDetailOneToOneAttributeCascade4EntityRepository.save(entity);
        return BeanUtil.copyProperties(entity, DetailAssociationStudentDto.class);
    }

    public boolean deleteStudentDetailAttributeCascade4ById(Integer id) {
        //使用CascadeType.REMOVE 删除的时候 studentDetail和student都会被删除
        studentDetailOneToOneAttributeCascade4EntityRepository.deleteById(id);
        return true;
    }


    //第五种类型 CascadeType.REFRESH
    public DetailAssociationStudentDto findStudentDetailAttributeCascade5ById(Integer id) {
        StudentDetailOneToOneAttributeCascade5Entity entity = studentDetailOneToOneAttributeCascade5EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, DetailAssociationStudentDto.class);
    }

    public DetailAssociationStudentDto insertStudentDetailAttributeCascade5ById(DetailAssociationStudentDto dto) {
        //使用CascadeType.REFRESH 新增的时候,只会更新studentDetail表,如果student.id如果为null会报错
        StudentDetailOneToOneAttributeCascade5Entity entity = BeanUtil.copyProperties(dto, StudentDetailOneToOneAttributeCascade5Entity.class);
        entity.setId(null);
        studentDetailOneToOneAttributeCascade5EntityRepository.save(entity);
        return BeanUtil.copyProperties(entity, DetailAssociationStudentDto.class);
    }

    public DetailAssociationStudentDto updateStudentDetailAttributeCascade5ById(Integer id, DetailAssociationStudentDto dto) {
        ///使用CascadeType.REFRESH,更新的时候,只会更新studentDetail表,如果student.id如果为null会报错
        StudentDetailOneToOneAttributeCascade5Entity entity = BeanUtil.copyProperties(dto, StudentDetailOneToOneAttributeCascade5Entity.class);
        entity.setId(id);
        studentDetailOneToOneAttributeCascade5EntityRepository.save(entity);
        return BeanUtil.copyProperties(entity, DetailAssociationStudentDto.class);
    }

    public boolean deleteStudentDetailAttributeCascade5ById(Integer id) {
        //使用CascadeType.REFRESH,删除的时候,只会删除studentDetail表
        studentDetailOneToOneAttributeCascade5EntityRepository.deleteById(id);
        return true;
    }


    //第六种类型 CascadeType.DETACH
    public DetailAssociationStudentDto findStudentDetailAttributeCascade6ById(Integer id) {
        StudentDetailOneToOneAttributeCascade6Entity entity = studentDetailOneToOneAttributeCascade6EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, DetailAssociationStudentDto.class);
    }

    public DetailAssociationStudentDto insertStudentDetailAttributeCascade6ById(DetailAssociationStudentDto dto) {
        //使用CascadeType.DETACH 新增的时候,只会更新studentDetail表,如果student.id如果为null会报错
        StudentDetailOneToOneAttributeCascade6Entity entity = BeanUtil.copyProperties(dto, StudentDetailOneToOneAttributeCascade6Entity.class);
        entity.setId(null);
        studentDetailOneToOneAttributeCascade6EntityRepository.save(entity);
        return BeanUtil.copyProperties(entity, DetailAssociationStudentDto.class);
    }

    public DetailAssociationStudentDto updateStudentDetailAttributeCascade6ById(Integer id, DetailAssociationStudentDto dto) {
        ///使用CascadeType.DETACH,更新的时候,只会更新studentDetail表,如果student.id如果为null会报错
        StudentDetailOneToOneAttributeCascade6Entity entity = BeanUtil.copyProperties(dto, StudentDetailOneToOneAttributeCascade6Entity.class);
        entity.setId(id);
        studentDetailOneToOneAttributeCascade6EntityRepository.save(entity);
        return BeanUtil.copyProperties(entity, DetailAssociationStudentDto.class);
    }

    public boolean deleteStudentDetailAttributeCascade6ById(Integer id) {
        //使用CascadeType.DETACH,删除的时候,只会删除studentDetail表
        studentDetailOneToOneAttributeCascade6EntityRepository.deleteById(id);
        return true;
    }

    //fetch第一种类型 Fetch.EAGER
    public DetailAssociationStudentDto findStudentDetailAttributeFetch1ById(Integer id) {
        //生成查询SQL 一条语句两张表并起来,返回所有字段
        //select studentone0_.id as id1_0_0_, studentone0_.creator as creator2_0_0_, studentone0_.gmt_create as gmt_crea3_0_0_, studentone0_.gmt_modified as gmt_modi4_0_0_, studentone0_.is_delete as is_delet5_0_0_, studentone0_.modifier as modifier6_0_0_, studentone0_.sort_index as sort_ind7_0_0_, studentone0_.title as title8_0_0_ from student studentone0_ where studentone0_.id=? and ( studentone0_.is_delete=0)
        StudentDetailOneToOneAttributeFetch1Entity entity = studentDetailOneToOneAttributeFetch1EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, DetailAssociationStudentDto.class);
    }

    public List<DetailAssociationStudentDto> findStudentDetailAttributeFetch1() {
        //一条查询student_detail全部记录的语句+n条查询student的语句
        List<StudentDetailOneToOneAttributeFetch1Entity> entityList = studentDetailOneToOneAttributeFetch1EntityRepository.findAll();
        return BeanUtil.copyToList(entityList, DetailAssociationStudentDto.class);
    }

    //fetch第二种类型 Fetch.LAZY
    public DetailAssociationStudentDto findStudentDetailAttributeFetch2ById(Integer id) {
        //生成查询SQL 两条语句,两张表分别查询各自字段
        //select studentdet0_.id as id1_2_0_, studentdet0_.address as address2_2_0_, studentdet0_.age as age3_2_0_, studentdet0_.creator as creator4_2_0_, studentdet0_.email as email5_2_0_, studentdet0_.gmt_create as gmt_crea6_2_0_, studentdet0_.gmt_modified as gmt_modi7_2_0_, studentdet0_.is_delete as is_delet8_2_0_, studentdet0_.modifier as modifier9_2_0_, studentdet0_.sort_index as sort_in10_2_0_, studentdet0_.student_id as student11_2_0_ from student_detail studentdet0_ where studentdet0_.id=? and ( studentdet0_.is_delete=0)
        //select studentone0_.id as id1_0_0_, studentone0_.creator as creator2_0_0_, studentone0_.gmt_create as gmt_crea3_0_0_, studentone0_.gmt_modified as gmt_modi4_0_0_, studentone0_.is_delete as is_delet5_0_0_, studentone0_.modifier as modifier6_0_0_, studentone0_.sort_index as sort_ind7_0_0_, studentone0_.title as title8_0_0_ from student studentone0_ where studentone0_.id=? and ( studentone0_.is_delete=0)
        StudentDetailOneToOneAttributeFetch2Entity entity = studentDetailOneToOneAttributeFetch2EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, DetailAssociationStudentDto.class);
    }


    public List<DetailAssociationStudentDto> findStudentDetailAttributeFetch2() {
        //一条查询student_detail全部记录的语句+n条查询student的语句
        List<StudentDetailOneToOneAttributeFetch2Entity> entityList = studentDetailOneToOneAttributeFetch2EntityRepository.findAll();
        return BeanUtil.copyToList(entityList, DetailAssociationStudentDto.class);
    }


    //optional第一种类型 optional=true
    public DetailAssociationStudentDto findStudentDetailAttributeOptional1ById(Integer id) {
        //如果数据库中studentDetail表的student_id为null 数据可以查询出来,只是级联出来的student对象为null
        //如果数据库中studentDetail表的student_id为一条不存在的student数据 整个entity对象都查询不出来
        StudentDetailOneToOneAttributeOptional1Entity entity = studentDetailOneToOneAttributeOptional1EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, DetailAssociationStudentDto.class);
    }

    public DetailAssociationStudentDto insertStudentDetailAttributeOptional1ById(DetailAssociationStudentDto dto) {
        //新增的时候允许级联字段为null,新增出来的studentDetail记录的studentId为null
        //新增的时候不会检查student.id对应的student是否存在,如果不存在查询的时候会整条数据找不到
        StudentDetailOneToOneAttributeOptional1Entity entity = BeanUtil.copyProperties(dto, StudentDetailOneToOneAttributeOptional1Entity.class);
        entity.setId(null);
        studentDetailOneToOneAttributeOptional1EntityRepository.save(entity);
        return BeanUtil.copyProperties(entity, DetailAssociationStudentDto.class);
    }


    //optional第二种类型 optional=false
    public DetailAssociationStudentDto findStudentDetailAttributeOptional2ById(Integer id) {
        //如果数据库中studentDetail表的student_id为null 整个entity对象都查询不出来
        //如果数据库中studentDetail表的student_id为一条不存在的student数据 整个entity对象都查询不出来
        StudentDetailOneToOneAttributeOptional2Entity entity = studentDetailOneToOneAttributeOptional2EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, DetailAssociationStudentDto.class);
    }

    public DetailAssociationStudentDto insertStudentDetailAttributeOptional2ById(DetailAssociationStudentDto dto) {
        //新增的时候允许级联字段为null,新增出来的studentDetail记录的studentId为null
        //新增的时候不会检查student.id对应的student是否存在,如果不存在查询的时候会整条数据找不到
        StudentDetailOneToOneAttributeOptional2Entity entity = BeanUtil.copyProperties(dto, StudentDetailOneToOneAttributeOptional2Entity.class);
        entity.setId(null);
        studentDetailOneToOneAttributeOptional2EntityRepository.save(entity);
        return BeanUtil.copyProperties(entity, DetailAssociationStudentDto.class);
    }


    //orphanRemoval第一种类型 orphanRemoval=false
    public boolean deleteStudentDetailAttributeOrphanRemoval1ById(Integer id) {
        //orphanRemoval=false时 删除双向引用中的被动一方 只是删除了student表数据,没有删除studentDetail表数据
        studentOneToOneAttributeOrphanRemoval1EntityRepository.deleteById(id);
        return true;
    }

    //orphanRemoval第二种类型 orphanRemoval=true
    public boolean deleteStudentDetailAttributeOrphanRemoval2ById(Integer id) {
        //orphanRemoval=true 删除双向引用中的被动一方 删除了student表数据,同时删除了studentDetail表数据
        studentOneToOneAttributeOrphanRemoval2EntityRepository.deleteById(id);
        return true;
    }

}
