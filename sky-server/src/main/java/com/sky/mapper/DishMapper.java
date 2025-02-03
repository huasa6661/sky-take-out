package com.sky.mapper;

import com.sky.entity.Dish;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DishMapper {
    @Update("update dish set status = #{status} ,update_time=#{updateTime} ,update_user=#{updateUser} where id = #{id}")
    void update(Dish dish);

    @Select("select status from dish where id = #{id}")
    Dish getById(Long id);
}
