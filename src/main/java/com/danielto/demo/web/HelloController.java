package com.danielto.demo.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting") // (value = "/greeting", method = RequestMethod.GET)
public class HelloController {

  @RequestMapping("/basic") // localhost:8080/greeting/basic
  public String sayHello() {
    return "<h1>hello</h1>";
  }

  @RequestMapping("/proper") // localhost:8080/greeting/proper
  public String sayProperHello() {
    return "<h1>Hello there, how are you?</h1>";
  }

  @RequestMapping("/user_entry")
  public String userForm() {
    return "<form action=\"/greeting/user_greeting\" method=\"GET\">" +
    " <label for=\"fname\">First name:</label><br>" +
    " <input type=\"text\" id=\"fname\" name=\"fname\"><br>" +
    " <label for=\"lname\">Last name:</label><br>" +
    " <input type=\"text\" id=\"lname\" name=\"lname\"><br><br>" +
    " <input type=\"submit\" value=\"Submit\">" +
    "</form>";
  }

  @RequestMapping(value = "/user_greeting", method = RequestMethod.GET)
  public String printUserGreeting(@RequestParam String fname, @RequestParam String lname) {
    return "Hello there, " + fname + " " + lname;
  }

  @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
  public String getOrder(@PathVariable int id) {
    return "Order ID: " + id;
  }
}
