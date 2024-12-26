package com.lei.chen.Repository;

import com.lei.chen.mapper.InterfaceInfoMapper;
import com.lei.chen.model.BO.InterfaceInfoBO;
import com.lei.chen.model.DO.InterfaceInfoDO;
import com.lei.chen.model.PO.InterfaceInfoPO;
import com.lei.chen.model.converter.InterfaceInfoConverter;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository
public class InterfaceInfoRepository {
    @Resource
    private InterfaceInfoMapper interfaceInfoMapper;


    public Integer queryCount(InterfaceInfoBO interfaceInfoBO) {
        InterfaceInfoPO interfaceInfoPO = InterfaceInfoConverter.INSTANCE.toInterfaceInfoPO(interfaceInfoBO);
        return interfaceInfoMapper.queryCount(interfaceInfoPO);
    }

    public List<InterfaceInfoDO> queryPage(InterfaceInfoBO interfaceInfoBO) {
        InterfaceInfoPO interfaceInfoPO = InterfaceInfoConverter.INSTANCE.toInterfaceInfoPO(interfaceInfoBO);
        return interfaceInfoMapper.queryPage(interfaceInfoPO);
    }

    public void save(InterfaceInfoBO interfaceInfoBO) {
        InterfaceInfoPO interfaceInfoPO = InterfaceInfoConverter.INSTANCE.toInterfaceInfoPO(interfaceInfoBO);
        interfaceInfoMapper.save(interfaceInfoPO);
    }

    public void delete(Long id) {
        interfaceInfoMapper.delete(id);
    }

    public InterfaceInfoBO getInterfaceById(Long id) {
        InterfaceInfoDO interfaceInfoDO = interfaceInfoMapper.getInterfaceById(id);
        return InterfaceInfoConverter.INSTANCE.toInterfaceInfoBO(interfaceInfoDO);
    }

    public void update(InterfaceInfoBO interfaceInfoBO) {
        InterfaceInfoPO interfaceInfoPO = InterfaceInfoConverter.INSTANCE.toInterfaceInfoPO(interfaceInfoBO);
        interfaceInfoMapper.update(interfaceInfoPO);
    }
}
