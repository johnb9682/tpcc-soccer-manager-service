package com.tpcc.soccer.manager.controller;

import com.tpcc.soccer.manager.dto.User;
import com.tpcc.soccer.manager.model.UserRequest;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author John
 */
@RestController
public class HelloController {

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public String helloWorld() throws InterruptedException {

        return "TPCC Soccer Manager";
    }
}
