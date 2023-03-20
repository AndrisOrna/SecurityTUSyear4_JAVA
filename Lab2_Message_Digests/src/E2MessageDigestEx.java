import org.apache.commons.codec.digest.DigestUtils;

public class E2MessageDigestEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String sessionid = "12345";
		System.out.println("Session id: " + sessionid);
		String md5 = DigestUtils.md5Hex(sessionid);
		System.out.println("sessionid " + sessionid +
		" md5 version is " + md5);
		
		String sha256 = DigestUtils.sha256Hex(sessionid);
		System.out.println("sessionid " + sessionid +
		" sha256 version is " + sha256);
		
		String sha2561 = DigestUtils.sha256Hex(sessionid);
		System.out.println("sha256:" + sessionid);
	}

}
