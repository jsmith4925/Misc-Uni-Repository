import javax.crypto.SecretKey;

public class runme {
    public static void main(String[] args) throws Exception {

        String plaintext = "Hello, World!";
        
        AES NewCipher = new AES();
        
        SecretKey key = NewCipher.generateKeyFromPassword("Swansea");
        
        String ciphertext = NewCipher.encrypt(plaintext, key);
        
        System.out.println(plaintext);
        System.out.println(ciphertext);
        
        String decoded = NewCipher.decrypt(ciphertext, key);
        
        System.out.println(decoded);


    }
}