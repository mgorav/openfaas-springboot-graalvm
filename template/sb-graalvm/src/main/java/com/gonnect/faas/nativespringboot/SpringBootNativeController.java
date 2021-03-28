package com.gonnect.faas.nativespringboot;

import function.RequestHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SpringBootNativeController {

    @Autowired
    private RequestHandler handler;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity<String> handle(@RequestBody byte[] payload) {
        String response = handler.handle(payload);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
