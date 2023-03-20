
import java.util.*;

public class E5LCG {

	public static void main(String[] args) {

		// parameter values
		int seed = 5;
		int mod = 7;
		int multiplier = 3;
		int inc = 3;

		int prev = seed ;
		for (int i = 0; i < 20; i++) {
			int random = ((prev * multiplier) + inc) % mod;
			prev = random ;
			System.out.print(random + " ");
		}
	}
}
