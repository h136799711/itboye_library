/**
 * 
 */
package com.itboye.utils.security;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author hebidu
 * CIPHER_ALGORITHM_ECB = "AES/ECB/PKCS5Padding"
 */
public class AESTool {
	
	static Cipher cipher;  
	
	static final String KEY_ALGORITHM = "AES";  
	
	static final String CIPHER_ALGORITHM_ECB = "AES/ECB/PKCS5Padding";  
	
	/**
	 * 加密
	 * 
	 * @param content
	 *            需要加密的内容
	 * @param password
	 *            加密密码
	 * @return
	 */
	public static byte[] encrypt(String content, byte[] password) {
		try {
			
			cipher = Cipher.getInstance(CIPHER_ALGORITHM_ECB); 
			
			SecretKeySpec key = new SecretKeySpec(password, KEY_ALGORITHM);
			
			cipher.init(Cipher.ENCRYPT_MODE, key);
			byte[] encrypt = cipher.doFinal(content.getBytes("utf-8")); 
			return encrypt; // 加密
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String encryptWithBase64(String content, String aesKey) throws UnsupportedEncodingException{
		
		byte[] password = java.util.Base64.getDecoder().decode(aesKey);
		
		byte[] bytesDecryptContent = AESTool.encrypt(content, password);
		
		byte[] encode =  java.util.Base64.getEncoder().encode(bytesDecryptContent);
		
		return new String(encode);
	}
	
	/**
	 * 解码 通过base64加密的密文
	 * 
	 * @param encryptContent	密文 = base64(AES(明文,aeskey))
	 * @param aesKey			密钥
	 * @return 明文				
	 * @throws Exception 
	 */
	public static String decryptBase64EncodeString(String encryptContent,String aesKey) throws Exception{
		
		byte[] bytesContent = Base64Utils.decode(encryptContent);
		byte[] bytesAesKey = Base64Utils.decode(aesKey);
		
		byte[] bytesDecryptContent = AESTool.decrypt(bytesContent, bytesAesKey);
		
		String ret = new String(bytesDecryptContent,"utf-8");
		
		return ret;
	}

	/**
	 * 解密
	 * 
	 * @param content
	 *            待解密内容
	 * @param password
	 *            解密密钥
	 * @return
	 */
	public static byte[] decrypt(byte[] content, byte[] aesKey) {
		try {
			
			cipher = Cipher.getInstance(CIPHER_ALGORITHM_ECB);
			//KeyGenerator 生成aes算法密钥
			
			SecretKeySpec secretKey = new SecretKeySpec(aesKey, KEY_ALGORITHM);
			
			cipher.init(Cipher.DECRYPT_MODE, secretKey);//使用解密模式初始化 密钥
			
			byte[] decrypt = cipher.doFinal(content);
			
			return (decrypt);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 将二进制转换成16进制
	 * 
	 * @param buf
	 * @return
	 */
	public static String parseByte2HexStr(byte buf[]) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < buf.length; i++) {
			String hex = Integer.toHexString(buf[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			sb.append(hex.toUpperCase());
		}
		return sb.toString();
	}

	/**
	 * 将16进制转换为二进制
	 * 
	 * @param hexStr
	 * @return
	 */
	public static byte[] parseHexStr2Byte(String hexStr) {
		if (hexStr.length() < 1)
			return null;
		byte[] result = new byte[hexStr.length() / 2];
		for (int i = 0; i < hexStr.length() / 2; i++) {
			int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
			int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
			result[i] = (byte) (high * 16 + low);
		}
		return result;
	}


}
