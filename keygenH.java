import javax.crypto.*;
import java.util.*;
class keygenH 
{
	public static void main(String[] args) 
	{
		try {
              KeyGenerator keyGen = KeyGenerator.getInstance("HmacMD5");
        SecretKey key = keyGen.generateKey();
      
          keyGen = KeyGenerator.getInstance("HmacSHA1");
        key = keyGen.generateKey();
	    System.out.println("Hello World!"+key);
    } catch (java.security.NoSuchAlgorithmException e) {
    }
	
	}
}
