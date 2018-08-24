package com.huiliang.boundaryservice.realm;

import com.huiliang.boundaryservice.remote.EmployeeRemote;
import com.huiliang.boundaryservice.service.PermissionService;
import com.huiliang.boundaryservice.service.RoleService;
import common.ServerResponse;
import entity.Employee;
import entity.Permission;
import io.jsonwebtoken.ExpiredJwtException;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import util.JWTUtil;

import java.util.List;
import java.util.Map;

@Component
public class JWTRealm extends AuthorizingRealm {
    @Autowired
    private EmployeeRemote employeeRemote;
    @Autowired
    private RoleService roleService;
    @Autowired
    private PermissionService permissionService;
    @Override
    public boolean supports(AuthenticationToken token) {
        return super.supports(token);
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        String token=principalCollection.toString();
        String username= JWTUtil.getUserName(token);
        String role=JWTUtil.getRole(token);
        ServerResponse response=employeeRemote.getByName(username);
        Map data=(Map) response.getData();
        if(data!=null||data.size()>0){
            String userId=(String)data.get("id");
            String roleId=roleService.getRoleIdByUserId(userId);
            List<String> permissionList=permissionService.getByRoleId(roleId);
            if(permissionList!=null&&permissionList.size()>0){
                simpleAuthorizationInfo.addStringPermissions(permissionList);
            }
            simpleAuthorizationInfo.addRole(role);

        }
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String token=null;
        String username=null;
        try {
            token=(String)authenticationToken.getCredentials();
            username=JWTUtil.getUserName(token);
        } catch (ExpiredJwtException e) {
            e.printStackTrace();
        }
        if(StringUtils.isEmpty(username)){
            throw new AuthenticationException("token is invalid");
        }
        ServerResponse response=employeeRemote.getByName(username);
        Map data=(Map)response.getData();
        if(data==null||data.size()==0){
            throw new AuthenticationException("username doesn't exist");
        }
        String password=(String)data.get("password");
        if(!JWTUtil.verify(token,username,password)){
            throw new AuthenticationException("password error");
        }
        return new SimpleAuthenticationInfo(token,token,"JWTRealm");
    }
}
