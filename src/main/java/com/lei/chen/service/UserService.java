package com.lei.chen.service;


import com.lei.chen.common.PageResp;
import com.lei.chen.model.BO.UserBO;
import com.lei.chen.model.DTO.UserVO;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户服务
 *
 * @author yupi
 */
public interface UserService{
    long userRegister(String userAccount, String userPassword, String checkPassword);

    UserVO userLogin(String userAccount, String userPassword, HttpServletRequest request);

    boolean userLogout(HttpServletRequest request);

    UserBO getUserById(long userId);

    boolean save(UserBO userBO);

    void update(UserBO userBO);

    void deleteById(Long id);

    PageResp<UserBO> queryPage(UserBO userBO);
}
