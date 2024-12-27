package com.lei.chen.service.impl;

import com.lei.chen.Repository.InterfaceInfoRepository;
import com.lei.chen.common.ErrorCode;
import com.lei.chen.common.PageResp;
import com.lei.chen.exception.BusinessException;
import com.lei.chen.model.BO.InterfaceInfoBO;
import com.lei.chen.model.BO.UserBO;
import com.lei.chen.model.DO.InterfaceInfoDO;
import com.lei.chen.model.DTO.InterfaceInfoReq;
import com.lei.chen.service.InterfaceInfoService;
import com.lei.chen.model.converter.InterfaceInfoConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.lei.chen.constant.UserConstant.ADMIN_ROLE;

/**
* @author lei
* @description 针对表【interface_info(接口信息)】的数据库操作Service实现
* @createDate 2024-09-28 14:16:37
*/
@Service
@Slf4j
public class InterfaceInfoServiceImpl implements InterfaceInfoService{

    @Resource
    private InterfaceInfoRepository interfaceInfoRepository;

    @Override
    public PageResp<InterfaceInfoBO> queryPage(InterfaceInfoBO interfaceInfoBO) {
        Integer total =  interfaceInfoRepository.queryCount(interfaceInfoBO);
        PageResp<InterfaceInfoBO> interfaceInfoBOPageResp = new PageResp<>();
        if (total == 0) {
            interfaceInfoBOPageResp.setTotal(0);
            return interfaceInfoBOPageResp;
        }
        List<InterfaceInfoDO> interfaceInfoDOS = interfaceInfoRepository.queryPage(interfaceInfoBO);
        List<InterfaceInfoBO> interfaceInfoBOS = InterfaceInfoConverter.INSTANCE.toInterfaceInfoBOList(interfaceInfoDOS);
        interfaceInfoBOPageResp.setTotal(total);
        interfaceInfoBOPageResp.setList(interfaceInfoBOS);
        return interfaceInfoBOPageResp;
    }

    @Override
    public void save(InterfaceInfoBO interfaceInfoBO) {
        interfaceInfoRepository.save(interfaceInfoBO);
    }

    @Override
    public void deleteInterfaceInfo(Long id, UserBO userBO) {
        InterfaceInfoDO interfaceInfoDO = interfaceInfoRepository.getInterfaceById(id);
        if (interfaceInfoDO == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        // 仅本人或管理员可删除
        if (!interfaceInfoDO.getCreatedBy().equals(userBO.getUserName()) && !ADMIN_ROLE.equals(userBO.getUserRole())) {
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
        interfaceInfoRepository.delete(id);
    }

    @Override
    public void updateInterfaceInfo(InterfaceInfoReq interfaceInfoReq, UserBO userBO) {
        InterfaceInfoBO interfaceInfoBO = InterfaceInfoConverter.INSTANCE.toInterfaceInfoBO(interfaceInfoReq);
        // 仅本人或管理员可修改
        if (!interfaceInfoBO.getCreatedBy().equals(userBO.getUserName()) && !ADMIN_ROLE.equals(userBO.getUserRole())) {
            throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
        }
        interfaceInfoReq.setUpdatedBy(userBO.getUserName());
        interfaceInfoRepository.update(interfaceInfoBO);
    }

}




