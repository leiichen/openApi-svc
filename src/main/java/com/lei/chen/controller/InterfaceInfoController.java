package com.lei.chen.controller;

import com.lei.chen.common.BaseResponse;
import com.lei.chen.common.PageResp;
import com.lei.chen.common.ResultUtils;
import com.lei.chen.constant.CommonConstant;
import com.lei.chen.model.BO.InterfaceInfoBO;
import com.lei.chen.model.BO.UserBO;
import com.lei.chen.model.DTO.InterfaceInfoReq;
import com.lei.chen.model.DTO.InterfaceInfoResp;
import com.lei.chen.service.InterfaceInfoService;
import com.lei.chen.service.UserService;
import com.lei.chen.utils.UserHolder;
import com.lei.chen.model.converter.InterfaceInfoConverter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/interfaceInfo")
@Slf4j
public class InterfaceInfoController {
    @Resource
    private InterfaceInfoService interfaceInfoService;
    @Resource
    private UserService userService;

    @GetMapping("/page")
    public BaseResponse<PageResp<InterfaceInfoResp>> listInterfaceInfoByPage(InterfaceInfoReq interfaceInfoReq) {
        InterfaceInfoBO interfaceInfoBO = InterfaceInfoConverter.INSTANCE.toInterfaceInfoBO(interfaceInfoReq);
        interfaceInfoBO.setSortField("updateTime");
        interfaceInfoBO.setSortOrder(CommonConstant.SORT_ORDER_ASC);
        PageResp<InterfaceInfoBO> interfaceInfoDOPage = interfaceInfoService.queryPage(interfaceInfoBO);
        PageResp<InterfaceInfoResp> interfaceInfoRespPage = InterfaceInfoConverter.INSTANCE.toInterfaceInfoResp(interfaceInfoDOPage);
        return ResultUtils.success(interfaceInfoRespPage);
    }

    @PostMapping("/add")
    public BaseResponse<Long> addInterfaceInfo(@RequestBody InterfaceInfoReq interfaceInfoReq) {
        UserBO userBO = UserHolder.getUser();
        interfaceInfoReq.setUpdatedBy(userBO.getUserName());
        interfaceInfoReq.setCreatedBy(userBO.getUserName());
        InterfaceInfoBO interfaceInfoBO = InterfaceInfoConverter.INSTANCE.toInterfaceInfoBO(interfaceInfoReq);
        interfaceInfoService.save(interfaceInfoBO);
        return ResultUtils.success(null);
    }

    @PostMapping("/delete")
    public BaseResponse<Void> deleteInterfaceInfo(Long id) {
        UserBO userBO = UserHolder.getUser();
        interfaceInfoService.deleteInterfaceInfo(id, userBO);
        return ResultUtils.success(null);
    }

    @PostMapping("/update")
    public BaseResponse<Void> updateInterfaceInfo(@RequestBody InterfaceInfoReq interfaceInfoReq) {
        UserBO userBO = UserHolder.getUser();
        interfaceInfoService.updateInterfaceInfo(interfaceInfoReq, userBO);
        return ResultUtils.success(null);
    }
}
