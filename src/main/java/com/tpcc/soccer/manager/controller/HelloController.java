package com.tpcc.soccer.manager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author John
 */
@RestController
public class HelloController {

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public String helloWorld() throws InterruptedException {


        return "TPCC Team Manager";
    }
}
