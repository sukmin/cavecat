package com.cavecat.common;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration({"classpath:spring/root-context.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class EncryptionUtilsTest {
  private String korStr = "한국어문자열";
  private String engStr = "ABCabc";

  @Test
  public void 문자열_암호화_및_복호화_테스트() throws Exception {
    // given

    // when
    String encKorStr = EncryptionUtils.encode(korStr);
    String encEngStr = EncryptionUtils.encode(engStr);

    System.out.println("encKorStr: " + encKorStr);
    System.out.println("encEngStr: " + encEngStr);

    String rawKorStr = EncryptionUtils.decode(encKorStr);
    String rawEngStr = EncryptionUtils.decode(encEngStr);

    // then
    assertThat(korStr, is(rawKorStr));
    assertThat(engStr, is(rawEngStr));
  }
}
