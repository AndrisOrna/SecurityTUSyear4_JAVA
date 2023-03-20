

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;
import java.util.Base64;

public class M3messageDigestFile {
	public static void main(String[] args) {
		try {
			MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
			InputStream fin = new FileInputStream("data/test.txt");
			byte[] buffer = new byte[8192];

			int bytesRead = 0;
			while ((bytesRead = fin.read(buffer)) > 0) {
				algorithm.update(buffer, 0, bytesRead);
			}
			fin.close();

			byte[] digest = algorithm.digest();

			String encodedDigest = Base64.getEncoder().encodeToString(digest);
			System.out.println("Base64 encoded message digest " + encodedDigest);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
