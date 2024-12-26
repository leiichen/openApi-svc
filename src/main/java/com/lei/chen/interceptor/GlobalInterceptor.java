package com.lei.chen.interceptor;

import com.lei.chen.common.ErrorCode;
import com.lei.chen.exception.BusinessException;
import com.lei.chen.model.BO.UserBO;
import com.lei.chen.service.UserService;
import com.lei.chen.utils.UserHolder;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.lei.chen.constant.UserConstant.USER_LOGIN_STATE;

public class GlobalInterceptor implements HandlerInterceptor {

    @Resource
    private UserService userService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 先判断是否已登录
        Object userObj = request.getSession().getAttribute(USER_LOGIN_STATE);
        UserBO currentUser = (UserBO) userObj;
        if (currentUser == null || currentUser.getId() == null) {
            throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR);
        }
        currentUser = userService.getUserById(currentUser.getId());
        if (currentUser == null) {
            throw new BusinessException(ErrorCode.NOT_LOGIN_ERROR);
        }
        UserHolder.saveUser(currentUser);
        return true;
    }
    @Override
    public void afterCompletion(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler, Exception ex) throws Exception {
        UserHolder.removeUser();
    }
}
