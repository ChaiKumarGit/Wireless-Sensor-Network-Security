import java.util.Arrays; 
import java.util.Vector; 
import java.util.*; 

public class ElGamal { 


public ElGamal() { 
super(); 

} 

public static void main(String[] args) { 
Vector primeVector = new Vector(); 
Generator generator = new Generator(); 
int primeNumber = 0; 
while (primeVector.isEmpty()) { 
primeNumber = generator.createPrimeNumber(1000, 10000); 
System.out.println("--------Prime Number--------"); 
System.out.println("Prime Number : " + primeNumber); 
//Vector pnVector = generator.createPrimeNumberVector(1000, 2357); 
primeVector = generator.createGenerator(primeNumber); 
} 
generator.initializeGenerator(Integer.parseInt(primeVector.elementAt(0) 
.toString()), primeNumber); 

System.out.println("--------Generator--------"); 
System.out.println("Generator : " + generator.getGenerator()); 
System.out.println("Prime Number : " + generator.getPrimeNumber()); 

// Create Encryption and Decryption keys 
Keys keys = new Keys(); 
keys.initializeKeys(generator.getGenerator(), generator 
.getPrimeNumber()); 
EncryptionKey encryptionKey = keys.getEncryptionKey(); 
DecryptionKey decryptionKey = keys.getDecryptionKey(); 

System.out.println("--------EncryptionKey--------"); 
System.out.println("Public Key : " + encryptionKey.getPublicKey()); 
System.out.println("Generator :" + encryptionKey.getGenerator()); 
System.out.println("Prime Number : " + encryptionKey.getPrimeNumber()); 

System.out.println("--------DecryptionKey--------"); 
System.out.println("Private Key : " + decryptionKey.getPrivateKey()); 
System.out.println("Prime Number : " + decryptionKey.getPrimeNumber()); 

// Initialize Encryption 
String encryptionMessage = "suranga kulathunga"; 
Encryption encryption = new Encryption(); 
encryption.initializeEncryption(encryptionKey, encryptionMessage); 
encryption.encrypt(encryptionMessage); 
System.out.println("--------Encryption--------"); 
System.out.println("Encryption Message :" + encryptionMessage); 
System.out.println("CipherTextOne : " + encryption.getCipherTextOne()); 
System.out.print("CipherTextTwo : "); 
for (int i = 0; i < encryption.getCipherTextTwoArray().length; i++) { 
System.out.print(encryption.getCipherTextTwoArray()[i] + " "); 
} 
System.out.println(""); 

// Initialize Decryption 
Decryption decryption = new Decryption(); 
decryption.initializeDecryption(decryptionKey); 
int[] mes = decryption.decrypt(encryption.getCipherTextOne(), 
encryption.getCipherTextTwoArray()); 
System.out.println("--------Decryption--------"); 
String message = ""; 
int ASCII = 0; 
System.out.print("Decryption Message :"); 
for (int i = 0; i < mes.length; i++) { 
message += "" + ((char) mes[i]); 
System.out.print(mes[i] + " "); 
} 
System.out.println(""); 

decryption.setMessage(message); 
System.out.println("Final Message : " + decryption.getMessage()); 

} 

} 









 



















