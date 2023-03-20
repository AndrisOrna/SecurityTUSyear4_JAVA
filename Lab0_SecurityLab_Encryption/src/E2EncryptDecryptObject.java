//package encrypt;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

public class E2EncryptDecryptObject {
	public static void main(String[] args) {

			try {
				String ALGORITHM = "AES";
				// Key
				KeyGenerator keygen = KeyGenerator.getInstance(ALGORITHM);
				SecretKey key = keygen.generateKey();
				
				// Cipher
				Cipher eCipher = Cipher.getInstance(ALGORITHM);
				eCipher.init(Cipher.ENCRYPT_MODE, key);
				
				// Seal (encrypt) the object
				Employee employee = new Employee("007", "UK", "087 007007");
				SealedObject so = new SealedObject(employee, eCipher);
				
				///// Decrypt
				Cipher dCipher = Cipher.getInstance(ALGORITHM);
				dCipher.init(Cipher.DECRYPT_MODE, key);
				
				// Unseal (decrypt) the class
				Employee out = (Employee) so.getObject(dCipher);
				System.out.println("Employee " + out.getName());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			


	}
}
