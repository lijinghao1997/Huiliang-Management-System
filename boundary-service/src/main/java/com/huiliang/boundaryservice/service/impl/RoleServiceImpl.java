package com.huiliang.boundaryservice.service.impl;

import com.huiliang.boundaryservice.mapper.RoleMapper;
import com.huiliang.boundaryservice.service.RoleService;
import entity.Role;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleMapper roleMapper;
    private Logger logger= LoggerFactory.getLogger(RoleServiceImpl.class);
    @Override
    public Role getByUserId(String userId) {
        if(StringUtils.isEmpty(userId)){
            logger.error("userId为空");
            return null;
        }
        return roleMapper.getByUserId(userId);
    }

    @Override
    public String getRoleIdByUserId(String userId) {
        if(StringUtils.isEmpty(userId)){
            logger.error("userId为空");
            return null;
        }
        return roleMapper.getRoleIdByUserId(userId);
    }
}
