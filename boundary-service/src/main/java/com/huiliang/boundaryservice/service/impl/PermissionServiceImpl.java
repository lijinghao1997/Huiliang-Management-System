package com.huiliang.boundaryservice.service.impl;

import com.huiliang.boundaryservice.mapper.PermissionMapper;
import com.huiliang.boundaryservice.service.PermissionService;
import entity.Permission;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    private PermissionMapper permissionMapper;
    private Logger logger= LoggerFactory.getLogger(PermissionServiceImpl.class);
    @Override
    public List getByRoleId(String roleId) {
        if(StringUtils.isEmpty(roleId)){
            logger.error("roleId为空");
            return null;
        }
        return permissionMapper.getByRoleId(roleId);
    }
}
