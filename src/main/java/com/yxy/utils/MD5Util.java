package com.yxy.utils;

import java.security.MessageDigest;

/**
 * md5.
 */
public class MD5Util {
  /**
   * md5??.
   * @param pw ????
   * @return  ??
   */
  public static String stringMD5(String pw) {
    try {
      MessageDigest messageDigest = MessageDigest.getInstance("MD5");
      byte[] inputByteArray = pw.getBytes();
      messageDigest.update(inputByteArray);
      byte[] resultByteArray = messageDigest.digest();
      return byteArrayToHex(resultByteArray);
    } catch (Exception ex) {
      return null;
    }
  }

  /**
   *????.
   * @param byteArray ???byte??
   * @return ??
   */
  public static String byteArrayToHex(byte[] byteArray) {
    char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9', 'A','B','C','D','E','F' };
    char[] resultCharArray = new char[byteArray.length * 2];
    int index = 0;
    for (byte b : byteArray) {
      resultCharArray[index++] = hexDigits[b >>> 4 & 0xf];
      resultCharArray[index++] = hexDigits[b & 0xf];
    }
    return new String(resultCharArray);
  }

}
