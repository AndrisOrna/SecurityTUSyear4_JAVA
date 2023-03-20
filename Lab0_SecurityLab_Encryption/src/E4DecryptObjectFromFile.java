//package encrypt;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.crypto.Cipher;
import javax.crypto.SealedObject;
import javax.crypto.SecretKey;

public class E4DecryptObjectFromFile {

  private static Object readFromFile(String filename) throws Exception {
    FileInputStream fin = new FileInputStream(filename);
    ObjectInputStream oin = new ObjectInputStream(fin);
    Object object = oin.readObject();
    oin.close();
    return object;
  }

  public static void main(String[] args) throws Exception {
    
    String ALGORITHM = "AES";
    SecretKey key = (SecretKey) readFromFile("data/secretKey") ;

    SealedObject so = (SealedObject) readFromFile("data/sealedObject") ;
    
    // Prepare to decrypt
    Cipher dCipher = Cipher.getInstance(ALGORITHM);
    dCipher.init(Cipher.DECRYPT_MODE, key);

    // Unseal (decrypt) the object
    Employee o = (Employee) so.getObject(dCipher);
    System.out.println("Employee: " + o.getName());
  }
}
