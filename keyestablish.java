
import javax.swing.JOptionPane;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.security.MessageDigest;
import java.sql.*;
import javax.swing.JOptionPane;
public class keyestablish {

	

	BigInteger p = new BigInteger("fd7f53811d75122952df4a9c2eece4e7f611b7523cef4400c31e3f80b6512669455d402251fb593d8d58fabfc5f5ba30f6cb9b556cd7813b801d346ff26660b76b9950a5a49f9fe8047b1022c24fbba9d7feb7c61bf83b57e7c6a8a6150f04fb83f6d3c51ec3023554135a169132f675f3ae2b61d72aeff22203199dd14801c7", 16);
	BigInteger q = new BigInteger("9760508f15230bccb292b982a2eb840bf0581cf5", 16);
	BigInteger g = new BigInteger("f7e1a085d69b3ddecbbcab5c36b857b97994afbbfa3aea82f9574c0b3d0782675159578ebad4594fe67107108180b449167123e84c281613b7cf09328cc8a6e13c167a8b547c8d28e0a3ae1e2bb3a675916ea37f0bfa213562f1fb627a01243bcca4f1bea8519089a883dfe15ae59f06928b665e807b552564014c3bfecf492a", 16);
	
	
	
	
	String []keyvalues;
    String s1Str="";
	String s2Str="";
	String commonkeys="";
	
	String ServerID = "server";
	String NewNodeID = "newnode";
   
    public keyestablish(String secretkey) {
       
         keyvalues=secretkey.split("#");
	     s1Str = keyvalues[0];
	     s2Str = keyvalues[1];
    	 run();
    }
  

    public String run () {
	
    	System.out.println("Public parameters for the cyclic group:");
    	System.out.println("p ("+p.bitLength()+" bits): " + p.toString(16));
    	System.out.println("q ("+q.bitLength()+" bits): " + q.toString(16));
    	System.out.println("g ("+p.bitLength()+" bits): " + g.toString(16));
    	System.out.println("p mod q = " + p.mod(q).toString(16));
    	System.out.println("g^{q} mod p = " + g.modPow(q,p).toString(16));
    	System.out.println("");
    	
    	System.out.println("(Secret passwords used by Server and NewNode: "+
    			"\""+s1Str+"\" and \""+s2Str+"\")\n");
    	commonkeys = s1Str+"#"+s2Str+"#";
    	JOptionPane jp = new JOptionPane();
		
		BigInteger s1 = new BigInteger(s1Str.getBytes());
    	BigInteger s2 = new BigInteger(s2Str.getBytes());
        
    	/* Step 1: server sends g^{x1}, g^{x2}, and newnode sends g^{x3}, g^{x4} */

    	/* 
    	 * You should choose x1,x3 uniformly from [0,q-1] and x2,x4 from [1,q-1].
    	 */
    	BigInteger x1 = new BigInteger (160, new SecureRandom());
    	BigInteger x2 = new BigInteger (160, new SecureRandom());
    	BigInteger x3 = new BigInteger (160, new SecureRandom());
    	BigInteger x4 = new BigInteger (160, new SecureRandom());

    	BigInteger gx1 = g.modPow(x1,p);
    	BigInteger gx2 = g.modPow(x2,p);
    	BigInteger[] sigX1 = generateZKP(p,q,g,gx1,x1,ServerID);
    	BigInteger[] sigX2 = generateZKP(p,q,g,gx2,x2,ServerID);

    	BigInteger gx3 = g.modPow(x3,p);
    	BigInteger gx4 = g.modPow(x4,p);
    	BigInteger[] sigX3 = generateZKP(p,q,g,gx3,x3,NewNodeID);
    	BigInteger[] sigX4 = generateZKP(p,q,g,gx4,x4,NewNodeID);
    
    	System.out.println("************Step 1**************");
    	
		System.out.println("Server sends to NewNode: ");
    	System.out.println("g^{x1}="+gx1.toString(16));
        jp.showMessageDialog(null,gx1.toString(16),"from server to newnode ",JOptionPane.INFORMATION_MESSAGE);
    	System.out.println("g^{x2}="+gx2.toString(16));
        jp.showMessageDialog(null,gx2.toString(16),"from server to newnode ",JOptionPane.INFORMATION_MESSAGE);
    	System.out.println("KP{x1}={"+sigX1[0].toString(16)+"};{"+sigX1[1].toString(16)+"}");
    	System.out.println("KP{x2}={"+sigX2[0].toString(16)+"};{"+sigX2[1].toString(16)+"}");
		
    	System.out.println("");
      
    	System.out.println("NewNode sends to Server: ");
    	System.out.println("g^{x3}="+gx3.toString(16));
		jp.showMessageDialog(null,gx3.toString(16),"newnode to server ",JOptionPane.INFORMATION_MESSAGE);
    	System.out.println("g^{x4}="+gx4.toString(16));
		jp.showMessageDialog(null,gx4.toString(16),"newnodeto server ",JOptionPane.INFORMATION_MESSAGE);
    	System.out.println("KP{x3}={"+sigX3[0].toString(16)+"};{"+sigX3[1].toString(16)+"}");
    	System.out.println("KP{x4}={"+sigX4[0].toString(16)+"};{"+sigX4[1].toString(16)+"}");
		
       

    	System.out.println("");
    	
		/* server verifies newnode ZKPs and also check g^{x4} != 1*/
		if (gx4.equals(BigInteger.ONE) || !verifyZKP(p,q,g,gx3,sigX3,NewNodeID) || 
				!verifyZKP(p,q,g,gx4,sigX4,NewNodeID)) {
			System.out.println("g^{x4} shouldn't be 1 or invalid KP{x3,x4}");
			System.exit(0);
		}else {
			
			System.out.println("Server checks g^{x4}!=1: OK");			
			System.out.println("Server checks KP{x3}: OK");
			System.out.println("Server checks KP{x4}: OK");
			System.out.println("");
		}

		/* newnode verifies server ZKPs */
		if (gx2.equals(BigInteger.ONE) || !verifyZKP(p,q,g,gx1,sigX1,ServerID) || 
				!verifyZKP(p,q,g,gx2,sigX2,ServerID)) {
			System.out.println("g^{x2} shoudn't be 1 or invalid KP{x1,x2}");
			System.exit(0);
		}else{
			System.out.println("NewNode checks g^{x2}!=1: OK");
			System.out.println("NewNode checks KP{x1},: OK");	
			System.out.println("NewNode checks KP{x2},: OK");
			
			System.out.println("");
		}

		/* Step 2: server sends A and newnode sends B */
		BigInteger gA = gx1.multiply(gx3).multiply(gx4).mod(p);
		BigInteger A = gA.modPow(x2.multiply(s1).mod(q),p);
		BigInteger[] sigX2s = generateZKP(p,q,gA,A,x2.multiply(s1).mod(q),ServerID);
        
		BigInteger gB = gx3.multiply(gx1).multiply(gx2).mod(p);
		BigInteger B = gB.modPow(x4.multiply(s2).mod(q),p);
		BigInteger[] sigX4s = generateZKP(p,q,gB,B,x4.multiply(s2).mod(q),NewNodeID);

    	System.out.println("************Step 2**************");
    	System.out.println("server sends to newnode: ");
    	 
		System.out.println("A="+A.toString(16));
        jp.showMessageDialog(null,A.toString(16),"server to new node ",JOptionPane.INFORMATION_MESSAGE);
    	System.out.println("KP{x2*s}={"+sigX2s[0].toString(16)+"},{"+sigX2s[1].toString(16)+"}");
    	System.out.println("");
 
    	System.out.println("newnode sends to server");
		System.out.println("B="+B.toString(16));
        jp.showMessageDialog(null,B.toString(16),"server to new node ",JOptionPane.INFORMATION_MESSAGE);
    	System.out.println("KP{x4*s}={"+sigX4s[0].toString(16)+"},{"+sigX4s[1].toString(16)+"}");
    	System.out.println("");

    	/* server verifies newnode ZKP */
    	if (!verifyZKP(p,q,gB,B,sigX4s,NewNodeID)){
    		System.out.println("Invalid ZK{x4*s}");
    		System.exit(0);
    	} else {
    		jp.showMessageDialog(null,"keys verified","By the server",JOptionPane.INFORMATION_MESSAGE);
			System.out.println("server checks KP{x4*s}: OK\n");
    	}
	
    	/* newnode verifies server ZKP */
    	if (!verifyZKP(p,q,gA,A,sigX2s,ServerID)){
    		System.out.println("Invalid ZK{x2*s}");
    		System.exit(0);
    	} else {
    		jp.showMessageDialog(null,"Success!!!","NodeAdmitted",JOptionPane.INFORMATION_MESSAGE);
			System.out.println("newnode checks KP{x2*s}: OK\n");
    	}

    	/* After step 2, compute the common key */

    	BigInteger Ka = getSHA1(gx4.modPow(x2.multiply(s1).negate().mod(q),p).multiply(B).modPow(x2,p));
    	BigInteger Kb = getSHA1(gx2.modPow(x4.multiply(s2).negate().mod(q),p).multiply(A).modPow(x4,p));
		
    	System.out.println("************After step 2**************");
		
    	System.out.println("Server computes a session key \t K="+Ka.toString(16));
    	System.out.println("NewNode computes a session key \t K="+Kb.toString(16));    	
       

	return  commonkeys;
	}

    public BigInteger[] generateZKP (BigInteger p, BigInteger q, BigInteger g, 
				     BigInteger gx, BigInteger x, String signerID){
    	BigInteger [] ZKP = new BigInteger [2];

    	/* Generate a random r, and compute g^r */
    	BigInteger r = new BigInteger (160, new SecureRandom());
    	BigInteger gr = g.modPow(r,p);
    	BigInteger h = getSHA1(g,gr,gx,signerID); // h

    	ZKP[0] = gr;
    	ZKP[1] = r.subtract(x.multiply(h)).mod(q); // b = r-x*h
	
    	return ZKP;
    }

    public boolean verifyZKP(BigInteger p, BigInteger q, BigInteger g, BigInteger gx,
			     BigInteger[] sig, String signerID) {
    	
    	/* sig={g^r,b} */
    	BigInteger h = getSHA1(g,sig[0],gx,signerID);
    	if (g.modPow(sig[1],p).multiply( gx.modPow(h,p) ).mod(p).compareTo(sig[0]) == 0)
    		return true;
    	else
    		return false;
    }

    public BigInteger getSHA1(BigInteger g, BigInteger gr, BigInteger gx, String signerID) {

    	MessageDigest sha = null;

    	try {
    		sha = MessageDigest.getInstance("SHA-1");
    		
    		/* Note: you should ensure the items in H(...) have clear boundaries.
    		 * It is simple if the other party knows sizes of g, gr, gx 
    		 * and signerID and hence the boundary is unambiguous. If not, you'd
    		 * better prepend each item with its byte length, but I've 
    		 * omitted that here.
    		 */ 
			  	    		
    		sha.update(g.toByteArray());
    		sha.update(gr.toByteArray());
    		sha.update(gx.toByteArray());
    		sha.update(signerID.getBytes());
    	} catch (Exception e) {
    		e.printStackTrace();
    	}

    	return new BigInteger(sha.digest());
    }

    public BigInteger getSHA1(BigInteger K) {

    	MessageDigest sha = null;

    	try {
    		sha = MessageDigest.getInstance("SHA-1");
    		sha.update(K.toByteArray());
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
        
    	return new BigInteger(1, sha.digest()); // 1 for positive int
    }

 public static void main(String args[])
	{
     
      new keyestablish("Spiro#+sprio+#");
   
   }
}

