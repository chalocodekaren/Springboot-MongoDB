package playwithjava.in.service;
import playwithjava.in.DTO.request.UserDataRequest;
import playwithjava.in.DTO.response.UserDataResponse;

import java.util.List;

public interface UserDataService {

    public UserDataResponse addUser(UserDataRequest request);
    public UserDataResponse getUserByUserId(Long userId);
    public List<UserDataResponse> getAllUsers();
}
