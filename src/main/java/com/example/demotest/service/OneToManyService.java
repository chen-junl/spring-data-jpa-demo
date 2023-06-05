package com.example.demotest.service;

import cn.hutool.core.bean.BeanUtil;
import com.example.demotest.dto.association.BookAssociationStudentDto;
import com.example.demotest.dto.association.StudentAssociationBooksDto;
import com.example.demotest.entity.one_to_many.attribute.cascade.*;
import com.example.demotest.entity.one_to_many.attribute.fetch.StudentOneToManyAttributeFetch1Entity;
import com.example.demotest.entity.one_to_many.attribute.fetch.StudentOneToManyAttributeFetch2Entity;
import com.example.demotest.entity.one_to_many.type1.StudentBooksOneToManyType1Entity;
import com.example.demotest.entity.one_to_many.type1.StudentOneToManyType1Entity;
import com.example.demotest.entity.one_to_many.type2.StudentBooksOneToManyType2Entity;
import com.example.demotest.entity.one_to_many.type2.StudentOneToManyType2Entity;
import com.example.demotest.entity.one_to_many.type3.StudentBooksOneToManyType3Entity;
import com.example.demotest.entity.one_to_many.type3.StudentOneToManyType3Entity;
import com.example.demotest.repository.one_to_many.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenjunl
 * @description
 * @date 2023/5/31
 */
@Service
public class OneToManyService {

    @Autowired
    private StudentOneToManyType1EntityRepository studentOneToManyType1EntityRepository;
    @Autowired
    private StudentBooksOneToManyType1EntityRepository studentBooksOneToManyType1EntityRepository;
    @Autowired
    private StudentOneToManyType2EntityRepository studentOneToManyType2EntityRepository;
    @Autowired
    private StudentBooksOneToManyType2EntityRepository studentBooksOneToManyType2EntityRepository;
    @Autowired
    private StudentOneToManyType3EntityRepository studentOneToManyType3EntityRepository;
    @Autowired
    private StudentBooksOneToManyType3EntityRepository studentBooksOneToManyType3EntityRepository;

    @Autowired
    private StudentOneToManyAttributeCascade0EntityRepository studentOneToManyAttributeCascade0EntityRepository;
    @Autowired
    private StudentOneToManyAttributeCascade1EntityRepository studentOneToManyAttributeCascade1EntityRepository;
    @Autowired
    private StudentOneToManyAttributeCascade2EntityRepository studentOneToManyAttributeCascade2EntityRepository;
    @Autowired
    private StudentOneToManyAttributeCascade3EntityRepository studentOneToManyAttributeCascade3EntityRepository;
    @Autowired
    private StudentOneToManyAttributeCascade4EntityRepository studentOneToManyAttributeCascade4EntityRepository;
    @Autowired
    private StudentOneToManyAttributeCascade5EntityRepository studentOneToManyAttributeCascade5EntityRepository;
    @Autowired
    private StudentOneToManyAttributeCascade6EntityRepository studentOneToManyAttributeCascade6EntityRepository;
    @Autowired
    private StudentOneToManyAttributeFetch1EntityRepository studentOneToManyAttributeFetch1EntityRepository;
    @Autowired
    private StudentOneToManyAttributeFetch2EntityRepository studentOneToManyAttributeFetch2EntityRepository;
    @Autowired
    private StudentOneToManyAttributeOrphanRemoval1EntityRepository studentOneToManyAttributeOrphanRemoval1EntityRepository;
    @Autowired
    private StudentOneToManyAttributeOrphanRemoval2EntityRepository studentOneToManyAttributeOrphanRemoval2EntityRepository;


    public StudentAssociationBooksDto findStudent1ById(Integer id) {
        StudentOneToManyType1Entity entity = studentOneToManyType1EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, StudentAssociationBooksDto.class);
    }


    public BookAssociationStudentDto findBook1ById(Integer id) {
        StudentBooksOneToManyType1Entity entity = studentBooksOneToManyType1EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, BookAssociationStudentDto.class);
    }


    public StudentAssociationBooksDto findStudent2ById(Integer id) {
        StudentOneToManyType2Entity entity = studentOneToManyType2EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, StudentAssociationBooksDto.class);
    }


    public BookAssociationStudentDto findBook2ById(Integer id) {
        StudentBooksOneToManyType2Entity entity = studentBooksOneToManyType2EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, BookAssociationStudentDto.class);
    }

    public StudentAssociationBooksDto findStudent3ById(Integer id) {
        StudentOneToManyType3Entity entity = studentOneToManyType3EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, StudentAssociationBooksDto.class);
    }


    public BookAssociationStudentDto findBook3ById(Integer id) {
        StudentBooksOneToManyType3Entity entity = studentBooksOneToManyType3EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, BookAssociationStudentDto.class);
    }


    //第0种类型 什么都不指定
    public StudentAssociationBooksDto findStudentAttributeCascade0ById(Integer id) {
        StudentOneToManyAttributeCascade0Entity entity = studentOneToManyAttributeCascade0EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, StudentAssociationBooksDto.class);
    }

    public StudentAssociationBooksDto insertStudentAttributeCascade0ById(StudentAssociationBooksDto dto) {
        //什么都不指定的时候,新增时必须传入books.book.id,新增student表,(并且更新book表的student_id,会校验book表中是否存在id为book.id的数据)
        StudentOneToManyAttributeCascade0Entity entity = BeanUtil.copyProperties(dto, StudentOneToManyAttributeCascade0Entity.class);
        entity.setId(null);
        studentOneToManyAttributeCascade0EntityRepository.save(entity);
        return BeanUtil.copyProperties(entity, StudentAssociationBooksDto.class);
    }

    public StudentAssociationBooksDto updateStudentAttributeCascade0ById(Integer id, StudentAssociationBooksDto dto) {
        //什么都不指定的时候,更新时必须传入student.id,更新student表,(并且更新book表的student_id,会校验book表中是否存在id为book.id的数据,book表如果之前有关联,本次的没有的话,会更新studentId为null,如果指定关联之前studentId不是自己的数据会报错)
        StudentOneToManyAttributeCascade0Entity entity = BeanUtil.copyProperties(dto, StudentOneToManyAttributeCascade0Entity.class);
        entity.setId(id);
        studentOneToManyAttributeCascade0EntityRepository.save(entity);
        return BeanUtil.copyProperties(entity, StudentAssociationBooksDto.class);
    }

    public boolean deleteStudentAttributeCascade0ById(Integer id) {
        //什么都不指定的时候,删除时,删除student表,同时将级联出来的book表的数据studentId设置为null
        studentOneToManyAttributeCascade0EntityRepository.deleteById(id);
        return true;
    }


    //第一种类型 CascadeType.ALL
    public StudentAssociationBooksDto findStudentAttributeCascade1ById(Integer id) {
        StudentOneToManyAttributeCascade1Entity entity = studentOneToManyAttributeCascade1EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, StudentAssociationBooksDto.class);
    }

    public StudentAssociationBooksDto insertStudentAttributeCascade1ById(StudentAssociationBooksDto dto) {
        //使用CascadeType.ALL,新增的时候,同时新增student表和book表,student的id和级联出来的book的id都要设置为null,否则报错
        StudentOneToManyAttributeCascade1Entity entity = BeanUtil.copyProperties(dto, StudentOneToManyAttributeCascade1Entity.class);
        entity.setId(null);
        studentOneToManyAttributeCascade1EntityRepository.save(entity);
        return BeanUtil.copyProperties(entity, StudentAssociationBooksDto.class);
    }

    public StudentAssociationBooksDto updateStudentAttributeCascade1ById(Integer id, StudentAssociationBooksDto dto) {
        //使用CascadeType.ALL,更新的时候,同时更新student表和book表,级联出来的book.id如果为null就新增book,如果不为null就会更新book对象,book表如果之前有关联,本次的没有的话,会更新studentId为null)
        StudentOneToManyAttributeCascade1Entity entity = BeanUtil.copyProperties(dto, StudentOneToManyAttributeCascade1Entity.class);
        entity.setId(id);
        studentOneToManyAttributeCascade1EntityRepository.save(entity);
        return BeanUtil.copyProperties(entity, StudentAssociationBooksDto.class);
    }

    public boolean deleteStudentAttributeCascade1ById(Integer id) {
        //使用CascadeType.ALL 删除时,删除student表,同时将级联出来的book表的数据studentId设置为null
        studentOneToManyAttributeCascade1EntityRepository.deleteById(id);
        return true;
    }


    //第二种类型 CascadeType.PERSIST
    public StudentAssociationBooksDto findStudentAttributeCascade2ById(Integer id) {
        StudentOneToManyAttributeCascade2Entity entity = studentOneToManyAttributeCascade2EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, StudentAssociationBooksDto.class);
    }

    public StudentAssociationBooksDto insertStudentAttributeCascade2ById(StudentAssociationBooksDto dto) {
        //使用CascadeType.PERSIST,新增的时候,同时新增student表和book表,student的id和级联出来的book的id都要设置为null,否则报错
        StudentOneToManyAttributeCascade2Entity entity = BeanUtil.copyProperties(dto, StudentOneToManyAttributeCascade2Entity.class);
        entity.setId(null);
        studentOneToManyAttributeCascade2EntityRepository.save(entity);
        return BeanUtil.copyProperties(entity, StudentAssociationBooksDto.class);
    }

    public StudentAssociationBooksDto updateStudentAttributeCascade2ById(Integer id, StudentAssociationBooksDto dto) {
        //使用CascadeType.PERSIST,更新的时候,只会更新student表,如果book.id如果为null会报错,(并且更新book表的student_id,会校验book表中是否存在id为book.id的数据,book表如果之前有关联,本次的没有的话,会更新studentId为null,如果指定关联之前studentId不是自己的数据会报错)
        StudentOneToManyAttributeCascade2Entity entity = BeanUtil.copyProperties(dto, StudentOneToManyAttributeCascade2Entity.class);
        entity.setId(id);
        studentOneToManyAttributeCascade2EntityRepository.save(entity);
        return BeanUtil.copyProperties(entity, StudentAssociationBooksDto.class);
    }

    public boolean deleteStudentAttributeCascade2ById(Integer id) {
        //使用CascadeType.PERSIST,删除时,删除student表,同时将级联出来的book表的数据studentId设置为null
        studentOneToManyAttributeCascade2EntityRepository.deleteById(id);
        return true;
    }


    //第三种类型 CascadeType.MERGE
    public StudentAssociationBooksDto findStudentAttributeCascade3ById(Integer id) {
        StudentOneToManyAttributeCascade3Entity entity = studentOneToManyAttributeCascade3EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, StudentAssociationBooksDto.class);
    }

    public StudentAssociationBooksDto insertStudentAttributeCascade3ById(StudentAssociationBooksDto dto) {
        //使用CascadeType.MERGE新增时必须传入books.book.id,新增student表,(并且更新book表的student_id,会校验book表中是否存在id为book.id的数据)
        StudentOneToManyAttributeCascade3Entity entity = BeanUtil.copyProperties(dto, StudentOneToManyAttributeCascade3Entity.class);
        entity.setId(null);
        studentOneToManyAttributeCascade3EntityRepository.save(entity);
        return BeanUtil.copyProperties(entity, StudentAssociationBooksDto.class);
    }

    public StudentAssociationBooksDto updateStudentAttributeCascade3ById(Integer id, StudentAssociationBooksDto dto) {
        //使用CascadeType.MERGE 更新的时候,同时student表和book表,级联出来的book.id如果为null就新增book,如果不为null就会更新book对象,book表如果之前有关联,本次的没有的话,会更新studentId为null)
        StudentOneToManyAttributeCascade3Entity entity = BeanUtil.copyProperties(dto, StudentOneToManyAttributeCascade3Entity.class);
        entity.setId(id);
        studentOneToManyAttributeCascade3EntityRepository.save(entity);
        return BeanUtil.copyProperties(entity, StudentAssociationBooksDto.class);
    }

    public boolean deleteStudentAttributeCascade3ById(Integer id) {
        //使用CascadeType.MERGE,删除时,删除student表,同时将级联出来的book表的数据studentId设置为null
        studentOneToManyAttributeCascade3EntityRepository.deleteById(id);
        return true;
    }


    //第四种类型 CascadeType.REMOVE
    public StudentAssociationBooksDto findStudentAttributeCascade4ById(Integer id) {
        StudentOneToManyAttributeCascade4Entity entity = studentOneToManyAttributeCascade4EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, StudentAssociationBooksDto.class);
    }

    public StudentAssociationBooksDto insertStudentAttributeCascade4ById(StudentAssociationBooksDto dto) {
        //使用CascadeType.REMOVE 新增时必须传入books.book.id,新增student表,(并且更新book表的student_id,会校验book表中是否存在id为book.id的数据)
        StudentOneToManyAttributeCascade4Entity entity = BeanUtil.copyProperties(dto, StudentOneToManyAttributeCascade4Entity.class);
        entity.setId(null);
        studentOneToManyAttributeCascade4EntityRepository.save(entity);
        return BeanUtil.copyProperties(entity, StudentAssociationBooksDto.class);
    }

    public StudentAssociationBooksDto updateStudentAttributeCascade4ById(Integer id, StudentAssociationBooksDto dto) {
        //使用CascadeType.REMOVE,更新时必须传入student.id,更新student表,(并且更新book表的student_id,会校验book表中是否存在id为book.id的数据,book表如果之前有关联,本次的没有的话,会更新studentId为null,如果指定关联之前studentId不是自己的数据会报错)
        StudentOneToManyAttributeCascade4Entity entity = BeanUtil.copyProperties(dto, StudentOneToManyAttributeCascade4Entity.class);
        entity.setId(id);
        studentOneToManyAttributeCascade4EntityRepository.save(entity);
        return BeanUtil.copyProperties(entity, StudentAssociationBooksDto.class);
    }

    public boolean deleteStudentAttributeCascade4ById(Integer id) {
        //使用CascadeType.REMOVE 删除时,删除student表,同时将级联出来的book表的数据studentId设置为null
        studentOneToManyAttributeCascade4EntityRepository.deleteById(id);
        return true;
    }


    //第五种类型 CascadeType.REFRESH
    public StudentAssociationBooksDto findStudentAttributeCascade5ById(Integer id) {
        StudentOneToManyAttributeCascade5Entity entity = studentOneToManyAttributeCascade5EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, StudentAssociationBooksDto.class);
    }

    public StudentAssociationBooksDto insertStudentAttributeCascade5ById(StudentAssociationBooksDto dto) {
        //使用CascadeType.REFRESH 新增时必须传入books.book.id,新增student表,(并且更新book表的student_id,会校验book表中是否存在id为book.id的数据)
        StudentOneToManyAttributeCascade5Entity entity = BeanUtil.copyProperties(dto, StudentOneToManyAttributeCascade5Entity.class);
        entity.setId(null);
        studentOneToManyAttributeCascade5EntityRepository.save(entity);
        return BeanUtil.copyProperties(entity, StudentAssociationBooksDto.class);
    }

    public StudentAssociationBooksDto updateStudentAttributeCascade5ById(Integer id, StudentAssociationBooksDto dto) {
        ///使用CascadeType.REFRESH,更新时必须传入student.id,更新student表,(并且更新book表的student_id,会校验book表中是否存在id为book.id的数据,book表如果之前有关联,本次的没有的话,会更新studentId为null,如果指定关联之前studentId不是自己的数据会报错)
        StudentOneToManyAttributeCascade5Entity entity = BeanUtil.copyProperties(dto, StudentOneToManyAttributeCascade5Entity.class);
        entity.setId(id);
        studentOneToManyAttributeCascade5EntityRepository.save(entity);
        return BeanUtil.copyProperties(entity, StudentAssociationBooksDto.class);
    }

    public boolean deleteStudentAttributeCascade5ById(Integer id) {
        //使用CascadeType.REFRESH,删除时,删除student表,同时将级联出来的book表的数据studentId设置为null
        studentOneToManyAttributeCascade5EntityRepository.deleteById(id);
        return true;
    }


    //第六种类型 CascadeType.DETACH
    public StudentAssociationBooksDto findStudentAttributeCascade6ById(Integer id) {
        StudentOneToManyAttributeCascade6Entity entity = studentOneToManyAttributeCascade6EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, StudentAssociationBooksDto.class);
    }

    public StudentAssociationBooksDto insertStudentAttributeCascade6ById(StudentAssociationBooksDto dto) {
        //使用CascadeType.DETACH 新增时必须传入books.book.id,新增student表,(并且更新book表的student_id,会校验book表中是否存在id为book.id的数据)
        StudentOneToManyAttributeCascade6Entity entity = BeanUtil.copyProperties(dto, StudentOneToManyAttributeCascade6Entity.class);
        entity.setId(null);
        studentOneToManyAttributeCascade6EntityRepository.save(entity);
        return BeanUtil.copyProperties(entity, StudentAssociationBooksDto.class);
    }

    public StudentAssociationBooksDto updateStudentAttributeCascade6ById(Integer id, StudentAssociationBooksDto dto) {
        ///使用CascadeType.DETACH,更新时必须传入student.id,更新student表,(并且更新book表的student_id,会校验book表中是否存在id为book.id的数据,book表如果之前有关联,本次的没有的话,会更新studentId为null,如果指定关联之前studentId不是自己的数据会报错)
        StudentOneToManyAttributeCascade6Entity entity = BeanUtil.copyProperties(dto, StudentOneToManyAttributeCascade6Entity.class);
        entity.setId(id);
        studentOneToManyAttributeCascade6EntityRepository.save(entity);
        return BeanUtil.copyProperties(entity, StudentAssociationBooksDto.class);
    }

    public boolean deleteStudentAttributeCascade6ById(Integer id) {
        //使用CascadeType.DETACH,删除时,删除student表,同时将级联出来的book表的数据studentId设置为null
        studentOneToManyAttributeCascade6EntityRepository.deleteById(id);
        return true;
    }

    //fetch第一种类型 Fetch.EAGER
    public StudentAssociationBooksDto findStudentAttributeFetch1ById(Integer id) {
        //生成查询SQL 一条语句两张表并起来,返回所有字段
        //select studentone0_.id as id1_0_0_, studentone0_.creator as creator2_0_0_, studentone0_.gmt_create as gmt_crea3_0_0_, studentone0_.gmt_modified as gmt_modi4_0_0_, studentone0_.is_delete as is_delet5_0_0_, studentone0_.modifier as modifier6_0_0_, studentone0_.sort_index as sort_ind7_0_0_, studentone0_.title as title8_0_0_, books1_.student_id as student_8_1_1_, books1_.id as id1_1_1_, books1_.id as id1_1_2_, books1_.creator as creator2_1_2_, books1_.gmt_create as gmt_crea3_1_2_, books1_.gmt_modified as gmt_modi4_1_2_, books1_.is_delete as is_delet5_1_2_, books1_.modifier as modifier6_1_2_, books1_.price as price10_1_2_, books1_.sort_index as sort_ind7_1_2_, books1_.title as title9_1_2_ from student studentone0_ left outer join student_book books1_ on studentone0_.id=books1_.student_id and ( books1_.is_delete=0)  where studentone0_.id=? and ( studentone0_.is_delete=0)
        StudentOneToManyAttributeFetch1Entity entity = studentOneToManyAttributeFetch1EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, StudentAssociationBooksDto.class);
    }

    public List<StudentAssociationBooksDto> findStudentAttributeFetch1() {
        //一条查询student全部记录的语句+n条查询book的语句
        List<StudentOneToManyAttributeFetch1Entity> entityList = studentOneToManyAttributeFetch1EntityRepository.findAll();
        return BeanUtil.copyToList(entityList, StudentAssociationBooksDto.class);
    }

    //fetch第二种类型 Fetch.LAZY
    public StudentAssociationBooksDto findStudentAttributeFetch2ById(Integer id) {
        //生成查询SQL 两条语句,两张表分别查询各自字段
        //Hibernate: select studentone0_.id as id1_0_0_, studentone0_.creator as creator2_0_0_, studentone0_.gmt_create as gmt_crea3_0_0_, studentone0_.gmt_modified as gmt_modi4_0_0_, studentone0_.is_delete as is_delet5_0_0_, studentone0_.modifier as modifier6_0_0_, studentone0_.sort_index as sort_ind7_0_0_, studentone0_.title as title8_0_0_ from student studentone0_ where studentone0_.id=? and ( studentone0_.is_delete=0)
        //Hibernate: select books0_.student_id as student_8_1_0_, books0_.id as id1_1_0_, books0_.id as id1_1_1_, books0_.creator as creator2_1_1_, books0_.gmt_create as gmt_crea3_1_1_, books0_.gmt_modified as gmt_modi4_1_1_, books0_.is_delete as is_delet5_1_1_, books0_.modifier as modifier6_1_1_, books0_.price as price10_1_1_, books0_.sort_index as sort_ind7_1_1_, books0_.title as title9_1_1_ from student_book books0_ where ( books0_.is_delete=0) and books0_.student_id=?
        StudentOneToManyAttributeFetch2Entity entity = studentOneToManyAttributeFetch2EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, StudentAssociationBooksDto.class);
    }

    public List<StudentAssociationBooksDto> findStudentAttributeFetch2() {
        //一条查询student全部记录的语句+n条查询book的语句
        List<StudentOneToManyAttributeFetch2Entity> entityList = studentOneToManyAttributeFetch2EntityRepository.findAll();
        return BeanUtil.copyToList(entityList, StudentAssociationBooksDto.class);
    }

    //orphanRemoval第一种类型 orphanRemoval=false
    public boolean deleteStudentAttributeOrphanRemoval1ById(Integer id) {
        //orphanRemoval=false时 删除双向引用中的被动一方 只是删除了student表数据,没有删除book表数据
        studentOneToManyAttributeOrphanRemoval1EntityRepository.deleteById(id);
        return true;
    }

    //orphanRemoval第二种类型 orphanRemoval=true
    public boolean deleteStudentAttributeOrphanRemoval2ById(Integer id) {
        //orphanRemoval=true 删除双向引用中的被动一方 删除了student表数据,同时删除了book表数据
        studentOneToManyAttributeOrphanRemoval2EntityRepository.deleteById(id);
        return true;
    }


}
