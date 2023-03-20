import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

import Solutions.Employee;

// Write a Java program to
// instantiate an Employee object
// create a SealedObject containing an Employee object, encrypted with some Cipher
// save the SealedObject to a file (“data/sealedObject.dat”)
// save the Cipher key to a file (“data/secretKey”)

public class Question3A_Instatiate_Employee_object {

	   private static void writeToFile(String filename, Object object)
	         throws Exception {
	      FileOutputStream fout = new FileOutputStream(filename);
	      ObjectOutputStream oout = new ObjectOutputStream(fout);
	      oout.writeObject(object);
	      oout.close();
	   }

	   public static void main(String[] args) throws Exception {

	      String ALGORITHM = "AES";

	      KeyGenerator keygen = KeyGenerator.getInstance(ALGORITHM);
	      SecretKey key = keygen.generateKey();
	      writeToFile("data/secretKey", key);

	      Cipher eCipher = Cipher.getInstance(ALGORITHM);
	      eCipher.init(Cipher.ENCRYPT_MODE, key);

	      // Seal (encrypt) the object
	      Employee emp = new Employee("007", "England", "087 007007") ;
	      SealedObject so = new SealedObject(emp, eCipher);
	      writeToFile("data/sealedObject.dat", so);
	   }
	}
