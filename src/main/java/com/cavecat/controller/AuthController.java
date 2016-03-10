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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cavecat.bo.UserBO;
import com.cavecat.common.ReCaptchaUtils;
import com.cavecat.model.User;

/**
 * 
 * @author serivires
 *
 */
@Controller
public class AuthController {
  private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

  @Autowired
  private UserBO userBO;
  
  @RequestMapping(value = "/login", method = RequestMethod.GET)
  public ModelAndView login() {
    ModelAndView mav = new ModelAndView("/login");
    mav.addObject("reCaptchaSiteKey", ReCaptchaUtils.getSiteKey());
    return mav;
  }

  @RequestMapping(value = "/login", method = RequestMethod.POST)
  public ModelAndView login(@ModelAttribute @Valid User user, @RequestParam String captchaResponse,
      BindingResult bindingResult, HttpServletRequest request) {
    ModelAndView mav = new ModelAndView();

    if (isNotValidInputParameter(user, captchaResponse, bindingResult)) {
      mav.addObject(User.PARAM_LOGIN_FAILED, true);
      mav.addObject("reCaptchaSiteKey", ReCaptchaUtils.getSiteKey());
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

  /**
   * 사용자가 입력한 로그인 정보를 확인합니다.
   * 
   * @param user
   * @param captchaResponse
   * @param bindingResult
   * @return boolean
   */
  private boolean isNotValidInputParameter(User user, String captchaResponse,
      BindingResult bindingResult) {
    if (bindingResult.hasErrors()) {
      return true;
    }

    /**
     * TODO: 구글 리캡챠를 사용하기 위해서는 도메인이 필요함
     */
/*    if (ReCaptchaUtils.isPassed(captchaResponse) == false) {
      return true;
    }*/

    if (userBO.isNotMember(user)) {
      return true;
    }

    return false;
  }

  @RequestMapping(value = "/logout", method = RequestMethod.GET)
  public ModelAndView logout(HttpSession session) {
    session.invalidate();
    return new ModelAndView("redirect:/login");
  }
}
