package com.playko.projectManagement.application.mapper.request;

import com.playko.projectManagement.application.dto.request.UserRequestDto;
import com.playko.projectManagement.domain.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IUserRequestMapper {

    @Mapping(target = "roleModel.name", source = "nameRole")
    @Mapping(target = "roleModel.description", source = "descriptionRole")
    UserModel toUserRequest(UserRequestDto user);
}
