package com.huiliang.oilservice.service.Impl;

import com.huiliang.oilservice.mapper.OilMapper;
import com.huiliang.oilservice.service.OilService;
import entity.Oil;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OilServiceImpl implements OilService {
    private Logger logger= LoggerFactory.getLogger(OilServiceImpl.class);
    @Autowired
    private OilMapper oilMapper;
    @Override
    public Oil getByOilName(String name) {
        if(StringUtils.isEmpty(name)){
            logger.error("油品名为空无法查询");
            return null;
        }
        return oilMapper.getByName(name);

    }

    @Override
    public List<Oil> getAll() {
        return oilMapper.selectAll();
    }

    @Override
    public Oil getByNo(Short no) {
        if(no==null){
            logger.error("油品编号为空无法查询");
            return null;
        }
        return oilMapper.getByNo(no);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int update(Short no, BigDecimal price) {
        if(no==null||price==null){
            logger.error("输入参数有误无法更新");
            return 0;
        }
        return oilMapper.updateOilByNo(no,price);
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public int addNewOil(Oil oil) {
        if(oil==null){
            logger.error("oil记录为null无法插入");
            return 0;
        }
        return oilMapper.insert(oil);
    }
}
