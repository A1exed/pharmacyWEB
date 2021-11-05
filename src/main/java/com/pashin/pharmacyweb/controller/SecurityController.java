package com.pashin.pharmacyweb.controller;

import com.pashin.pharmacyweb.dto.MessageDTO;
import com.pashin.pharmacyweb.dto.UserDTO;
import com.pashin.pharmacyweb.exception.DuplicateUserException;
import com.pashin.pharmacyweb.exception.InvalidUserException;
import com.pashin.pharmacyweb.model.UserModel;
import com.pashin.pharmacyweb.service.UserService;
import com.pashin.pharmacyweb.utils.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SecurityController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProvider jwtProvider;

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public void registerUser(@RequestBody UserDTO userDTO) throws DuplicateUserException {
        if (userService.findByUsername(userDTO.getUsername()) == null) {
            userService.saveUser(new UserModel(userDTO.getUsername(), userDTO.getPassword(), userService.findByRoleName("ROLE_USER")));
        } else {
            throw new DuplicateUserException("Имя пользователя уже занято");
        }
    }

    @PostMapping("/auth")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public UserDTO auth(@RequestBody UserDTO userDTO) throws InvalidUserException {
        try {
            UserModel userModel = userService.findByUsernameAndPassword(userDTO.getUsername(), userDTO.getPassword());
            if (userModel == null) throw new Exception();
            userDTO.setRole(userModel.getRoleID().getRoleName());
            userDTO.setToken(jwtProvider.generateToken(userModel.getUsername()));
            return userDTO;
        } catch (Exception e) {
            throw new InvalidUserException("Некорректное имя ползователя или пароль");
        }
    }

    @ExceptionHandler(DuplicateUserException.class)
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    @ResponseBody
    public MessageDTO handleException(DuplicateUserException e) {
        return new MessageDTO(e.getMessage());
    }

    @ExceptionHandler(InvalidUserException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public MessageDTO handleException(InvalidUserException e) {
        return new MessageDTO(e.getMessage());
    }

    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public void login() {

    }
}
