/**
 * 
 */
package com.eric.common.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.security.Key;
import java.security.spec.AlgorithmParameterSpec;

public class DESUtil {

    private AlgorithmParameterSpec iv = null; // 加密算法的参数接口，IvParameterSpec是它的一个实现

    private Key key = null;

    private static DESUtil des;

    public static DESUtil getInstance(String secrutyKey) throws Exception {
	if (null == des) {
	    return new DESUtil(secrutyKey);
	}
	return des;
    }

    public DESUtil(String securityKey) throws Exception {
	byte[] DESkey = securityKey.getBytes("UTF-8");
	DESKeySpec keySpec = new DESKeySpec(DESkey);// 设置密钥参数
	iv = new IvParameterSpec(DESkey);// 设置向量
	SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");// 获得密钥工厂
	key = keyFactory.generateSecret(keySpec);// 得到密钥对象
    }

    public String encode(String data) throws Exception {
	Cipher enCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");// 得到加密对象Cipher
	enCipher.init(Cipher.ENCRYPT_MODE, key, iv);// 设置工作模式为加密模式，给出密钥和向量
	byte[] pasByte = enCipher.doFinal(data.getBytes("utf-8"));
	BASE64Encoder base64Encoder = new BASE64Encoder();
	return base64Encoder.encode(pasByte);
    }

    public String decode(String data) throws Exception {
	Cipher deCipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
	deCipher.init(Cipher.DECRYPT_MODE, key, iv);
	BASE64Decoder base64Decoder = new BASE64Decoder();

	byte[] pasByte = deCipher.doFinal(base64Decoder.decodeBuffer(data));

	return new String(pasByte, "UTF-8");
    }

}
