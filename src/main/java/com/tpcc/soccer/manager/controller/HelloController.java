package com.tpcc.soccer.manager.controller;

import org.springframework.web.bind.annotation.*;

/**
 * @author John
 */
@RestController
public class HelloController {

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public String helloWorld() throws InterruptedException {

        return "TPCC Soccer Manager Test API";
    }
}
