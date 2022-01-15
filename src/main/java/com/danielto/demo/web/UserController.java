package com.danielto.demo.web;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

  @RequestMapping("/{userId}")
  public String displayUser(@PathVariable int userId) {
    return "User Found: " + userId;
  }

  @RequestMapping("/{id}/invoices")
  public String displayUserInvoices(
    @PathVariable("id") int userId,
    @RequestParam(value="date", required=false) Date dateOrNull
    ) { // localhost:8080/user/32/invoices?date=01/14/2022
    return "Invoice found for user: " + userId + " on the date: " + dateOrNull;
  }

  @RequestMapping("/{userId}/items")
  public List<String> displayStringJson() {
    return Arrays.asList("Shoes", "laptop", "button");
  }
}
