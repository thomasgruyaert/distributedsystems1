import javax.crypto.*;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Base64;

public class CryptographicPrimitives {
    private static String toHexString(byte[] hash)
    {
        // Convert byte array into signum representation
        BigInteger number = new BigInteger(1, hash);

        // Convert message digest into hex value
        StringBuilder hexString = new StringBuilder(number.toString(16));

        // Pad with leading zeros
        while (hexString.length() < 64)
        {
            hexString.insert(0, '0');
        }

        return hexString.toString();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, IOException, SignatureException, InvalidAlgorithmParameterException, NoSuchProviderException {
        long start, finish;

        Person person1 = new Person("Jef","Drongen","0473448923");
        Person person2 = new Person("Thomas", "Tielt", "0486325869");
        Person person1Fake = new Person("Jeff","Drongen","0473448923");

        byte[] person1Bytes = person1.getBytes();
        byte[] person2Bytes = person2.getBytes();
        byte[] person1FakeBytes = person1Fake.getBytes();

        //SHA-256 hashing
        System.out.println("SHA-256\n");
        MessageDigest md1 = MessageDigest.getInstance("SHA-256");
        byte[] p1Hash = md1.digest(person1Bytes);
        byte[] p1FakeHash = md1.digest(person1FakeBytes);
        System.out.println("Person 1 hash: ");
        System.out.println(toHexString(p1Hash));
        System.out.println("Person 1 fake hash: ");
        System.out.println(toHexString(p1FakeHash));


        //Symmetrische Encryptie
        //Mogelijke sleutellengtes AES: 128, 192 of 256 bits; 3DES: 112 of 168 bits
        //AES
        System.out.println("\nAES\n");
        KeyGenerator keygen = KeyGenerator.getInstance("AES");
        SecretKey aesKey = keygen.generateKey();
        Cipher aesCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        aesCipher.init(Cipher.ENCRYPT_MODE, aesKey);
        byte[] clearText = "Dit is een korte tekst".getBytes(StandardCharsets.UTF_8);
        System.out.println("Plain text:");
        System.out.println(new String(clearText));
        start = System.nanoTime();
        byte[] cipherTextAes = aesCipher.doFinal(clearText);
        finish = System.nanoTime();
        long elapsedTimeEncryptionAes = finish - start;
        System.out.println("Encrypted (base64):");
        System.out.println(Base64.getEncoder().encodeToString(cipherTextAes));
        System.out.println("Elapsed Time Encryption AES: " + elapsedTimeEncryptionAes);
        aesCipher.init(Cipher.DECRYPT_MODE, aesKey);
        start = System.nanoTime();
        byte[] clearTextDecipheredAes = aesCipher.doFinal(cipherTextAes);
        finish = System.nanoTime();
        long elapsedTimeDecryptionAes = finish - start;
        System.out.println("Deciphered:");
        System.out.println(new String(clearTextDecipheredAes));
        System.out.println("Elapsed Time Decryption AES: " + elapsedTimeDecryptionAes);

        //Assymmetrische Encryptie
        //Mogelijke sleutellengtes RSA: 1024, 2048, 4096 bits; DSA: 2048 bits
        //RSA
        System.out.println("\nRSA\n");
        KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
        generator.initialize(2048);
        KeyPair pair = generator.generateKeyPair();
        PrivateKey privateKey = pair.getPrivate();
        PublicKey publicKey = pair.getPublic();
        System.out.println("Public Key:");
        System.out.println(Base64.getEncoder().encodeToString(publicKey.getEncoded()));
        Cipher rsaCipher = Cipher.getInstance("RSA");
        rsaCipher.init(Cipher.ENCRYPT_MODE, publicKey);
        start = System.nanoTime();
        byte[] cipherTextRsa = rsaCipher.doFinal(clearText);
        finish = System.nanoTime();
        long elapsedTimeEncryptionRSA = finish - start;
        System.out.println("Encrypted (base64):");
        System.out.println(Base64.getEncoder().encodeToString(cipherTextRsa));
        System.out.println("Elapsed Time Encryption RSA: " + elapsedTimeEncryptionRSA);
        rsaCipher.init(Cipher.DECRYPT_MODE, privateKey);
        start = System.nanoTime();
        byte[] clearTextDecipheredRsa = rsaCipher.doFinal(cipherTextRsa);
        finish = System.nanoTime();
        long elapsedTimeDecryptionRSA = finish - start;
        System.out.println("Deciphered:");
        System.out.println(new String(clearTextDecipheredRsa));
        System.out.println("Elapsed Time Decryption RSA: " + elapsedTimeDecryptionRSA);

        //Digitale handtekening
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
        SecureRandom random = SecureRandom.getInstance("DRBG", "SUN");
        keyGen.initialize(2048, random);
        KeyPair keyPair = keyGen.generateKeyPair();
        Signature dsa = Signature.getInstance("SHA256withDSA");
        PrivateKey priv = keyPair.getPrivate();
        dsa.initSign(priv);
        dsa.update(person2Bytes);
        byte[] signedPerson2 = dsa.sign();
        //Verification
        PublicKey pub = keyPair.getPublic();
        dsa.initVerify(pub);
        /* Update and verify the data */
        dsa.update(person2Bytes);
        boolean verifies = dsa.verify(signedPerson2);
        System.out.println("Signature verification: " + verifies);
    }
}

