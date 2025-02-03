package com.sky.service;

import com.sky.dto.DishStatusDTO;

public interface DishService {
    void startOrStop(Integer status, Long id);
}
