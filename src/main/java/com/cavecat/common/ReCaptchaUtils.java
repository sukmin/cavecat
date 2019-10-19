package com.cavecat.common;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * 구글에서 제공하는 ReCaptcha 사용을 위한 클래스입니다. <br>
 * https://developers.google.com/recaptcha
 * 
 * @author serivires
 *
 */
@Component
@PropertySource(value = {"classpath:properties/recaptcha.properties"})
public final class ReCaptchaUtils {
  private static String siteKey;
  private static String secretKey;
  private static String verifyingUri;

  private static RestTemplate restTemplate;

  private ReCaptchaUtils() {}

  @Value("${recaptcha.siteKey}")
  private void setSiteKey(String siteKey) {
    ReCaptchaUtils.siteKey = siteKey;
  }

  @Value("${recaptcha.secretKey}")
  private void setSecretKey(String secretKey) {
    ReCaptchaUtils.secretKey = secretKey;
  }

  @Value("${recaptcha.verifyingUri}")
  private void setVerifyingUri(String verifyingUri) {
    ReCaptchaUtils.verifyingUri = verifyingUri;
  }

  @Autowired(required = true)
  public void setRestTemplate(RestTemplate restTemplate) {
    ReCaptchaUtils.restTemplate = restTemplate;
  }

  public static String getSiteKey() {
    return siteKey;
  }

  /**
   * 사용자가 응답한 캡챠 값을 검증합니다.
   * 
   * @param captchaResponse
   * @return boolean
   */
  public static boolean isPassed(String captchaResponse) {
    if (StringUtils.isBlank(captchaResponse)) {
      return false;
    }

    MultiValueMap<String, Object> RequestParameter = buildRequestParameter(captchaResponse);
    ResponseEntity<String> responseEntity =
        restTemplate.postForEntity(ReCaptchaUtils.verifyingUri, RequestParameter, String.class);

    return isValidResponse(responseEntity);
  }


  /**
   * 캡챠 검증 응답을 확인합니다.
   * 
   * // { "success": true|false, "error-codes": [...] // optional }
   * 
   * @param responseEntity
   * @return boolean
   */
  private static boolean isValidResponse(ResponseEntity<String> responseEntity) {
    String responseBody = responseEntity.getBody();
    long resultCount = Arrays.asList(StringUtils.split(responseBody, ",")).stream()
        .filter((s) -> StringUtils.contains(s, "success"))
        .filter((s) -> StringUtils.contains(s, "true")).count();
    return (resultCount == 1);
  }

  /**
   * 캡챠 검증을 위한 요청값을 생성합니다.
   * 
   * @param captchaResponse
   * @return MultiValueMap<String, Object>
   */
  private static MultiValueMap<String, Object> buildRequestParameter(String captchaResponse) {
    MultiValueMap<String, Object> multiValueMap = new LinkedMultiValueMap<>();
    multiValueMap.add("secret", secretKey);
    multiValueMap.add("response", captchaResponse);
    return multiValueMap;
  }
}
