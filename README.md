# javax

## @Entity

表明该类是实体类，并且使用默认的orm规则，即class名即数据库表中表名，class字段名即表中的字段名。

## @Table

指定被修饰实体的为一张表的映射对象

- name 指定表的名称

## @SecondaryTable

指定修饰的实体类的辅助表。指定一个或多个辅助表表示实体类的数据跨多个表存储。

student<----------->student_detail 两张表示1对1关系时使用,作为扩展字段

![](https://tcs-devops.aliyuncs.com/storage/112teed5a501f69ae01233a29d5a1350b6ba?Signature=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJBcHBJRCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9hcHBJZCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9vcmdhbml6YXRpb25JZCI6IiIsImV4cCI6MTY5Mjg2Mjc2NCwiaWF0IjoxNjkyMjU3OTY0LCJyZXNvdXJjZSI6Ii9zdG9yYWdlLzExMnRlZWQ1YTUwMWY2OWFlMDEyMzNhMjlkNWExMzUwYjZiYSJ9.pHsQXeEMza3dJLuPeLuQobcjoSvWTne1w4vnplejW8s&download=image.png "")

第二表的字段重新声明使用第二张表

![](https://tcs-devops.aliyuncs.com/storage/112td70468b3f701f30d22632598ce7e518c?Signature=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJBcHBJRCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9hcHBJZCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9vcmdhbml6YXRpb25JZCI6IiIsImV4cCI6MTY5Mjg2Mjc2NCwiaWF0IjoxNjkyMjU3OTY0LCJyZXNvdXJjZSI6Ii9zdG9yYWdlLzExMnRkNzA0NjhiM2Y3MDFmMzBkMjI2MzI1OThjZTdlNTE4YyJ9.PjRwpROyVwhlBXWFO8wSPnzRj5yF57b0fOGQP3d4TLQ&download=image.png "")

> 查询的时候触发数据库查询的语句 使用left join避免n+1问题

```sql
select studentand0_.id           as id1_0_0_,
       studentand0_.creator      as creator2_0_0_,
       studentand0_.gmt_create   as gmt_crea3_0_0_,
       studentand0_.gmt_modified as gmt_modi4_0_0_,
       studentand0_.is_delete    as is_delet5_0_0_,
       studentand0_.modifier     as modifier6_0_0_,
       studentand0_.sort_index   as sort_ind7_0_0_,
       studentand0_.title        as title8_0_0_,
       studentand0_1_.address    as address1_1_0_,
       studentand0_1_.age        as age2_1_0_,
       studentand0_1_.email      as email3_1_0_
from student studentand0_
       left outer join student_detail studentand0_1_ on
  studentand0_.id = studentand0_1_.student_id
where studentand0_.id = ?
  and (studentand0_.is_delete = 0);

```

> 新增的时候,根据字段的值,动态生成insert语句

![](https://tcs-devops.aliyuncs.com/storage/112t360a8e433db56ceb1be50f3362abf380?Signature=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJBcHBJRCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9hcHBJZCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9vcmdhbml6YXRpb25JZCI6IiIsImV4cCI6MTY5Mjg2Mjc2NCwiaWF0IjoxNjkyMjU3OTY0LCJyZXNvdXJjZSI6Ii9zdG9yYWdlLzExMnQzNjBhOGU0MzNkYjU2Y2ViMWJlNTBmMzM2MmFiZjM4MCJ9.4SdKZwISZBPMqGSMtNS-TYpHSa75cKx-9L4QptpBvCU&download=image.png "")

![](https://tcs-devops.aliyuncs.com/storage/112t366adadd6038b07d118c0e4584381ed7?Signature=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJBcHBJRCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9hcHBJZCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9vcmdhbml6YXRpb25JZCI6IiIsImV4cCI6MTY5Mjg2Mjc2NCwiaWF0IjoxNjkyMjU3OTY0LCJyZXNvdXJjZSI6Ii9zdG9yYWdlLzExMnQzNjZhZGFkZDYwMzhiMDdkMTE4YzBlNDU4NDM4MWVkNyJ9.T7gz4-pQhICbV4d6XxH5E6ex-K8bN-cfFBg8Hakaib8&download=image.png "")

如果设置了第二张表的字段,会触发两张表的insert语句,

同时会把第一张表的新增出来的id,设置到第二张表中

![](https://tcs-devops.aliyuncs.com/storage/112t4871db7f566c6a25074fd24ad2682741?Signature=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJBcHBJRCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9hcHBJZCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9vcmdhbml6YXRpb25JZCI6IiIsImV4cCI6MTY5Mjg2Mjc2NCwiaWF0IjoxNjkyMjU3OTY0LCJyZXNvdXJjZSI6Ii9zdG9yYWdlLzExMnQ0ODcxZGI3ZjU2NmM2YTI1MDc0ZmQyNGFkMjY4Mjc0MSJ9.7hi8Gl5e7-0m5HiNoXe8cojNa9NJBf6qmg2ZocY99nw&download=image.png "")

![](https://tcs-devops.aliyuncs.com/storage/112t54e9f61800ce91b54d01b014ffcc89bb?Signature=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJBcHBJRCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9hcHBJZCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9vcmdhbml6YXRpb25JZCI6IiIsImV4cCI6MTY5Mjg2Mjc2NCwiaWF0IjoxNjkyMjU3OTY0LCJyZXNvdXJjZSI6Ii9zdG9yYWdlLzExMnQ1NGU5ZjYxODAwY2U5MWI1NGQwMWIwMTRmZmNjODliYiJ9.dUlZtDru12BCYU3CLXrnjUlBYSZY6DwVWQZCcwRF4_s&download=image.png "")

如果不设置了第二张表的字段,只会触发主表的insert语句

## @SecondaryTables

指定多个SecondaryTable

## @Version

指定用作其乐观锁定值的实体类的版本字段或属性。该版本用于在执行合并操作时确保完整性和乐观并发控制。
每个类只能使用一个 Version 属性或字段;该字段不能为空

属性支持以下类型int\Integer\short\Short\long\Long\java.sql.Timestamp

![](https://tcs-devops.aliyuncs.com/storage/112u8c533aa3e7be98021f5457edf4a6f1b9?Signature=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJBcHBJRCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9hcHBJZCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9vcmdhbml6YXRpb25JZCI6IiIsImV4cCI6MTY5Mjg2Mjc2NCwiaWF0IjoxNjkyMjU3OTY0LCJyZXNvdXJjZSI6Ii9zdG9yYWdlLzExMnU4YzUzM2FhM2U3YmU5ODAyMWY1NDU3ZWRmNGE2ZjFiOSJ9.jn4m-4gWKHVwALhUe-s07FBBzJlApFGCJ6jPjiRdOko&download=image.png "")

实体先find出来再save的会使用version字段为条件

![](https://tcs-devops.aliyuncs.com/storage/112u44f0fade881e177d1e1919158850eb17?Signature=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJBcHBJRCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9hcHBJZCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9vcmdhbml6YXRpb25JZCI6IiIsImV4cCI6MTY5Mjg2Mjc2NCwiaWF0IjoxNjkyMjU3OTY0LCJyZXNvdXJjZSI6Ii9zdG9yYWdlLzExMnU0NGYwZmFkZTg4MWUxNzdkMWUxOTE5MTU4ODUwZWIxNyJ9.XnOm2KIhFWNLIgqfM7x85WusqGA6QY67M99oSBkWDUs&download=image.png "")

如果version值不相同就会抛出异常ObjectOptimisticLockingFailureException

![](https://tcs-devops.aliyuncs.com/storage/112u80a3fcafd9048845d21ddae2f638d70f?Signature=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJBcHBJRCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9hcHBJZCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9vcmdhbml6YXRpb25JZCI6IiIsImV4cCI6MTY5Mjg2Mjc2NCwiaWF0IjoxNjkyMjU3OTY0LCJyZXNvdXJjZSI6Ii9zdG9yYWdlLzExMnU4MGEzZmNhZmQ5MDQ4ODQ1ZDIxZGRhZTJmNjM4ZDcwZiJ9.Oz9jZdSVeUcYm21Bqm5Xhah_2jgtWOePmWJAFTrg_b4&download=image.png "")

## @OneToOne

指定与具有一对一多重性的另一个实体的单值关联。通常不需要显式指定关联的目标实体，因为它通常可以从所引用对象的类型推断出来。如果关系是双向的，则必须使用该
mappedBy元素来指定作为关系所有者的实体的关系字段或属性

存在顾客和顾客记录两个实体 一个顾客只能关联一个记录

> ~~双向关联(禁止)~~

```java
// On Customer class:

@OneToOne(optional = false)
@JoinColumn(name = "CUSTREC_ID", unique = true, nullable = false, updatable = false)
private CustomerRecord customerRecord;


// On CustomerRecord class:

@OneToOne(optional = false, mappedBy = "customerRecord")
private Customer customer();

```

> 单向使用id关联

```java
// On Customer class:

@OneToOne(optional = false)
@JoinColumn(name = "CUSTREC_ID", nullable = false)

private CustomerRecord customerRecord;

```

属性介绍

- cascadeType

  - ALL 包含(PERSIST,REMOVE,REFRESH,DETACH)

  - PERSIST 新增的时候级联新增

  - MERGE 修改的时候级联修改,修改的时候不存在新增

  - REMOVE 删除的时候级联删除

  - REFRESH 强制刷新实体(使用hibernate的session有用)

  - DETACH 分离实体操作(使用hibernate的session有用)

- fetch

  - EAGER(默认) 强制加载

  - LAZY 只有被访问到的时候才会加载

- optional

  - true(默认) 允许数据库字段为null

  - false 禁止数据库字段为null

- orphanRemoval

  - false(默认) 双向关联中被动的一方删除,同时删除主动的一方

  - true 双向关联中被动的一方删除,只删除当前表记录

## @OneToMany

指定具有一对多多重性的多值关联。

OneToMany注释可以在实体类中包含的可嵌入类中使用，以指定与实体集合的关系。如果关系是双向的，则必须使用该
mappedBy元素来指定作为关系所有者的实体的关系字段或属性。

存在顾客和订单两个实体 一个顾客可以关联多个订单

> 单向关联,使用JoinColumn指定字段名称

```java
// In Customer class:

@OneToMany(orphanRemoval = true)
@JoinColumn(name = "CUST_ID")
private List<Order> orders;

```

> ~~双单向关联,同时使用joinColumn指定字段名称(禁止)~~

```java
// In Customer class:
@OneToMany
@JoinColumn(name = "CUST_ID")
private List<Order> orders;

//In Order class:

@ManyToOne
@JoinColumn(name = "CUST_ID", nullable = false)
private Customer customer;

```

> 双向关联,必须执行mappedBy指定对方属性

```java
// In Customer class:
@OneToMany(cascade = ALL, mappedBy = "customer")
private List<Order> orders;

//In Order class:

@ManyToOne
@JoinColumn(name = "CUST_ID", nullable = false)
private Customer customer;

```

使用方式二和方式三 生成的查询SQL都是使用 left outer join 并表没有区别

属性介绍

- cascadeType

  - ALL 包含(PERSIST,REMOVE,REFRESH,DETACH)

  - PERSIST 新增的时候级联新增

  - MERGE 修改的时候级联修改,修改的时候不存在新增

  - REMOVE 删除的时候级联删除

  - REFRESH 强制刷新实体(使用hibernate的session有用)

  - DETACH 分离实体操作(使用hibernate的session有用)

- fetch

  - EAGER(默认) 强制加载

  - LAZY 只有被访问到的时候才会加载

- orphanRemoval

  - false(默认) 双向关联中被动的一方删除,同时删除主动的一方

  - true 双向关联中被动的一方删除,只删除当前表记录

## @ManyToOne

指定与具有多对一多重性的另一个实体类的单值关联。

ManyToOne可以在可嵌入类中使用批注来指定从可嵌入类到实体类的关系。如果关系是双向的，则非拥有OneToMany实体端必须使用批注的元素来mappedBy指定关系的可嵌入字段的关系字段或属性或关系的OneToMany拥有端的属性。

存在顾客和订单两个实体 一个顾客可以关联多个订单



> 单向关联,同时使用joinColumn指定字段名称

```java
// In Customer class:
@OneToMany
@JoinColumn(name = "CUST_ID")
private List<Order> orders;

//In Order class:

@ManyToOne
@JoinColumn(name = "CUST_ID", nullable = false)
private Customer customer;

```

> 双向关联,必须执行mappedBy指定对方属性

```java
// In Customer class:
@OneToMany(cascade = ALL, mappedBy = "customer")
private List<Order> orders;

//In Order class:

@ManyToOne
@JoinColumn(name = "CUST_ID", nullable = false)
private Customer customer;
```

使用方式一和方式二 生成的查询SQL都是使用 left outer join 并表没有区别,其他属性属性情况完全类似OneToMany

## @ManyToMany

指定具有多对多多重性的多值关联。

每个多对多关联都有两面，即拥有方和非拥有方或反向方。关系的连接表（如果未缺省）在拥有端指定。如果关系是双向的，则非拥有方必须使用注释的ManyToMany元素来mappedBy指定拥有方的关系字段或属性。使用JoinTable声明中间关联表,主动方使用joinColumns指定关联ID,如果有额外条件查询使用WhereJoinTable

使用ManyToMany对中间关联表进行托管维护的时候,删除逻辑是进行物理删除,进行编辑更新的时候,先把旧的关联数据全量删除,再全量保存本次的数据.不会进行增量修改

> 单向多对多关联

```java
// In Customer class:
@ManyToMany
@JoinTable(name = "CUST_PHONE",
        joinColumns =
        @JoinColumn(name = "CUST_ID"),
        inverseJoinColumns =
        @JoinColumn(name = "PHONE_ID"
        )
        public List<PhoneNumber>phones;
```

> 双向多对多关联

```java
// In Customer class:
@ManyToMany
@JoinTable(name = "CUST_PHONE",
        joinColumns =
        @JoinColumn(name = "CUST_ID"),
        inverseJoinColumns =
        @JoinColumn(name = "PHONE_ID"
        )
        public List<PhoneNumber>phones;

// In PhoneNumberClass:

        @ManyToMany(mappedBy = "phones")
        public List<Customer>customers;

```

> 使用WhereJoinTable

要添加到集合连接表的where子句。该子句是用SQL编写的。与Where功能类似

```java
// In Customer class:
@ManyToMany
@WhereJoinTable(clause = "gmt_create > NOW() AND is_delete=0")
@JoinTable(name = "CUST_PHONE",
        joinColumns =
        @JoinColumn(name = "CUST_ID"),
        inverseJoinColumns =
        @JoinColumn(name = "PHONE_ID"
        )
        public List<PhoneNumber>phones;
```

属性介绍

- cascadeType 使用cascadeType会同时操作三张表,由于正常情况下,只是需要当前表和关联表,所以cascadeType属性通常不会被用到,如果有需要参考OneToMany

- fetch

  - EAGER(默认) 强制加载

  - LAZY 只有被访问到的时候才会加载

- orphanRemoval

  - false(默认) 双向关联中被动的一方删除,同时删除主动的一方

  - true 双向关联中被动的一方删除,只删除当前表记录

## @JoinColumn

指定用于联接实体关联或元素集合的列。如果不指定数据库字段名称,默认使用'{entity名称}_id'

常常搭配 ManyToOne OneToMany OneToOne JoinTable 使用

属性介绍

- name 外键列的名称。使用当前表的列名称还是目标表的列名称取决于搭配的级联关系

  - 如果联接用于使用 OneToOne 或 ManyToOne映射，则外键列位于当前表。

  - 如果联接用于使用 OneToMany 映射，则外键位于目标表中。

  - 如果连接用于ManyToMany的JoinTable映射，则外键位于连接表中。

- table 外键列所在表名称。使用当前表的名称还是目标表的名称取决于搭配的级联关系

  - 如果联接用于使用 OneToOne 或 ManyToOne映射，则外键列位于当前表。

  - 如果联接用于使用 OneToMany 映射，则外键位于目标表中。

  - 如果连接用于ManyToMany的JoinTable映射，则外键位于连接表中。

- referencedColumnName 一般情况下，关联的实体的主键用来作外键。如果不想使用主键作为外键，则使用

- insertTable 是否新增时同步新增级联表

- updateTable 是否更新时同步更新级联表

- unique 是否唯一 (通过entity创建表时)

- nullable 是否意味为空(通过entity创建表时)

- foreignKey 外键名称(通过entity创建表时)

## @Type

映射指定数据库中的值到自定义模型中,需要先使用@TypeDef在entity上面定义设置的自定义类型名称和class

```java

@Entity
@Table(name = "student_detail")

@TypeDef(name = "json", typeClass = JsonStringType.class)
public class StudentDetailTypeJsonEntity {
    ...

  /**
   * 描述json字段
   */
  @Type(type = "json")
  private StudentDescriptionDto description;
}

```

## @Transient(禁止)

指定属性或字段不是永久性的。它用于批注实体类、映射超类或可嵌入类的属性或字段。将 Java
对象持久化到数据库记录时，我们可以通过@Transient注解忽略某些字段。

```java

@Entity
public class Employee {
  @Id
  private Integer id;

  @Transient
  private User currentUser;

}
```

> @Transient注解与transient关键字区别

@Transient注释和 Java 内置的transient关键字之间的关系通常存在一些混淆。transient关键字主要用于在Java
对象序列化期间忽略字段，但它也可以防止在使用 JPA 框架时保留这些字段。

**换句话说，在保存到数据库时，*****transient关键字与@Transient*****注解具有相同的效果。但是*****@Transient*****注解不影响
Java 对象序列化结果**

## @NamedEntityGraph

用于指定查找操作或查询的路径和边界

在所有的级联关系注解中，都有一个fetch属性，@OneToOne、@ManyToOne中默认是FetchType.EAGER。@OneToMany、@ManyToMany是FetchType.LAZY。

加载策略的在SQL语句上的体现是FetchType.EAGER使用的是一条语句JOIN出并表查询出所有字段。FetchType.LAZY使用的是另外SELECT一次查询字段

但是对于JPA的fetch，只有在使用默认的findById方法时，配置的fetch=FetchType.EAGER才会生效。其余所有查询方法都不会生效,还是使用懒加载模式.

![](https://tcs-devops.aliyuncs.com/storage/112u6c3e48345a489daebccae07b2abe191b?Signature=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJBcHBJRCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9hcHBJZCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9vcmdhbml6YXRpb25JZCI6IiIsImV4cCI6MTY5Mjg2Mjc2NCwiaWF0IjoxNjkyMjU3OTY0LCJyZXNvdXJjZSI6Ii9zdG9yYWdlLzExMnU2YzNlNDgzNDVhNDg5ZGFlYmNjYWUwN2IyYWJlMTkxYiJ9.ICCD-BANq1d9VQ8rxlmxl6ugWDKrSEY4F6qbhmUduMQ&download=image.png "")

所以不管如果设置加载策略,都有可能出现n+1问题，所以实体视图就是为了解决这个问题

> 在entity上声明,并且在repository的查询方法上指定名称

```java
// In Item class:
@Entity
@NamedEntityGraph(name = "Item.characteristics",
        attributeNodes = @NamedAttributeNode("characteristics")
)
public class Item {

  @OneToMany(mappedBy = "item")
  private List<Characteristic> characteristics = new ArrayList<>();
}


// In ItemRepository class 
public interface ItemRepository extends JpaRepository<Item, Long> {

  @EntityGraph(value = "Item.characteristics")
  Item findByName(String name);
}

```

> 只在repository查询方法上声明临时实体图

```text
// In Item class:
@Entity

public class Item {

	@OneToMany(mappedBy = "item")
    private List<Characteristic> characteristics = new ArrayList<>();
}


// In ItemRepository class 
public interface ItemRepository extends JpaRepository<Item, Long> {

	@EntityGraph(attributePaths = {"characteristics"})
    Item findByName(String name);
}
```

# hibernate

## @SQLDelete

JPA中提供了简单的CRUD操作，其中删除操作是物理删除

SQLDelete修饰的entity只要执行JPA的删除操作，执行的SQL语句为我们自己定义的SQL语句实现逻辑删除操作

## @Where

为entity的查询提供where 子句,该子句是用 SQL 编写的。此处的一个常见用例是软删除.

使where修饰的entity实体会使用where条件

使用where修饰的级联字段会使用where条件,级联出来的子类中也会使用where条件

注意如果跳过hibernate,直接使用原生SQL查询@where条件会失效

## @DynamicInsert

在DDL语句中指定列的默认值,就可以在insert语句中不指定该字段的值,新增的结果会赋初值,

但是在使用entity进行新增操作时,字段如果为null,调用save方法,新增的数据依然为null,DDL中的初始值失去效果

![](https://tcs-devops.aliyuncs.com/storage/112ta635f77e8f0f21e3252e81b7159af554?Signature=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJBcHBJRCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9hcHBJZCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9vcmdhbml6YXRpb25JZCI6IiIsImV4cCI6MTY5Mjg2Mjc2NCwiaWF0IjoxNjkyMjU3OTY0LCJyZXNvdXJjZSI6Ii9zdG9yYWdlLzExMnRhNjM1Zjc3ZThmMGYyMWUzMjUyZTgxYjcxNTlhZjU1NCJ9.JFb4SAY9e32SBQsxMA_Mka7xnjOW6jqa_G044KQTkOo&download=image.png "")

![](https://tcs-devops.aliyuncs.com/storage/112tfda490db0e4131d465281f0bc41d923e?Signature=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJBcHBJRCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9hcHBJZCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9vcmdhbml6YXRpb25JZCI6IiIsImV4cCI6MTY5Mjg2Mjc2NCwiaWF0IjoxNjkyMjU3OTY0LCJyZXNvdXJjZSI6Ii9zdG9yYWdlLzExMnRmZGE0OTBkYjBlNDEzMWQ0NjUyODFmMGJjNDFkOTIzZSJ9.rioHhaw_-zyazryBrdhYvWUkNthbK_XkvduvP6sB-rE&download=image.png "")

在以上表结构和entity映射场景下,new出一个空对象,然后执行save方法,由于new出对象没有设置title,所以数据库报错,执行的SQL语句为

![](https://tcs-devops.aliyuncs.com/storage/112t6f880cabe5f542ac825f0c43ed214024?Signature=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJBcHBJRCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9hcHBJZCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9vcmdhbml6YXRpb25JZCI6IiIsImV4cCI6MTY5Mjg2Mjc2NCwiaWF0IjoxNjkyMjU3OTY0LCJyZXNvdXJjZSI6Ii9zdG9yYWdlLzExMnQ2Zjg4MGNhYmU1ZjU0MmFjODI1ZjBjNDNlZDIxNDAyNCJ9.swWOTWwSBKuG1l2JnPm4LKjmlZfDdkXz2dbl6Hzwets&download=image.png "")

如果使用@DynamicInsert注解之后,会忽略掉数据中设置初始值的属性,正常插入数据

![](https://tcs-devops.aliyuncs.com/storage/112t6861b7ef363e2a81390b90e3e6b15489?Signature=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJBcHBJRCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9hcHBJZCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9vcmdhbml6YXRpb25JZCI6IiIsImV4cCI6MTY5Mjg2Mjc2NCwiaWF0IjoxNjkyMjU3OTY0LCJyZXNvdXJjZSI6Ii9zdG9yYWdlLzExMnQ2ODYxYjdlZjM2M2UyYTgxMzkwYjkwZTNlNmIxNTQ4OSJ9.TW2023J9rqHIo65K7AE5303WcNg2IMSYFifuFP-Bqzg&download=image.png "")

## @DynamicUpdate

被修饰的实体同一个会话内,update语句中只有被修改的字段

依然使用上述表和实体映射字段,正常情况下更新触发的update语句为

![](https://tcs-devops.aliyuncs.com/storage/112t079f0ea7c484a8718c746b092adb4053?Signature=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJBcHBJRCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9hcHBJZCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9vcmdhbml6YXRpb25JZCI6IiIsImV4cCI6MTY5Mjg2Mjc2NCwiaWF0IjoxNjkyMjU3OTY0LCJyZXNvdXJjZSI6Ii9zdG9yYWdlLzExMnQwNzlmMGVhN2M0ODRhODcxOGM3NDZiMDkyYWRiNDA1MyJ9.YLyIZbTX4P-5uaSrNzoGOL8r9JNn0FEXzquPlGTheeg&download=image.png "")

如果使用@DynamicUpdate注解之后,会值更新被修改的字段,减少不必要的SQL更新

![](https://tcs-devops.aliyuncs.com/storage/112t89ce685cfe87e8fe58c57a883ca2a7b6?Signature=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJBcHBJRCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9hcHBJZCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9vcmdhbml6YXRpb25JZCI6IiIsImV4cCI6MTY5Mjg2Mjc2NCwiaWF0IjoxNjkyMjU3OTY0LCJyZXNvdXJjZSI6Ii9zdG9yYWdlLzExMnQ4OWNlNjg1Y2ZlODdlOGZlNThjNTdhODgzY2EyYTdiNiJ9.-7hHPh_-lmqh18cMROFfUCDO_4h3fgo9po7sg9eEQNs&download=image.png "")

注意 使用之前一定需要先查询出来,否则依然无效

## ~~@NotFound(禁止)~~

在关联中找不到元素时要执行的操作

当使用OneToOne或者ManyToOne进行关联的时候,如果级联出来的one一方找不到或者不存在,当前数据会受到影响,具体影响区分情况

iiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii使用FETCH.EAGER的时候会导致当前整个实体找不到

使用FETCH.LZAY的时候会直接报错,实体不存在

这时候需要@NotFound(action = NotFoundAction.IGNORE)忽略级联出来对象为null的情况

```java

@ManyToOne
@NotFound(action = NotFoundAction.IGNORE)
private StudentNotFoundManyToOneEntity student;

```

## @WhereJoinTable

要添加到集合连接表的where子句。该子句是用SQL编写的。与Where功能类似

指定关联中间表和ManyToMany组合使用,

和Where进行对比

```java
// In Customer class:
@ManyToMany
@Where(clause = "gmt_create >'2022-06-02 10:49:46'")
@WhereJoinTable(clause = "gmt_create >'2023-06-02 10:49:46'")
@JoinTable(name = "CUST_PHONE",
        joinColumns =
        @JoinColumn(name = "CUST_ID"),
        inverseJoinColumns =
        @JoinColumn(name = "PHONE_ID"
        )
        public List<PhoneNumber>phones;
```

打印生成SQL语句

```sql
where
  (phone_number.gmt_create >'2022-06-02 10:49:46')
  and ( cust_phone.gmt_create >'2023-06-02 10:49:46')

```

发现Where的条件是加在phone_number目标表上,WhereJoinTable的条件是加在cust_phone中间关联表上

# lombok

## @EqualsAndHashCode

根据相关字段生成的equals和hashCode方法的实现。默认不使用父类属性

- exclude 此处列出的任何字段都不会在生成 equals 和 hashCode 实现中考虑在内,与 互 of()斥。即将过时,推荐使用
  @EqualsAndHashCode.Exclude

- of 如果存在，则显式列出要用于标识的字段。通常，所有非静态、非瞬态字段都用于标识,与 互 exclude()斥。即将过时,推荐使用
  @EqualsAndHashCode.Include 注释与 onlyExplicitlyIncluded = true一起使用

- onlyExplicitlyIncluded 是否仅包含显式标有的@EqualsAndHashCode.Include字段和方法。

- callSuper 是否需要将父类的equals和hashCode包含计算在内

- doNotUseGetters 默认情况下,比较使用的get方法获取值。设置为ture可以,直接调用this.字段跳过get方法

### 使用常见坑点

> 子类继承父类时要子类设置callSuper=true

否则无法调用父类属性比较,相当于没有父类属性(没有id)

![](https://tcs-devops.aliyuncs.com/storage/112t2691159ed1d4ef16b69c3d7f5ea47c9e?Signature=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJBcHBJRCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9hcHBJZCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9vcmdhbml6YXRpb25JZCI6IiIsImV4cCI6MTY5Mjg2Mjc2NCwiaWF0IjoxNjkyMjU3OTY0LCJyZXNvdXJjZSI6Ii9zdG9yYWdlLzExMnQyNjkxMTU5ZWQxZDRlZjE2YjY5YzNkN2Y1ZWE0N2M5ZSJ9.7sAPSrA4oWK1TIa8k_WIKL2pbY9LqBfmIFD5H3NghZ0&download=image.png "")

> 父类自己要声明@EqualsAndHashCode

子类继承父类情况下,子类执行equals的时,会调用super.equals(),如果不同比较结果永远不同

![](https://tcs-devops.aliyuncs.com/storage/112t83e4099a3a590d8c0ec1e0d94c41afab?Signature=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJBcHBJRCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9hcHBJZCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9vcmdhbml6YXRpb25JZCI6IiIsImV4cCI6MTY5Mjg2Mjc2NCwiaWF0IjoxNjkyMjU3OTY0LCJyZXNvdXJjZSI6Ii9zdG9yYWdlLzExMnQ4M2U0MDk5YTNhNTkwZDhjMGVjMWUwZDk0YzQxYWZhYiJ9.yReLU265URUGGoDkQSMrFckiIuXz9bgyqRd1LlRtYyU&download=image.png "")

> @ManytoOne 或者 OneToOne时排除级联出来的对象

![](https://tcs-devops.aliyuncs.com/storage/112u2246072777801eb450a3de07a56b6467?Signature=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJBcHBJRCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9hcHBJZCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9vcmdhbml6YXRpb25JZCI6IiIsImV4cCI6MTY5Mjg2Mjc2NCwiaWF0IjoxNjkyMjU3OTY0LCJyZXNvdXJjZSI6Ii9zdG9yYWdlLzExMnUyMjQ2MDcyNzc3ODAxZWI0NTBhM2RlMDdhNTZiNjQ2NyJ9.BU4FeWllxKlPJAfUbYFszZePEMGocl6-Nghn4VL_xO0&download=image.png "")

比较的时候会忽略整个级联出来的对象,相当于没有student_id字段

这时候需要显示声明出studentId字段,并且设置级联出来的对象新增/更新忽略掉(否则一个数据库字段映射两个entity字段,无法启动)

![](https://tcs-devops.aliyuncs.com/storage/112uf623b7229e477879cabef95111382192?Signature=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJBcHBJRCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9hcHBJZCI6IjVlNzQ4MmQ2MjE1MjJiZDVjN2Y5YjMzNSIsIl9vcmdhbml6YXRpb25JZCI6IiIsImV4cCI6MTY5Mjg2Mjc2NCwiaWF0IjoxNjkyMjU3OTY0LCJyZXNvdXJjZSI6Ii9zdG9yYWdlLzExMnVmNjIzYjcyMjllNDc3ODc5Y2FiZWY5NTExMTM4MjE5MiJ9.2dLW1abRTVfuHBZEw_QUV8j_TEC4yeAbqho9CfEPorM&download=image.png "")

# 具体代码演示

## [spring持久化教程](https://www.baeldung.com/learn-jpa-hibernate)

## [jpa-demo代码参考](https://blog.csdn.net/king101125s/article/details/104507856)

# 参考资料

### [Spring-jpa教程](https://blog.csdn.net/jerry741/article/details/109785674)

### [DynamicUpdate注解](https://www.cnblogs.com/caofanqi/p/11902159.html)

### 级联CascadeType类型

### 加载策略和实体图



