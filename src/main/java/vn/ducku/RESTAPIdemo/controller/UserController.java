package vn.ducku.RESTAPIdemo.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import vn.ducku.RESTAPIdemo.dto.request.UserRequestDTO;
import vn.ducku.RESTAPIdemo.util.UserStatus;

@RestController
@RequestMapping("/users")
//enable validation for both request parameters and path variables in our controllers by adding the @Validated annotation
@Validated
public class UserController {

    @PostMapping("/")
    public String addUser(@Valid @RequestBody UserRequestDTO userRequestDTO) {
        return "User added";
    }

    @PutMapping("{userId}")
    public String updateUser(@PathVariable @Min(1) int userId, @Valid @RequestBody UserRequestDTO userRequestDTO) {
        return "User updated";
    }

    @PatchMapping("{userId}")
    public String changeUserStatus(@PathVariable @Min(1) int userId, @Valid @RequestParam boolean status) {
        return "User Status Changed";

    }


    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable("userId") @Min(1) int userId) {
        return "User deleted";
    }

    @GetMapping("{userId}")
    public UserRequestDTO getUser(@PathVariable int userId) {
        return new UserRequestDTO("ku mufahasa", "Ku", "Mufahasa", null, null, 14, UserStatus.ACTIVE);
    }
}
