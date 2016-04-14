package com.test.cc;

public class MD5Test {  
	  
    /** 
     * @param args 
     */  
    public static void main(String[] args) { 
    	String string = "{conte:{name:'wxy',age:12}}";
        System.out.println(decrypt("150%126%138%137%143%128%85%150%137%124%136%128%85%66%146%147%148%66%71%124%130%128%85%76%77%152%152%"));  
          
        System.out.println(encrypt(string));  
    }  
      
    /** 
       *用户名解密 
       *@param ssoToken 字符串 
       *@return String 返回加密字符串 
      */  
      public static String decrypt(String ssoToken)  
      {  
        try  
        {  
          String name = new String();  
          java.util.StringTokenizer st=new java.util.StringTokenizer(ssoToken,"%");  
          while (st.hasMoreElements()) {  
            int asc =  Integer.parseInt((String)st.nextElement()) - 27;  
            name = name + (char)asc;  
          }  
  
          return name;  
        }catch(Exception e)  
        {  
          e.printStackTrace() ;  
          return null;  
        }  
      }  
  
      /** 
       *用户名加密 
       *@param ssoToken 字符串 
       *@return String 返回加密字符串 
      */  
      public static String encrypt(String ssoToken)  
      {  
        try  
        {  
          byte[] _ssoToken = ssoToken.getBytes("ISO-8859-1");  
          String name = new String();  
         // char[] _ssoToken = ssoToken.toCharArray();  
          for (int i = 0; i < _ssoToken.length; i++) {  
              int asc = _ssoToken[i];  
              _ssoToken[i] = (byte) (asc + 27);  
              name = name + (asc + 27) + "%";  
          }  
          return name;  
        }catch(Exception e)  
        {  
          e.printStackTrace() ;  
          return null;  
        }  
      }
}  