package com.bobbingboy.springbootdemo.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogTestApiController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/log")
    public String log() {

        String name = "Bob";
        String email = "bob@gmail.com";

        logger.info("------------log-------------");

//        logger.info("info ----log");
//        logger.warn("warn ---log");
//        logger.error("error ---log");
//        logger.debug("debug ---log");
//        logger.trace("trace ---log");
//        logger.info("name: {}, email: {}", name, email);

        return "logtest";
    }
}
