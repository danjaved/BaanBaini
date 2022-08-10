package com.baanBaini.BaanBaini.shared.utility;

//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class Utility {
    public String getRandomString(String prefix,int length){
        String chars="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        String randomString=prefix+"_";
        Random random=new Random();
        for(int i=0;i<length-3;i++) {
            randomString+=chars.charAt(random.nextInt(36));
        }
       return randomString;
    }
}
