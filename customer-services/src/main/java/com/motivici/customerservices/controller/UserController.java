package com.motivici.customerservices.controller;

import com.motivici.customerservices.model.request.CreateUserRequestModel;
import com.motivici.customerservices.model.response.UsersModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("users")
public class UserController {

    @GetMapping(path="/{userId}",
                produces = {
                        MediaType.APPLICATION_XML_VALUE,
                        MediaType.APPLICATION_JSON_VALUE
                })
    public ResponseEntity<UsersModel> getUsers(@PathVariable String userId){
        UsersModel usersModel = new UsersModel();
        usersModel.setUserId("1");
        usersModel.setFirstName("Samet");
        usersModel.setLastName("Eren");
        usersModel.setEmail("samet.eren98@icloud.com");
        return new ResponseEntity<UsersModel>(usersModel,HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    public String getUsers(@RequestParam(value = "page", defaultValue = "1", required = false) int page,
                    @RequestParam(value = "limit") int limit,
                    @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort){
        return "getting user =  " + limit + page + sort ;
    }

    @PostMapping(
            produces = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            },
            consumes = {
                    MediaType.APPLICATION_XML_VALUE,
                    MediaType.APPLICATION_JSON_VALUE
            }
    )
    public ResponseEntity<UsersModel> createUser(@Valid @RequestBody CreateUserRequestModel createUserRequestModel){
        UsersModel usersModel = new UsersModel();
        usersModel.setUserId(createUserRequestModel.getUserId());
        usersModel.setFirstName(createUserRequestModel.getFirstName());
        usersModel.setLastName(createUserRequestModel.getLastName());
        usersModel.setEmail(createUserRequestModel.getEmail());
        return new ResponseEntity<UsersModel>(usersModel,HttpStatus.OK);
    }

    @PutMapping
    public String updateUser(){
        return "updating user";
    }

    @DeleteMapping
    public String deleteUser(){
        return "deleting user";
    }
}
