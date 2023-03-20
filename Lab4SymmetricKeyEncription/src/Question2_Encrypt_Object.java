import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

import Solutions.Employee;

// Write a Java class Employee with fields name, address telNo.
// Write a Java program to
// instantiate an Employee object
// create a SealedObject containing the Employee object, encrypted with some Cipher
// Extract the object from the SealedObject using another cipher (initialized for decryption)
// Print out the contents of the Employee object.

public class Question2_Encrypt_Object {

	public static void main(String[] args) throws Exception {
		String ALGORITHM = "AES";
		// String ALGORITHM = "DES" ;
		// String ALGORITHM = "BlowFish";

		KeyGenerator keygen = KeyGenerator.getInstance(ALGORITHM);
		SecretKey key = keygen.generateKey();
		
		Cipher eCipher = Cipher.getInstance(ALGORITHM);
		// Initialize the cipher for encryption
		eCipher.init(Cipher.ENCRYPT_MODE, key);

		// Seal (encrypt) the object
		Employee emp = new Employee("025", "UK", "087 007007") ;
		SealedObject so = new SealedObject(emp, eCipher);

		// can now store the object for example.
		// ///////////////////////////
		// Decrypt

		// Prepare the decrypter
		Cipher dCipher = Cipher.getInstance(ALGORITHM);
		dCipher.init(Cipher.DECRYPT_MODE, key);

		// Unseal (decrypt) the class
		Employee o = (Employee) so.getObject(dCipher);
		System.out.println("Employee " + o.getName());
	}

}
