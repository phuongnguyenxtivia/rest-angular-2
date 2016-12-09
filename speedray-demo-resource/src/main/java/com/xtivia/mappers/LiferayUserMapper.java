package com.xtivia.mappers;

import io.swagger.model.LiferayUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import com.liferay.portal.kernel.model.User;

/**
 * Created by ddavis on 12/6/16.
 */
@Mapper
public interface LiferayUserMapper {

    LiferayUserMapper INSTANCE = MappingUtil.getMapper(LiferayUserMapper.class);

    @Mappings({
            @Mapping(source = "userId", target = "id"),
            @Mapping(source = "active", target = "active"),
            @Mapping(source = "defaultUser", target = "defaultUser"),
            @Mapping(source = "displayEmailAddress", target = "emailAddress"),
            @Mapping(source = "screenName", target = "screenName")
    })
    LiferayUser userToLiferayUser(User user);
}
