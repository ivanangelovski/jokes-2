package com.intec.jokes;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/")
@Slf4j
public class MainController {

     @Autowired
     Environment env;

     @GetMapping("/")
     @ResponseBody
     public String index(HttpServletRequest request) {
          log.info("in home control     local: " + request.getLocalAddr());
          log.info("in home control    remote: " + request.getRemoteAddr());
          return "hello with [" + env.getProperty("secretino") + "]";
     }

     @GetMapping("/message")
     @ResponseBody
     public String message(HttpServletRequest request) {

          log.info("in message control     local: " + request.getLocalAddr());
          log.info("in message control    remote: " + request.getRemoteAddr());

          RestTemplate restTemplate = new RestTemplate();

          String result = restTemplate.getForEntity(env.getProperty("alt.service.url"), String.class).getBody();

          return result;
     }
}
