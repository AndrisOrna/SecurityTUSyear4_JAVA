//package encrypt;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

public class E3EncryptObjectToFile {

	private static void writeToFile(String filename, Object object) throws Exception {
		FileOutputStream fout = new FileOutputStream(filename);
		ObjectOutputStream oout = new ObjectOutputStream(fout);
		oout.writeObject(object);
		oout.close();
	}

	public static void main(String[] args) {

		try {
			String ALGORITHM = "AES";

			KeyGenerator keygen = KeyGenerator.getInstance(ALGORITHM);
			SecretKey key = keygen.generateKey();

			writeToFile("data/secretKey", key);

			Cipher eCipher = Cipher.getInstance(ALGORITHM);
			eCipher.init(Cipher.ENCRYPT_MODE, key);

			// Seal (encrypt) the object
			Employee employee = new Employee("007", "UK", "087 007007") ;
			SealedObject so = new SealedObject(employee, eCipher);
			writeToFile("data/sealedObject", so);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}