import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class A1MessageDigestEx {

	public static void main(String[] args) {

		String password = "12345";
		 MessageDigest algorithm = null;
		 try {
		 algorithm = MessageDigest.getInstance("MD5");
		 } catch (NoSuchAlgorithmException e) {
		 e.printStackTrace();
	}
		 // main part 
		 algorithm.reset();
		 algorithm.update(password.getBytes());
		 byte[] messageDigest = algorithm.digest();
		 // main part end
		 
		 System.out.println("length " + messageDigest.length);

		 String encodedDigest = Base64.getEncoder().encodeToString(messageDigest);;
		 System.out.println("Base64 encoded message digest " + encodedDigest);
	}
}
