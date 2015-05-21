package com.cavecat.common;


import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * AES 방식을 사용하여 암호화, 복호화 기능을 제공하는 클래스입니다.
 * http://ko.wikipedia.org/wiki/%EA%B3%A0%EA%B8%89_%EC%95%94%ED%98%B8%ED%99%94_%ED%91%9C%EC%A4%80
 * 
 * secretKey, IvParameter는 properties 파일로 주입받습니다.
 * 
 * @author serivires
 * 
 */
public class EncryptionUtils {
  private final static Logger logger = LoggerFactory.getLogger(EncryptionUtils.class);

  private static String secretKey;
  private static String IvParameter;

  private final static String TRANSFORMATION_MODE = "AES/CBC/PKCS5Padding";
  private final static String CIPHER_ALGORITHM = "AES";
  private final static String CHARSET_NAME = "UTF-8";

  public void setSecretKey(String secretKey) {
    EncryptionUtils.secretKey = secretKey;
  }

  public void setIvParameter(String ivParameter) {
    IvParameter = ivParameter;
  }

  /**
   * rawData를 암호화 하여 반환합니다.
   * 
   * 에러처리를 담당합니다.
   * 
   * @param rawData
   * @return String
   * @throws Exception
   */
  public static String encode(String rawData) {
    String encData = "";
    try {
      encData = encodeByAES(rawData);
    } catch (Exception e) {
      logger.debug("EncryptionUtils.encode: {}", e.toString());
    }

    return encData;
  }

  /**
   * rawData를 암호화 하여 반환합니다.
   * 
   * @param rawData
   * @return
   * @throws Exception
   */
  private static String encodeByAES(String rawData) throws Exception {
    Cipher cipher = getCipher(Cipher.ENCRYPT_MODE);
    byte[] encDataBytes = cipher.doFinal(rawData.getBytes(CHARSET_NAME));
    String encData = new String(Base64.encodeBase64(encDataBytes), CHARSET_NAME);

    return encData;
  }

  /**
   * encData를 복호화 하여 반환합니다.
   * 
   * 에러처리를 담당합니다.
   * 
   * @param encData
   * @return String
   * @throws Exception
   */
  public static String decode(String encData) {
    String rawData = "";
    try {
      rawData = decodeByAES(encData);
    } catch (Exception e) {
      logger.debug("EncryptionUtils.decode: {}", e.toString());
    }

    return rawData;
  }

  /**
   * encData를 복호화 하여 반환합니다.
   * 
   * @param encData
   * @return
   * @throws Exception
   */
  private static String decodeByAES(String encData) throws Exception {
    Cipher cipher = getCipher(Cipher.DECRYPT_MODE);
    byte[] encDataBytes = Base64.decodeBase64(encData.getBytes());
    String rawData = new String(cipher.doFinal(encDataBytes), CHARSET_NAME);

    return rawData;
  }

  /**
   * Cipher 객체를 생성하여 반환합니다.
   * 
   * @param opmode
   * @return Cipher
   * @throws Exception
   */
  private static Cipher getCipher(int opmode) throws Exception {
    SecretKey secureKey = getSecureKey();
    Cipher cipher = Cipher.getInstance(TRANSFORMATION_MODE);
    cipher.init(opmode, secureKey, new IvParameterSpec(IvParameter.getBytes()));

    return cipher;
  }

  /**
   * SecretKey 객체를 생성하여 반환합니다.
   * 
   * @return SecretKey
   */
  private static SecretKey getSecureKey() {
    byte[] keyData = secretKey.getBytes();
    SecretKey secureKey = new SecretKeySpec(keyData, CIPHER_ALGORITHM);
    return secureKey;
  }
}
