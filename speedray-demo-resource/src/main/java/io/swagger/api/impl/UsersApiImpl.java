package io.swagger.api.impl;

import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.security.permission.PermissionThreadLocal;
import com.xtivia.mappers.LiferayUserMapper;
import com.xtivia.sgdxp.annotation.Authenticated;
import io.swagger.api.*;

import io.swagger.model.LiferayUser;

import io.swagger.api.NotFoundException;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2016-09-12T14:51:43.709-05:00")
public class UsersApiImpl implements UsersApi {
    @Authenticated
    public Response getCurrentUser(SecurityContext securityContext) throws NotFoundException {
        PermissionChecker permissionChecker = PermissionThreadLocal.getPermissionChecker();
        LiferayUser user = LiferayUserMapper.INSTANCE.userToLiferayUser(permissionChecker.getUser());
        return Response.ok().entity(
                    user!=null?user:
                        new LiferayUser() // if permission checker returns null return empty LiferayUser
                ).build();
    }
}
