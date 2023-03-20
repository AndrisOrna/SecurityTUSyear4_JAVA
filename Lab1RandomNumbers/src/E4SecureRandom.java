
import java.security.SecureRandom;

import org.apache.commons.codec.binary.Hex;

public class E4SecureRandom {

	public static void main(String[] args) {
		
		SecureRandom random = new SecureRandom();
		random.setSeed(0);
		System.out.println(random.nextInt(1000));

		// or to generate a seed for another PRNG
		byte[] seed = random.generateSeed(20);
		System.out.println(Hex.encodeHexString(seed));
		
	}

}
