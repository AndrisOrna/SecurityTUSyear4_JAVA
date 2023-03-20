
import java.util.Set;
import java.security.Security;
import java.security.SecureRandom;

public class E6providers {

	public static void main(String[] args) {

		final Set<String> algorithms = Security.getAlgorithms("SecureRandom");

		for (String algorithm : algorithms) {
			System.out.println(algorithm);
		}

		final String defaultAlgorithm = new SecureRandom().getAlgorithm();

		System.out.println("default: " + defaultAlgorithm);

	}

}
