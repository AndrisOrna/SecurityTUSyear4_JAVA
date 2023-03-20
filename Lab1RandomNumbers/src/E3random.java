
import java.util.Random;

public class E3random {

	public static void main(String[] args) {
		
		Random rnd = new Random(0);
		
		System.out.println(rnd.nextInt());
		System.out.println(rnd.nextInt(100));
		System.out.println(rnd.nextDouble());
		
	}

}
