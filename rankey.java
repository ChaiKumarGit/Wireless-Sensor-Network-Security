import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;

class  rankey
{
	public static void main(String[] args) 
	{
		try {
        
        KeyGenerator keyGen = KeyGenerator.getInstance("DES");
        SecretKey key = keyGen.generateKey();
        System.out.println("deskey:"+key+"keygen:"+keyGen);
        
        keyGen = KeyGenerator.getInstance("Blowfish");
        key = keyGen.generateKey();
        System.out.println("blowkey:"+key+"keygen:"+keyGen);
      
        keyGen = KeyGenerator.getInstance("DESede");
        key = keyGen.generateKey();
		System.out.println("deskey:"+key+"keygen:"+keyGen);
    } catch (java.security.NoSuchAlgorithmException e) {
    }
    try {
        
        KeyGenerator keyGen = KeyGenerator.getInstance("DESede");
        SecretKey key = keyGen.generateKey();
         
        
        byte[] keyBytes = key.getEncoded();
        int numBytes = keyBytes.length;
        
    
        SecretKey key2 = new SecretKeySpec(keyBytes, "DESede");
        boolean b = key.equals(key2);  // true
    } catch (NoSuchAlgorithmException e) {
    }

	}
}
