package com.shsxt.crm.utils;

import com.mysql.jdbc.StringUtils;

import java.util.Base64;

/**
 * @author 殇丶无求
 */
public class UserIDBase64 {

    /**
     * 解密
     * @param encodeUserID
     * @return
     */
    public static Integer decodeUserID(String encodeUserID){

        if(StringUtils.isNullOrEmpty(encodeUserID)){
            return null;
        }
        try {
            String reversedString =new StringBuffer(encodeUserID).reverse().toString();
            String base64String=reversedString.replaceAll("#","=");
            int userIDPos=base64String.indexOf("==")+6;
            String realBase64UserID=base64String.substring(userIDPos);
            String baseEncoded=new String(Base64.getDecoder().decode(realBase64UserID.getBytes()));
            return Integer.parseInt(baseEncoded);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 加密
     * @param userID 用户id
     * @return
     */
    public static String encoderUserID(Integer userID){

        String base64UserIDEncded=Base64.getEncoder().encodeToString(((userID)+"").getBytes());
        String currenStringBase64Encoded=Base64.getEncoder().encodeToString((System.currentTimeMillis()+"").getBytes());
        String keyString=currenStringBase64Encoded+currenStringBase64Encoded.substring(4,8)+base64UserIDEncded;
        byte[] codeBytes=keyString.getBytes();
        byte[] orderBytes=new byte[codeBytes.length];
        for(int i=0;i<codeBytes.length;i++){
            orderBytes[i]=codeBytes[codeBytes.length-i-1];
        }
        return new String(orderBytes).replaceAll("=","#");
    }

    public static void main(String[] args) {
        /**
         * 测试加密流程
         */
        System.out.println("加密完成:"+encoderUserID(11));

        System.out.println("=================");
        System.out.println("解密完成"+decodeUserID("#ETMwkTO##ANzgTM0QTNwkTOyUTM"));
    }


}
