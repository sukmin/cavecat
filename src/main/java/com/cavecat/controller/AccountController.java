package com.cavecat.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cavecat.bo.UserBO;
import com.cavecat.model.User;

@Controller
public class AccountController {
  private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

  @Autowired
  private UserBO userBO;

  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public ModelAndView login() {
    return new ModelAndView("/login");
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public ModelAndView login(@ModelAttribute @Valid User user, BindingResult bindingResult,
      HttpServletRequest request) {

    ModelAndView mav = new ModelAndView();
    if (bindingResult.hasErrors() || userBO.isNotMember(user)) {
      mav.addObject(User.PARAM_LOGIN_FAILED, true);
      mav.setViewName("/login");
      return mav;
    }

    HttpSession session = request.getSession();
    session.setAttribute(User.PARAM_ID, user.getId());
    request.changeSessionId();

    logger.debug("login by {}", user.getId());
    mav.setViewName("redirect:/list");
    return mav;
  }

  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public ModelAndView logout(HttpSession session) {
    session.invalidate();
    return new ModelAndView("redirect:/login");
  }
}
