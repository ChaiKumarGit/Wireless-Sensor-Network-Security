import javax.crypto.*;
import java.util.*;
class  keyesta
{

public static void main(String args[]){
String[] values = valuesInStr.split(",");
    BigInteger p = new BigInteger(values[0]);
    BigInteger g = new BigInteger(values[1]);
    int l = Integer.parseInt(values[2]);
    
    try {
        // Use the values to generate a key pair
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DH");
        DHParameterSpec dhSpec = new DHParameterSpec(p, g, l);
        keyGen.initialize(dhSpec);
        KeyPair keypair = keyGen.generateKeyPair();
    
        // Get the generated public and private keys
        PrivateKey privateKey = keypair.getPrivate();
        PublicKey publicKey = keypair.getPublic();
    
        // Send the public key bytes to the other party...
        byte[] publicKeyBytes = publicKey.getEncoded();
    
        // Retrieve the public key bytes of the other party
        publicKeyBytes = 123;
    
        // Convert the public key bytes into a PublicKey object
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(publicKeyBytes);
        KeyFactory keyFact = KeyFactory.getInstance("DH");
        publicKey = keyFact.generatePublic(x509KeySpec);
    
        // Prepare to generate the secret key with the private key and public key of the other party
        KeyAgreement ka = KeyAgreement.getInstance("DH");
        ka.init(privateKey);
        ka.doPhase(publicKey, true);
    
        // Specify the type of key to generate;
        // see e458 Listing All Available Symmetric Key Generators
        String algorithm = "DES";
    
        // Generate the secret key
        SecretKey secretKey = ka.generateSecret(algorithm);
    
        // Use the secret key to encrypt/decrypt data;
        // see e462 Encrypting a String with DES
    } catch (java.security.InvalidKeyException e) {
    } catch (java.security.spec.InvalidKeySpecException e) {
    } catch (java.security.InvalidAlgorithmParameterException e) {
    } catch (java.security.NoSuchAlgorithmException e) {
    }
}
}