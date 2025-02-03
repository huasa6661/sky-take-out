package com.sky.mapper;

import com.github.pagehelper.Page;
import com.sky.dto.EmployeePageQueryDTO;
import com.sky.entity.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据用户名查询员工
     * @param username
     * @return
     */
    @Select("select * from employee where username = #{username}")
    Employee getByUsername(String username);

    /**
     * 插入员工数据
     * @param employee
     */
    @Insert("insert into employee (name, username, password, phone, sex, id_number, create_time, update_time, create_user, update_user) " +
            "values (#{name}, #{username}, #{password}, #{phone}, #{sex}, #{idNumber}, #{createTime}, #{updateTime}, #{createUser}, #{updateUser})")
    void insert(Employee employee);


    /**
     * 根据id查询员工
     * @param empId
     * @return
     */
    @Select("select * from employee where id = #{id}")
    Employee getById(Long empId);

    @Update("update employee set password = #{password} ")
    void updatePassword(Employee employee1);
    @Update("update employee set status = #{status}")
    void updateStatus(Employee employee1);

    Page<Employee> page(EmployeePageQueryDTO employeePageQueryDTO);
    @Update("update employee set name = #{name}, phone = #{phone}, sex = #{sex}, id_number = #{idNumber}, update_time = #{updateTime}, update_user = #{updateUser} where id = #{id}")
    void update(Employee employee);
}

