import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.crypto.Cipher;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

import Solutions.Employee;

// Write a second Java program to
// read the key from file
// read the SealedObject from file
// extract the Employee object from the SealedObject.
// print out the text stored in the Employee object.
public class Question3B_ReadFromFile {

	  private static Object readFromFile(String filename) throws Exception {
	    FileInputStream fin = new FileInputStream(filename);
	    ObjectInputStream oin = new ObjectInputStream(fin);
	    Object object = oin.readObject();
	    oin.close();
	    return object;
	  }

	  public static void main(String[] args) throws Exception {
	    
	    String ALGORITHM = "AES";
	    SecretKey key = (SecretKey) readFromFile("data/secretKey") ;

	    SealedObject so = (SealedObject) readFromFile("data/sealedObject.dat") ;
	    
	    // Prepare the decrypter
	    Cipher dCipher = Cipher.getInstance(ALGORITHM);
	    dCipher.init(Cipher.DECRYPT_MODE, key);

	    // Unseal (decrypt) the class
	    Employee o = (Employee) so.getObject(dCipher);
	    System.out.println("Employee: " + o.getName());
	  }
	}
