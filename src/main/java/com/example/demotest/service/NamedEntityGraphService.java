package com.example.demotest.service;

import cn.hutool.core.bean.BeanUtil;
import com.example.demotest.dto.association.StudentAssociationBooksDto;
import com.example.demotest.entity.named_entity_graph.*;
import com.example.demotest.repository.named_entity_graph.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author chenjunl
 * @description
 * @date 2023/6/15
 */
@Service
public class NamedEntityGraphService {

    @Autowired
    private StudentNamedEntityGraphLazyEntityRepository studentNamedEntityGraphLazyEntityRepository;
    @Autowired
    private StudentNamedEntityGraphEagerEntityRepository studentNamedEntityGraphEagerEntityRepository;
    @Autowired
    private StudentNamedEntityGraphType1EntityRepository studentNamedEntityGraphType1EntityRepository;
    @Autowired
    private StudentNamedEntityGraphType2EntityRepository studentNamedEntityGraphType2EntityRepository;
    @Autowired
    private StudentNamedEntityGraphType3EntityRepository studentNamedEntityGraphType3EntityRepository;

    //FetchType.LAZY
    public StudentAssociationBooksDto findLazyById(Integer id) {
        //LAZY策略生效,使用 findById() 两条语句
        //select studentnam0_.id as id1_2_0_, studentnam0_.creator as creator2_2_0_, studentnam0_.gmt_create as gmt_crea3_2_0_, studentnam0_.gmt_modified as gmt_modi4_2_0_, studentnam0_.is_delete as is_delet5_2_0_, studentnam0_.modifier as modifier6_2_0_, studentnam0_.sort_index as sort_ind7_2_0_, studentnam0_.title as title8_2_0_ from student studentnam0_ where studentnam0_.id=? and ( studentnam0_.is_delete=0)
        //select books0_.student_id as student_8_3_0_, books0_.id as id1_3_0_, books0_.id as id1_3_1_, books0_.creator as creator2_3_1_, books0_.gmt_create as gmt_crea3_3_1_, books0_.gmt_modified as gmt_modi4_3_1_, books0_.is_delete as is_delet5_3_1_, books0_.modifier as modifier6_3_1_, books0_.price as price10_3_1_, books0_.sort_index as sort_ind7_3_1_, books0_.title as title9_3_1_ from student_book books0_ where ( books0_.is_delete=0) and books0_.student_id=?
        StudentNamedEntityGraphLazyEntity entity = studentNamedEntityGraphLazyEntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, StudentAssociationBooksDto.class);
    }

    //FetchType.LAZY
    public List<StudentAssociationBooksDto> findLazy() {
        //就算指定加载策略是LAZY,使用 findAll() 会有n+1问题
        List<StudentNamedEntityGraphLazyEntity> entityList = studentNamedEntityGraphLazyEntityRepository.findAll();
        return BeanUtil.copyToList(entityList, StudentAssociationBooksDto.class);
    }


    //FetchType.EAGER
    public StudentAssociationBooksDto findEagerById(Integer id) {
        //EAGER策略生效,使用findId()只有一条查询语句
        //select studentnam0_.id as id1_2_0_, studentnam0_.creator as creator2_2_0_, studentnam0_.gmt_create as gmt_crea3_2_0_, studentnam0_.gmt_modified as gmt_modi4_2_0_, studentnam0_.is_delete as is_delet5_2_0_, studentnam0_.modifier as modifier6_2_0_, studentnam0_.sort_index as sort_ind7_2_0_, studentnam0_.title as title8_2_0_, books1_.student_id as student_8_3_1_, books1_.id as id1_3_1_, books1_.id as id1_3_2_, books1_.creator as creator2_3_2_, books1_.gmt_create as gmt_crea3_3_2_, books1_.gmt_modified as gmt_modi4_3_2_, books1_.is_delete as is_delet5_3_2_, books1_.modifier as modifier6_3_2_, books1_.price as price10_3_2_, books1_.sort_index as sort_ind7_3_2_, books1_.title as title9_3_2_ from student studentnam0_ left outer join student_book books1_ on studentnam0_.id=books1_.student_id and ( books1_.is_delete=0)  where studentnam0_.id=? and ( studentnam0_.is_delete=0)
        StudentNamedEntityGraphEagerEntity entity = studentNamedEntityGraphEagerEntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, StudentAssociationBooksDto.class);
    }

    //FetchType.EAGER
    public List<StudentAssociationBooksDto> findEager() {
        //就算指定加载策略是EAGER 使用findAll()还是会有n+1问题
        List<StudentNamedEntityGraphEagerEntity> entityList = studentNamedEntityGraphEagerEntityRepository.findAll();
        return BeanUtil.copyToList(entityList, StudentAssociationBooksDto.class);
    }

    public StudentAssociationBooksDto findStudent1ById(Integer id) {
        //指定了视图,但是使用findById()的时候是两条
        //select studentnam0_.id as id1_2_0_, studentnam0_.creator as creator2_2_0_, studentnam0_.gmt_create as gmt_crea3_2_0_, studentnam0_.gmt_modified as gmt_modi4_2_0_, studentnam0_.is_delete as is_delet5_2_0_, studentnam0_.modifier as modifier6_2_0_, studentnam0_.sort_index as sort_ind7_2_0_, studentnam0_.title as title8_2_0_ from student studentnam0_ where studentnam0_.id=? and ( studentnam0_.is_delete=0)
        //select books0_.student_id as student_8_3_0_, books0_.id as id1_3_0_, books0_.id as id1_3_1_, books0_.creator as creator2_3_1_, books0_.gmt_create as gmt_crea3_3_1_, books0_.gmt_modified as gmt_modi4_3_1_, books0_.is_delete as is_delet5_3_1_, books0_.modifier as modifier6_3_1_, books0_.price as price10_3_1_, books0_.sort_index as sort_ind7_3_1_, books0_.title as title9_3_1_ from student_book books0_ where ( books0_.is_delete=0) and books0_.student_id=?
        StudentNamedEntityGraphType1Entity entity = studentNamedEntityGraphType1EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, StudentAssociationBooksDto.class);
    }

    public List<StudentAssociationBooksDto> findStudent1() {
        //使用findAll()的时候 是一条语句,不存在n+1问题
        //select studentnam0_.id as id1_2_0_, books1_.id as id1_3_1_, studentnam0_.creator as creator2_2_0_, studentnam0_.gmt_create as gmt_crea3_2_0_, studentnam0_.gmt_modified as gmt_modi4_2_0_, studentnam0_.is_delete as is_delet5_2_0_, studentnam0_.modifier as modifier6_2_0_, studentnam0_.sort_index as sort_ind7_2_0_, studentnam0_.title as title8_2_0_, books1_.creator as creator2_3_1_, books1_.gmt_create as gmt_crea3_3_1_, books1_.gmt_modified as gmt_modi4_3_1_, books1_.is_delete as is_delet5_3_1_, books1_.modifier as modifier6_3_1_, books1_.price as price10_3_1_, books1_.sort_index as sort_ind7_3_1_, books1_.title as title9_3_1_, books1_.student_id as student_8_3_0__, books1_.id as id1_3_0__ from student studentnam0_ left outer join student_book books1_ on studentnam0_.id=books1_.student_id and ( books1_.is_delete=0) where ( studentnam0_.is_delete=0)
        List<StudentNamedEntityGraphType1Entity> entityList = studentNamedEntityGraphType1EntityRepository.findAll();
        return BeanUtil.copyToList(entityList, StudentAssociationBooksDto.class);
    }

    public StudentAssociationBooksDto findStudent2ById(Integer id) {
        //指定了视图,但是使用findById()的时候是两条
        //select studentnam0_.id as id1_2_0_, studentnam0_.creator as creator2_2_0_, studentnam0_.gmt_create as gmt_crea3_2_0_, studentnam0_.gmt_modified as gmt_modi4_2_0_, studentnam0_.is_delete as is_delet5_2_0_, studentnam0_.modifier as modifier6_2_0_, studentnam0_.sort_index as sort_ind7_2_0_, studentnam0_.title as title8_2_0_ from student studentnam0_ where studentnam0_.id=? and ( studentnam0_.is_delete=0)
        //select books0_.student_id as student_8_3_0_, books0_.id as id1_3_0_, books0_.id as id1_3_1_, books0_.creator as creator2_3_1_, books0_.gmt_create as gmt_crea3_3_1_, books0_.gmt_modified as gmt_modi4_3_1_, books0_.is_delete as is_delet5_3_1_, books0_.modifier as modifier6_3_1_, books0_.price as price10_3_1_, books0_.sort_index as sort_ind7_3_1_, books0_.title as title9_3_1_ from student_book books0_ where ( books0_.is_delete=0) and books0_.student_id=?
        StudentNamedEntityGraphType2Entity entity = studentNamedEntityGraphType2EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, StudentAssociationBooksDto.class);
    }

    public List<StudentAssociationBooksDto> findStudent2() {
        //使用findAll()的时候 是一条语句,不存在n+1问题
        //select studentnam0_.id as id1_2_0_, books1_.id as id1_3_1_, studentnam0_.creator as creator2_2_0_, studentnam0_.gmt_create as gmt_crea3_2_0_, studentnam0_.gmt_modified as gmt_modi4_2_0_, studentnam0_.is_delete as is_delet5_2_0_, studentnam0_.modifier as modifier6_2_0_, studentnam0_.sort_index as sort_ind7_2_0_, studentnam0_.title as title8_2_0_, books1_.creator as creator2_3_1_, books1_.gmt_create as gmt_crea3_3_1_, books1_.gmt_modified as gmt_modi4_3_1_, books1_.is_delete as is_delet5_3_1_, books1_.modifier as modifier6_3_1_, books1_.price as price10_3_1_, books1_.sort_index as sort_ind7_3_1_, books1_.title as title9_3_1_, books1_.student_id as student_8_3_0__, books1_.id as id1_3_0__ from student studentnam0_ left outer join student_book books1_ on studentnam0_.id=books1_.student_id and ( books1_.is_delete=0) where ( studentnam0_.is_delete=0)
        List<StudentNamedEntityGraphType2Entity> entityList = studentNamedEntityGraphType2EntityRepository.findAll();
        return BeanUtil.copyToList(entityList, StudentAssociationBooksDto.class);
    }


    public StudentAssociationBooksDto findStudent3ById(Integer id) {
        //EAGER策略+指定了视图,使用 findById() 的时候是一条语句
        //select studentnam0_.id as id1_2_0_, studentnam0_.creator as creator2_2_0_, studentnam0_.gmt_create as gmt_crea3_2_0_, studentnam0_.gmt_modified as gmt_modi4_2_0_, studentnam0_.is_delete as is_delet5_2_0_, studentnam0_.modifier as modifier6_2_0_, studentnam0_.sort_index as sort_ind7_2_0_, studentnam0_.title as title8_2_0_ from student studentnam0_ where studentnam0_.id=? and ( studentnam0_.is_delete=0)
        StudentNamedEntityGraphType3Entity entity = studentNamedEntityGraphType3EntityRepository.findById(id).orElse(null);
        return BeanUtil.copyProperties(entity, StudentAssociationBooksDto.class);
    }

    public List<StudentAssociationBooksDto> findStudent3() {
        //EAGER策略+指定了视图 findAll() 的时候 是一条语句,不存在n+1问题
        //select studentnam0_.id as id1_2_0_, books1_.id as id1_3_1_, studentnam0_.creator as creator2_2_0_, studentnam0_.gmt_create as gmt_crea3_2_0_, studentnam0_.gmt_modified as gmt_modi4_2_0_, studentnam0_.is_delete as is_delet5_2_0_, studentnam0_.modifier as modifier6_2_0_, studentnam0_.sort_index as sort_ind7_2_0_, studentnam0_.title as title8_2_0_, books1_.creator as creator2_3_1_, books1_.gmt_create as gmt_crea3_3_1_, books1_.gmt_modified as gmt_modi4_3_1_, books1_.is_delete as is_delet5_3_1_, books1_.modifier as modifier6_3_1_, books1_.price as price10_3_1_, books1_.sort_index as sort_ind7_3_1_, books1_.title as title9_3_1_, books1_.student_id as student_8_3_0__, books1_.id as id1_3_0__ from student studentnam0_ left outer join student_book books1_ on studentnam0_.id=books1_.student_id and ( books1_.is_delete=0) where ( studentnam0_.is_delete=0)
        List<StudentNamedEntityGraphType3Entity> entityList = studentNamedEntityGraphType3EntityRepository.findAll();
        return BeanUtil.copyToList(entityList, StudentAssociationBooksDto.class);
    }
}
