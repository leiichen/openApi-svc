package com.lei.chen.model.converter;

import com.lei.chen.common.PageResp;
import com.lei.chen.model.BO.UserBO;
import com.lei.chen.model.DO.UserDO;
import com.lei.chen.model.DTO.UserRequest;
import com.lei.chen.model.DTO.UserResp;
import com.lei.chen.model.DTO.UserVO;
import com.lei.chen.model.PO.UserPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserConverter {
    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    UserPO toUserPO(UserBO userBO);

    UserVO toUserVO(UserBO userBO);

    UserVO toUserVO(UserDO userDO);

    UserBO toUserBO(UserRequest userRequest);

    UserBO toUserBO(UserDO userDO);

    PageResp<UserResp> toUserResp(PageResp<UserBO> interfaceInfoDOPage);

    List<UserBO> toUserBOList(List<UserDO> userDOList);
}
