package com.andyadc.seckill.infrastructure.crypto;

import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Sha512Hash;
import org.apache.shiro.util.ByteSource;

/**
 * https://blog.swierczynski.net/2013/01/strong-passwords-hashing-wtih-apache-shiro
 */
public class CryptoUtil {

    private static final int hashIterations = 2;

    public static String encrypt(String username, String clearTextPassword) {
        ByteSource salt = ByteSource.Util.bytes(username);
        return hashAndSaltPassword(clearTextPassword, salt);
    }

    public static boolean match(String username, String clearTextPassword, String dbStoredHashedPassword) {
        ByteSource byteSource = ByteSource.Util.bytes(username);
        String hashedPassword = hashAndSaltPassword(clearTextPassword, byteSource);
        return hashedPassword.equals(dbStoredHashedPassword);
    }

    public static void main(String[] args) {
        ByteSource byteSource = getSalt();
        System.out.println(byteSource.toHex());

        String clearTextPassword = "123456";
        String hashedPassword = hashAndSaltPassword(clearTextPassword, byteSource);
        System.out.println(hashedPassword);

        System.out.println(passwordsMatch(
                "a3a6c659230fce75cc4d77f1cbaead2569939406eec1be5b7a2f37cc285d29aaed1a68f093466a25faa2886d787640a18e3dedefcf6ab592efdb9c457940df2e",
                "fe00fc8b5fe6de665ce29be732a9f9a2",
                clearTextPassword)
        );

        System.out.println("----------------------");
        System.out.println(encrypt("adc", "123"));

        System.out.println(match("adc", "123",
                "0ac5f88f461440ff8e74bbe62b4942d45690ec3e3682715bc15399e019986bd6a1c1993de84deba221135832037f7b9e2decfe6676787d66bb976005f3e8037d"));
    }

    public static boolean passwordsMatch(String dbStoredHashedPassword, String salt, String clearTextPassword) {
        ByteSource byteSource = ByteSource.Util.bytes(Hex.decode(salt));
        String hashedPassword = hashAndSaltPassword(clearTextPassword, byteSource);
        return hashedPassword.equals(dbStoredHashedPassword);
    }

    private static ByteSource getSalt() {
        return new SecureRandomNumberGenerator().nextBytes();
    }

    private static String hashAndSaltPassword(String clearTextPassword, ByteSource salt) {
        return new Sha512Hash(clearTextPassword, salt, hashIterations).toHex();
    }
}
