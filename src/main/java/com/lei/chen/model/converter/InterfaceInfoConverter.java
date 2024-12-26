package com.lei.chen.model.converter;

import com.lei.chen.common.PageResp;
import com.lei.chen.model.BO.InterfaceInfoBO;
import com.lei.chen.model.DO.InterfaceInfoDO;
import com.lei.chen.model.DTO.InterfaceInfoReq;
import com.lei.chen.model.DTO.InterfaceInfoResp;
import com.lei.chen.model.PO.InterfaceInfoPO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface InterfaceInfoConverter {
    InterfaceInfoConverter INSTANCE = Mappers.getMapper(InterfaceInfoConverter.class);
    InterfaceInfoBO toInterfaceInfoBO(InterfaceInfoReq interfaceInfoReq);
    InterfaceInfoBO toInterfaceInfoBO(InterfaceInfoDO interfaceInfoDO);

    InterfaceInfoPO toInterfaceInfoPO(InterfaceInfoBO interfaceInfoBO);

    List<InterfaceInfoBO> toInterfaceInfoBOList(List<InterfaceInfoDO> interfaceInfoDOS);

    PageResp<InterfaceInfoResp> toInterfaceInfoResp(PageResp<InterfaceInfoBO> interfaceInfoDOPage);
}
