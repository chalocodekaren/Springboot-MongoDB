package playwithjava.in.mapper;


import playwithjava.in.DTO.request.UserDataRequest;
import playwithjava.in.DTO.response.UserDataResponse;
import playwithjava.in.entity.UserDataEntity;

public interface UserDataMapper {
    UserDataEntity mapRequestToEntity(UserDataRequest request);
    UserDataResponse mapEntityToResponse(UserDataEntity entity);
}
