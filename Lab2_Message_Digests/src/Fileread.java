import java.io.FileInputStream;
import java.io.InputStream;

public class Fileread {
	
	public static void main(String[] args) {
		//InputStream is;
		//int read(byte[] b)

		try {
			InputStream is = new FileInputStream("data/test.txt");
			byte[] buffer = new byte[64];
			int bytesRead = 0;
			while ((bytesRead = is.read(buffer)) > 0) {
			System.out.println(bytesRead);
			System.out.println(new String(buffer));
			}
			is.close();
		}
		catch(Exception e) {
			e.printStackTrace();

		}
	}

}
