import javax.crypto.*;
import java.io.*;

public class DesEncrypter {
        Cipher ecipher;
        Cipher dcipher;
    
        DesEncrypter(SecretKey key) {
             byte[] iv = new byte[]{
                (byte)0x8E, 0x12, 0x39, (byte)0x9C,
                0x07, 0x72, 0x6F, 0x5A
            };
            AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);
            try {
                ecipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
                dcipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
    
                
                ecipher.init(Cipher.ENCRYPT_MODE, key, paramSpec);
                dcipher.init(Cipher.DECRYPT_MODE, key, paramSpec);
            } catch (java.security.InvalidAlgorithmParameterException e) {
            } catch (javax.crypto.NoSuchPaddingException e) {
            } catch (java.security.NoSuchAlgorithmException e) {
            } catch (java.security.InvalidKeyException e) {
            }
        }
    
         byte[] buf = new byte[1024];
    
        public void encrypt(InputStream in, OutputStream out) {
            try {
                   out = new CipherOutputStream(out, ecipher);
      int numRead = 0;
                while ((numRead = in.read(buf)) >= 0) {
                    out.write(buf, 0, numRead);
                }
                out.close();
            } catch (java.io.IOException e) {
            }
        }
    
        public void decrypt(InputStream in, OutputStream out) {
            try {
                  in = new CipherInputStream(in, dcipher);
    
                  int numRead = 0;
                while ((numRead = in.read(buf)) >= 0) {
                    out.write(buf, 0, numRead);
                }
                out.close();
            } catch (java.io.IOException e) {
            }
        }
}
