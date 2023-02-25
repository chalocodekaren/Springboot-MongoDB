package playwithjava.in.service;


import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import playwithjava.in.DTO.request.UserDataRequest;
import playwithjava.in.DTO.response.UserDataResponse;
import playwithjava.in.entity.UserDataEntity;
import playwithjava.in.exception.ApiException;
import playwithjava.in.mapper.UserDataMapper;
import playwithjava.in.repository.UserDataRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserDataServiceImpl implements UserDataService{

    @Autowired
    UserDataRepository userDataRepository;

    @Autowired
    ModelMapper mapper;

    @Autowired
    UserDataMapper userDataMapper;

    @Override
    public UserDataResponse addUser(UserDataRequest request) {
        System.out.println("#############"+request);
        System.out.println("data  :: "+userDataMapper.mapRequestToEntity(request));
        UserDataEntity response=userDataRepository.save(userDataMapper.mapRequestToEntity(request));
        UserDataResponse userDataResponse=userDataMapper.mapEntityToResponse(response);
        return userDataResponse;
    }

    @Override
    public UserDataResponse getUserByUserId(Long userId) {
        Optional<UserDataEntity> data= userDataRepository.findById(userId);
       if (!data.isPresent())
            throw new ApiException(404,"Entity not found");
        return userDataMapper.mapEntityToResponse(data.get());
    }

    @Override
    public List<UserDataResponse> getAllUsers() {
       return userDataRepository.findAll().parallelStream()
               .map(userDataMapper::mapEntityToResponse)
               .sorted(Comparator.comparing(UserDataResponse::getName))
               .collect(Collectors.toList());
    }
}
