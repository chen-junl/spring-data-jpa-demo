package com.example.demotest.repository.many_to_many;

import com.example.demotest.entity.many_to_many.where_join_table.CourseManyToManyWhereJoinTableEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseManyToManyWhereJoinTableEntityRepository extends JpaRepository<CourseManyToManyWhereJoinTableEntity, Integer> {
    /**
     * 根据标题查询
     *
     * @param title
     * @return
     */
    List<CourseManyToManyWhereJoinTableEntity> findByTitle(String title);

    /**
     * 根据标题查询
     *
     * @param title
     * @return
     */
    @Query(value = "from CourseManyToManyWhereJoinTableEntity where title =?1")
    List<CourseManyToManyWhereJoinTableEntity> findByTitleQuery(String title);


    /**
     * 根据标题查询
     * *****注意这是错误方式*****
     *
     * @param title
     * @return
     */
    @Query(value = "select t1 from CourseManyToManyWhereJoinTableEntity as t1 " +
            "left join StudentManyToManyWhereJoinTableEntity as t2 on t2.gmtCreate >'2021-06-02 10:49:46' " +
            "where t1.title =?1")
    List<CourseManyToManyWhereJoinTableEntity> findByTitleQuery2(String title);

    /**
     * 根据标题查询
     *
     * @param title
     * @return
     */
    @Query(value = "SELECT * FROM course WHERE title =?1", nativeQuery = true)
    List<CourseManyToManyWhereJoinTableEntity> findByTitleQueryNative(String title);


}