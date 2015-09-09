package com.itboye.utils.security;

import java.security.KeyFactory;  
import java.security.PrivateKey;  
import java.security.PublicKey;  
import java.security.spec.PKCS8EncodedKeySpec;  
import java.security.spec.X509EncodedKeySpec;  

/** 
 * RSA
 */  
public class RSATool{  
      
    /** 
     * 
     */  
    public static final String SIGN_ALGORITHMS = "SHA1WithRSA";
  
    /** 
    * RSA
    * @param content  内容
    * @param privateKey 私钥
    * @param encode 编码
    * @return   
    */  
    public static String sign(String content, String privateKey, String encode)  
    {  
        try   
        {  
            PKCS8EncodedKeySpec priPKCS8    = new PKCS8EncodedKeySpec(Base64Utils.decode(privateKey) );   
            
            KeyFactory keyf                 = KeyFactory.getInstance("RSA");  
            PrivateKey priKey               = keyf.generatePrivate(priPKCS8);  
  
            java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);  
  
            signature.initSign(priKey);  
            signature.update( content.getBytes(encode));  
  
            byte[] signed = signature.sign();  
              
            return Base64Utils.encode(signed);  
        }  
        catch (Exception e)   
        {  
            e.printStackTrace();  
        }  
          
        return null;  
    }  
      
    public static String sign(String content, String privateKey)  
    {  
        try   
        {  
            PKCS8EncodedKeySpec priPKCS8    = new PKCS8EncodedKeySpec( Base64Utils.decode(privateKey) );   
            KeyFactory keyf = KeyFactory.getInstance("RSA");  
            PrivateKey priKey = keyf.generatePrivate(priPKCS8);  
            java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);  
            signature.initSign(priKey);  
            signature.update( content.getBytes());  
            byte[] signed = signature.sign();  
            return Base64Utils.encode(signed);  
        }  
        catch (Exception e)   
        {  
            e.printStackTrace();  
        }  
        return null;  
    }  
      
    /** 
    * RSA
    * @param content    原始内容
    * @param sign 		签名
    * @param publicKey  公钥
    * @param encode 	编码:utf-8
    * @return 			是否通过验证
    */  
    public static boolean doCheck(String content, String sign, String publicKey,String encode)  
    {  
        try   
        {
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");  
            byte[] encodedKey = Base64Utils.decode(publicKey);  
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));  
  
          
            java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);  
          
            signature.initVerify(pubKey);  
            signature.update( content.getBytes(encode) );  
          
            boolean bverify = signature.verify( Base64Utils.decode(sign) );  
            return bverify;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return false;  
    }
      
    public static boolean doCheck(String content, String sign, String publicKey)  
    {  
        try   
        {  
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");  
            byte[] encodedKey = Base64Utils.decode(publicKey);  
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(encodedKey));  

            java.security.Signature signature = java.security.Signature.getInstance(SIGN_ALGORITHMS);  
          
            signature.initVerify(pubKey);  
            signature.update(content.getBytes());  
          
            boolean bverify = signature.verify( Base64Utils.decode(sign) );  
            return bverify;  
              
        }   
        catch (Exception e)   
        {  
            e.printStackTrace();  
        }  
        
        return false;  
    }  
      
    public static void main(String[] args) throws Exception {      

    	//content
        String content = "v66YKULHFld2JElhm/J9qik2Edr1JHdZIc/k/OesU2GbTX2usXyvF4jGvzvoihrrE8FsfKmllmjsMIjO5fdrS/FD20bYFii4JW3BO3bzshXmz6AEs2DWwG4sK9mNojfOC0IsMoV311X5/JlgUoQXkDy4F5HHpYE9d/xGb0g2XE/hnGSSy2cpQcvQtBlBmixwSckNhsEG92lovlOz8ULwkqG5o7x+qB7P/EMII/WaFAXBJXDXvZX7lmGcOgon6wLhKJLGXorP6BIxOg6LGc6Ux7BAt3i9+0lujNgxIq/sDsl23hsr3yOUpV5C5a813nrHx4HJyd/hBT1UvIUml+eTmJwWCpSfs2cvxIUr0CE57JAZVyXjK13shK3IsZHLPPsm/JcDCrdy0Co/d5uIGJAdzXdsQ56xsju+tlvnA1J6yq2tDIfYK/x6k911A5WXLKYxztD1nq+bTYN3Gv/WFfrzVtgWQBrh06ihS2cwvna0S9EV/YPmhnAjJmrX4trNr9NXQ9xaZaW4lGRg87U5QDV+nQjj1THk0XHFc69N9g2+DsAGyEs9tK6U0ZQ72hJZqZhBCDH1UKw0PLyIhJdxpgPPOWGp8/QVVU2julTeKunvgAAEc3n+GoZfqjsCDi1S6T2MTnjWYWNoFRBhvEZFD/revgpasTOzDQa5NqR1B+mUF70r6uw6MWLJ7cT9Tz3jq+CA";
        
        //AES
        String key = "qZe60QZFxuirub2ey4+7+Q==";
        //AES
        String original_content = AESTool.decryptBase64EncodeString(content, key);
        
       
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCffOeIVYut9jW5w1L5uKX4aDvd837a8JhaWm5S8YqNQfgEmfD9T+rDknXLqMT+DXeQAqGo4hBmcbej1aoMzn6hIJHk3/TfTAToNN8fgwDotHewsTCBbVkQWtDTby3GouWToVsRi1i/A0Vfb0+xM8MnF46DdhhrnZrycERBSbyrcwIDAQAB";
        //
        String sign = "XHin4uUFqrKDEhKBD/hQisXLFFSxM6EZCvCPqnWCQJq3uEp3ayxmFuUgVE0Xoh4AIWjIIsOWdnaToL1bXvAFKwjCtXnkaRwUpvWrk+Q0eqwsoAdywsVQDEceG5stas1CkPtrznAIW2eBGXCWspOj+aumEAcPyYDxLhDN646Krzw=";
        //RSA
        boolean isOk =  RSATool.doCheck(original_content,sign,publicKey,"utf-8");
        
        System.out.println("验签结果：" + isOk);
    }
}  