package com.bobbingboy.springbootdemo.web;

import com.bobbingboy.springbootdemo.domain.User;
import com.bobbingboy.springbootdemo.form.UserForm;
import com.bobbingboy.springbootdemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String toRegister(Model model) {
        model.addAttribute("userForm", new UserForm());
        return "register";
    }

    @GetMapping("/login")
    public String toLogin() {
        return "login";
    }

    @PostMapping("/register")
    public String register(@Valid UserForm userForm, BindingResult result) {

        if(!userForm.confirmPassword()) {
            result.rejectValue("confirmPassword", "confirmError", "the two password are not consistent.");
        }
        if(result.hasErrors()) {
            return "register";
        }
//        boolean boo = false;
//        if(result.hasErrors()) {
//            List<FieldError> fieldErrorList = result.getFieldErrors();
//            for(FieldError error : fieldErrorList) {
//                System.out.println(error.getField() + " : " + error.getDefaultMessage() + " : " + error.getCode());
//                boo = false;
//            }
//        }
//        if(!boo) {
//            return "register";
//        }

        User user = userForm.convertToUser();
        userService.save(user);
        return "redirect:/login";

    }

    @GetMapping("/exception")
    public String testException() {
        throw new RuntimeException("test error Handle");
    }


}
