package vn.ducku.RESTAPIdemo.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;
import vn.ducku.RESTAPIdemo.util.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import static vn.ducku.RESTAPIdemo.util.Gender.MALE;
import static vn.ducku.RESTAPIdemo.util.Gender.OTHER;

public class UserRequestDTO implements Serializable {

    @NotBlank(message = "username must not be blank")
    private String username;

    @NotBlank(message = "firstName must not be blank")
    private String firstName;
    private String lastName;

    @Pattern(regexp = "^(0[3-9][0-9]{8})|(02[0-9][0-9]{7})$", message = "Phone invalid format")
    @PhoneNumber
    private String phone;

    @Email(message = "Email invalid format")
    private String email;

    @NotNull
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date dateOfBirth;

    @Min(value = 13, message = "Only user over 13 can enter")
    private int age;


    private List<String> permissions;

    @EnumPattern(name = "status", regexp = "ACTIVE|INACTIVE|NONE")
    private UserStatus status;

    //we can change the subset value is a big advantage of this approach
    @GenderSubset(anyOf = {MALE, Gender.FEMALE, OTHER})
    private Gender gender;

    public UserRequestDTO() {
    }

    public UserRequestDTO(String username, String firstName, String lastName, String phone, String email, int age, UserStatus userStatus) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.permissions = permissions;
        this.age = age;
        this.status = userStatus;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
}
