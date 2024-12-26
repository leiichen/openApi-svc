package com.lei.chen.service;

import com.lei.chen.common.PageResp;
import com.lei.chen.model.BO.InterfaceInfoBO;
import com.lei.chen.model.BO.UserBO;
import com.lei.chen.model.DTO.InterfaceInfoReq;

/**
* @author lei
* @description 针对表【interface_info(接口信息)】的数据库操作Service
* @createDate 2024-09-28 14:16:37
*/
public interface InterfaceInfoService {
    PageResp<InterfaceInfoBO> queryPage(InterfaceInfoBO interfaceInfoBO);

    void save(InterfaceInfoBO interfaceInfoBO);

    void deleteInterfaceInfo(Long id, UserBO userBO);

    void updateInterfaceInfo(InterfaceInfoReq interfaceInfoReq, UserBO userBO);
}
