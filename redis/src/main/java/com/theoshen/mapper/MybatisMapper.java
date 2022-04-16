package com.theoshen.mapper;

import com.theoshen.entity.UserEntity;

import java.util.List;
public interface MybatisMapper {

   List<UserEntity> queryByMysql();

}
