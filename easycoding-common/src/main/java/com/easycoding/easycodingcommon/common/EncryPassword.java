package com.easycoding.easycodingcommon.common;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.UUID;


/**
 * PBKDF加密算法工具类
 * */
public class EncryPassword {


    public  static final String PBKDF2_ALGORITHM = "PBKDF2WithHmacSHA1";

    /**
     * 盐的长度
     */
    public static final int SALT_BYTE_SIZE = 32 / 2;

    /**
     * 生成密文的长度
     */
    public static final int HASH_BIT_SIZE = 64 * 8 ;

    /**
     * 迭代次数
     */
    public static final int PBKDF2_ITERATIONS = 10000;

    public static void main(String[] args) {

//        String password = "123456";
//        String salt;
//        try {
//
//            salt = "nSxwLxrM/evMH/iSxt0iCQ==";
//            getEncryptedPassword(password, salt);
//
//        } catch (NoSuchAlgorithmException e) {
//            System.out.println("NoSuchAlgorithmException");
//        } catch (InvalidKeySpecException e) {
//            System.out.println("InvalidKeySpecException");
//        }


        String str  = UUID.randomUUID().toString().replace("-","").substring(0,16);
        String msg  = Base64.getEncoder().encodeToString(str.getBytes());
        System.out.println("加密："+msg);

        pbkdf2("dshtgl@videopls.com","PvuoeN0AVi7ANa+dAK+OSg==");
    }
    public static void  pbkdf2(String password,String salt){

        try {
//            salt = "nSxwLxrM/evMH/iSxt0iCQ==";
            getEncryptedPassword(password,salt);

        } catch (Exception ex){

        }
    }


    public static String base64encode(byte[] src) {
        if (src == null)
            return null;
        return (new sun.misc.BASE64Encoder()).encode(src);
    }
    public static   byte[] base64decode(String s) {
        if (s == null)
            return null;
        sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
        try {
            byte[] b = decoder.decodeBuffer(s);
            return b;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 生成密文
     *
     * @param password
     *            明文密码
    //     * @param salt
     *            盐值
     * @return
     */
    public static String getEncryptedPassword(String password,String saltValue)  {

        String salt = saltValue;

        KeySpec spec = new PBEKeySpec(password.toCharArray(), base64decode(salt), PBKDF2_ITERATIONS, HASH_BIT_SIZE);
        try{

            SecretKeyFactory f = SecretKeyFactory.getInstance(PBKDF2_ALGORITHM);

            return base64encode(f.generateSecret(spec).getEncoded());

        }catch (NoSuchAlgorithmException e) {

            System.out.println("NoSuchAlgorithmException");

        }catch (InvalidKeySpecException ie){

            System.out.println("InvalidKeySpecException");
        }
        return "";
    }

}


