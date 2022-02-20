package com.bobbingboy.springbootdemo.form;

import com.bobbingboy.springbootdemo.domain.User;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.BeanUtils;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class UserForm {

    public static final String phoneReg = "^09\\d{2}(\\d{6}|-\\d{3}-\\d{3})$";

    @NotBlank
    private  String username;

    @Length(min = 6, message = "The count of password number should be more than 6.")
    private  String password;
    @Pattern(regexp = phoneReg, message = "Please Enter Correct Phone Number.")
    private String phone;
    @Email
    private String email;
    @NotBlank
    private  String confirmPassword;

    public UserForm() {

    }



    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public boolean confirmPassword() {
        if (this.password.equals(this.confirmPassword)) {
            return true;
        }
        return false;
    }

    public User convertToUser() {
        User user = new UserFormConvert().convert(this);
        return user;
    }


    public class UserFormConvert implements FormConvert<UserForm, User>{
        @Override
        public User convert(UserForm userForm) {
            User user = new User();
            BeanUtils.copyProperties(userForm, user);
            // this is used to copy from userForm object to user object.
            return user;
        }
    }
}