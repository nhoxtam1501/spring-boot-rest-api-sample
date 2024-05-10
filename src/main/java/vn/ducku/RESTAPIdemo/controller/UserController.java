package vn.ducku.RESTAPIdemo.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.ducku.RESTAPIdemo.dto.request.UserRequestDTO;
import vn.ducku.RESTAPIdemo.dto.request.response.ResponseData;
import vn.ducku.RESTAPIdemo.dto.request.response.ResponseError;
import vn.ducku.RESTAPIdemo.util.UserStatus;

import java.util.List;

@RestController
@RequestMapping("/users")
//enable validation for both request parameters and path variables in our controllers by adding the @Validated annotation
@Validated
public class UserController {

    @PostMapping("/")
    public ResponseData<Integer> addUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        try {
            return new ResponseData<>(HttpStatus.CREATED.value(), "User added successfully");
        } catch (Exception e) {
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Can not create user");
        }
    }

    @PutMapping("{userId}")
    public ResponseData<?> updateUser(@PathVariable @Min(1) int userId, @Valid @RequestBody UserRequestDTO userRequestDTO) {
        try {
            return new ResponseData<>(HttpStatus.ACCEPTED.value(), "User updated successfully");
        } catch (Exception e) {
            return new ResponseError(HttpStatus.BAD_REQUEST.value(), "Can not update user");
        }

    }

    @PatchMapping("{userId}")
    public ResponseData<?> changeUserStatus(@PathVariable @Min(1) int userId, @Valid @RequestParam boolean status) {
        return new ResponseData<>(HttpStatus.ACCEPTED.value(), "User updated successfully");

    }


    @DeleteMapping("/{userId}")
    public ResponseData<?> deleteUser(@PathVariable("userId") @Min(1) int userId) {
        return new ResponseData<>(HttpStatus.NO_CONTENT.value(), "User deleted");
    }

    @GetMapping("{userId}")
    public ResponseData<UserRequestDTO> getUser(@PathVariable int userId) {
        return new ResponseData<>(HttpStatus.OK.value(), "user", new UserRequestDTO("ku mufahasa", "Ku", "Mufahasa", null, null, 14, UserStatus.ACTIVE));
    }

    @GetMapping("/")
    public ResponseData<List<UserRequestDTO>> getAllUsers() {
        return new ResponseData<>(HttpStatus.OK.value(), "users", List.of(new UserRequestDTO("ku mufahasa", "Ku", "Mufahasa", null, null, 14, UserStatus.ACTIVE),
                new UserRequestDTO("ku hehehe", "Ku", "hehehe", null, null, 16, UserStatus.ACTIVE)));
    }

}
