//package encrypt;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class E1encryption {
	public static void main(String[] args) throws Exception {

		String message = "This is an important message";

		String ALGORITHM = "AES";
		KeyGenerator keygen = KeyGenerator.getInstance(ALGORITHM);
		SecretKey key = keygen.generateKey();
		Cipher eCipher = Cipher.getInstance(ALGORITHM);
		// Initialize the cipher for encryption
		eCipher.init(Cipher.ENCRYPT_MODE, key);

		// Encrypt the plaintext
		byte[] ciphertext = eCipher.doFinal(message.getBytes());
		System.out.println("Length of plain text " + message.getBytes().length);
		System.out.println("Length of cipher text " + ciphertext.length);

		/////////////////////////////////////////////////
		// Decrypt

		Cipher dCipher = Cipher.getInstance(ALGORITHM);
		dCipher.init(Cipher.DECRYPT_MODE, key);

		// Decrypt the ciphertext
		byte[] plainText = dCipher.doFinal(ciphertext);

		String text = new String(plainText);
		System.out.println("Decrypted text: " + text);

	}
}
