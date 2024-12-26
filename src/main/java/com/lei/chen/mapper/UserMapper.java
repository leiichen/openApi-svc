package com.lei.chen.mapper;

import com.lei.chen.model.DO.UserDO;
import com.lei.chen.model.PO.UserPO;

import java.util.List;


public interface UserMapper {

    Integer queryCount(UserPO userPO);

    List<UserDO> queryPage(UserPO userPO);

    void save(UserPO userPO);

    void delete(Long id);

    UserDO getUserById(Long id);

    void update(UserPO userPO);

    UserDO selectOne(UserPO userPO);
}




