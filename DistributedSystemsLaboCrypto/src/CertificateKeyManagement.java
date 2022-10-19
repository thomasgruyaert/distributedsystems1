import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

public class CertificateKeyManagement {
    public static void main(String[] args) throws KeyStoreException, IOException, CertificateException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnrecoverableKeyException {
        KeyStore keyStoreWerner = KeyStore.getInstance("JKS");
        KeyStore keyStoreFreya = KeyStore.getInstance("JKS");
        String freyaJksFileName = "keystores/store2.jks";
        String wernerJksFileName = "keystores/store1.jks";
        FileInputStream fis = new FileInputStream(wernerJksFileName);
        keyStoreWerner.load(fis, "Werner".toCharArray());
        fis.close();
        fis = new FileInputStream(freyaJksFileName);
        keyStoreFreya.load(fis, "Freya".toCharArray());
        fis.close();
        Certificate freyaCertificate = keyStoreWerner.getCertificate("freya");
        byte[] clearText = "Dit is een korte tekst".getBytes(StandardCharsets.UTF_8);
        Cipher rsaCipher = Cipher.getInstance("RSA");
        rsaCipher.init(Cipher.ENCRYPT_MODE, freyaCertificate.getPublicKey());
        byte[] cipherTextRsa = rsaCipher.doFinal(clearText);
        rsaCipher.init(Cipher.DECRYPT_MODE, keyStoreFreya.getKey("freya", "Freya".toCharArray()));
        byte[] clearTextDecipheredRsa = rsaCipher.doFinal(cipherTextRsa);
        System.out.println(new String(clearTextDecipheredRsa));
    }
}
