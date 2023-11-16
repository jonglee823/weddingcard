package com.wedding.weddingcard.util;

import com.wedding.weddingcard.request.CommentRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
@Slf4j
public class EncryptionUtil {

    public String makepasswd(String password){
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }

        md.update(password.getBytes());
        return bytesToHex1(md.digest());
    }

    public String bytesToHex1(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b: bytes) {
            builder.append(String.format("%02x", b));
        }
        //log.info(builder.toString());
        return builder.toString();
    }

}