package com.baanBaini.BaanBaini.shared.utility;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.util.IOUtils;
import org.joda.time.DateTime;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public interface S3Helper {

     AmazonS3 s3= AmazonS3ClientBuilder.standard().withRegion(Regions.AP_SOUTH_1).build();
     String bucketName="baan-baini";

     static List<byte[]> getKurtiImages(String kurtiPublicId){
        List<byte[]> images=new ArrayList<>();
        List<String> imagesNames=new ArrayList<>();
        s3.listObjects(bucketName,kurtiPublicId).getObjectSummaries().forEach(object->imagesNames.add(object.getKey()));
        imagesNames.forEach(imageName->{
            try {
                images.add(IOUtils.toByteArray(s3.getObject(bucketName,imageName).getObjectContent()));
            } catch (IOException e) {}
        });
        return images;
    }
    static boolean saveImages(String kurtiPublicId, List<MultipartFile> multipartImages){
        for (MultipartFile image:multipartImages) {
            try {
                InputStream imgInputStream= image.getInputStream();
                String key=kurtiPublicId+"/"+ DateTime.now().getMillis()+"_"+image.getOriginalFilename();
                s3.putObject(bucketName,key,imgInputStream,new ObjectMetadata());
            } catch (IOException e) {}

        }
        return true;
    }
}
