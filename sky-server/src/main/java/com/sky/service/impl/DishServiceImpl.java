package com.sky.service.impl;

import com.sky.context.BaseContext;
import com.sky.dto.DishStatusDTO;
import com.sky.entity.Dish;
import com.sky.mapper.DishMapper;
import com.sky.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DishServiceImpl implements DishService {
    @Autowired
    private DishMapper dishMapper;
    @Override
    public void startOrStop(Integer status, Long id) {
        Dish dish = new Dish();
        dish.setId(id);
        dish.setStatus(status);
        dish.setUpdateTime(LocalDateTime.now());
        dish.setUpdateUser(BaseContext.getCurrentId());
        //todo 同时也要将套餐的状态也修改

        //判断菜品是否存在
        if (dishMapper.getById(id) == null){
            throw new RuntimeException("菜品不存在");
        }
        //判断状态值是否正确
        if (status !=0 && status !=1){
            throw new RuntimeException("状态值错误");
        }
        dishMapper.update(dish);
    }
}
