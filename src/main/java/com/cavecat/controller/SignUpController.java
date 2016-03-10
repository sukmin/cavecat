package com.cavecat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cavecat.model.User;
/**
 * 
 * @author killroad
 */
@Controller
public class SignUpController {

  @RequestMapping(value = "/signup", method = RequestMethod.GET)
  public String form() {

    return "/signup/form";
  }

  @RequestMapping(value = "/signup", method = RequestMethod.PUT)
  public String save(User user, Model model) {

    return "/signup/form";
  }

}
