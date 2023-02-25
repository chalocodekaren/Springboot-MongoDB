package playwithjava.in.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import playwithjava.in.DTO.request.UserDataRequest;
import playwithjava.in.DTO.response.UserDataResponse;
import playwithjava.in.service.UserDataService;
import java.util.List;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserDataController {
    @Autowired
    UserDataService userDataService;

    @GetMapping("/")
    public ResponseEntity<String> callUser(){
        log.info("## Welcome to PlayWithJavaCode Demo");
        return new ResponseEntity<>("Welcome to PlayWithJavaCode Demo", HttpStatus.OK);
    }

    @PostMapping("/addUser")
    public ResponseEntity<UserDataResponse> addUser(@RequestBody UserDataRequest request){
        UserDataResponse UserDataResponse =userDataService.addUser(request);
        return new ResponseEntity<>(UserDataResponse, HttpStatus.OK);
    }

    @GetMapping("/getUserByUserId/{userId}")
    public ResponseEntity<UserDataResponse> getUserByUserId(@PathVariable Long userId){
        UserDataResponse UserDataResponse =userDataService.getUserByUserId(userId);
        return new ResponseEntity<>(UserDataResponse, HttpStatus.OK);
    }

    @GetMapping("/getAllUsers")
    public ResponseEntity<List<UserDataResponse>> getAllUserData(){
        List<UserDataResponse> allUsers =userDataService.getAllUsers();
        System.out.println("get all data ..");
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }
}
