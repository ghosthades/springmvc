# springmvc_task1
LaptopService
# Yêu Cầu #
- Database : Hai bảng có quan hệ one to many , một customer có thể có nhiều order , sử dụng Postgresql để tạo database.
- Framework : Sử dụng Spring MVC và hibernate .
- Chức năng:
      - Customer :
         + Hiển thị list customer
         + Thêm mới customer         
         + Tìm kiếm theo mọi trường trong bảng     
         + Với mỗi kết quả tìm kiếm có thể thực hiện các chức năng sửa xóa
         + View detail Customer
      - Order : 
         + Tương tự customer
         + Sửa , xóa order cho phép chọn customer drop down
         + Hiển thị tên của user sở hữu order

SQL Pane

  Customer
  ```SQL
  CREATE TABLE public.customer
(
  customer_id integer NOT NULL DEFAULT nextval('customer_customer_id_seq'::regclass),
  name character varying(80) NOT NULL,
  tel_number character varying(80) NOT NULL,
  CONSTRAINT customer_id PRIMARY KEY (customer_id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.customer
  OWNER TO postgres;
  ```
  Order
  ```SQL
  CREATE TABLE public."order"
(
  order_id integer NOT NULL DEFAULT nextval('order_order_id_seq'::regclass),
  customer_id integer NOT NULL DEFAULT nextval('order_customer_id_seq'::regclass),
  amount character varying(80),
  detail character varying(80),
  CONSTRAINT order_id PRIMARY KEY (order_id),
  CONSTRAINT belong_to FOREIGN KEY (customer_id)
      REFERENCES public.customer (customer_id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public."order"
  OWNER TO postgres;
  ```

Hibernate.cfg.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC "-//Hibernate/Hibernate Configuration DTD 3.0//EN" "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
  <session-factory>
    <property name="hibernate.dialect">org.hibernate.dialect.PostgreSQLDialect</property>
    <property name="hibernate.connection.driver_class">org.postgresql.Driver</property>
    <property name="hibernate.connection.username">postgres</property>
    <property name="hibernate.connection.password">Anonymous</property>
    <property name="hibernate.current_session_context_class">thread</property>
    <property name="hibernate.connection.url">jdbc:postgresql://localhost:5432/mydb</property>
    <property name="hibernate.enable_lazy_load_no_trans">true</property>
    <mapping resource="model/pojo/Customer.hbm.xml"/>
    <mapping resource="model/pojo/Order.hbm.xml"/>
  </session-factory>
</hibernate-configuration>

```

  
