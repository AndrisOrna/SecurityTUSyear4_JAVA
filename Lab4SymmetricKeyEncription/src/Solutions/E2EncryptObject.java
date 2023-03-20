package Solutions;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

public class E2EncryptObject {
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
		Employee emp = new Employee("007", "UK", "087 007007") ;
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
