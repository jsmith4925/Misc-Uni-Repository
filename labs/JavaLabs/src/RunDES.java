import javax.crypto.SecretKey;

public class RunDES {
    public static void main(String[] args) throws Exception {

        String plaintext = "Hello, World!";
        
        DES NewCipher = new DES();
        
        SecretKey key = NewCipher.generateKeyFromPassword("Swansea");
        
        String ciphertext = NewCipher.encrypt(plaintext, key);
        
        System.out.println(plaintext);
        System.out.println(ciphertext);
        
        String decoded = NewCipher.decrypt(ciphertext, key);
        
        System.out.println(decoded);


    }
}