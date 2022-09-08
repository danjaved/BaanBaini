package com.baanBaini.BaanBaini.kurtis.models.dto;

import com.baanBaini.BaanBaini.kurtis.kurtiFeatures.KurtiAvailability;
import com.baanBaini.BaanBaini.kurtis.kurtiFeatures.KurtiFit;
import com.baanBaini.BaanBaini.kurtis.kurtiFeatures.KurtiLength;
import com.baanBaini.BaanBaini.kurtis.kurtiFeatures.KurtiMaterial;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class KurtisDto {
    private String publicId;
    private String name;
    private KurtiMaterial material;
    private int price;
    private String description;
    private List<KurtiLength>  length;
    private List<MultipartFile> multipartImages;
    private List<byte[]> images;
    private List<KurtiAvailability> availabilities;
    private String color;
    private KurtiFit fit;
    private String pattern;

    private  boolean isDeleted;

    public String getPublicId() {
        return publicId;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public KurtiMaterial getMaterial() {
        return material;
    }

    public void setMaterial(KurtiMaterial material) {
        this.material = material;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<KurtiLength> getLength() {
        return length;
    }

    public void setLength(List<KurtiLength> length) {
        this.length = length;
    }

    public List<MultipartFile> getMultipartImages() {
        return multipartImages;
    }

    public void setMultipartImages(List<MultipartFile> multipartImages) {
        this.multipartImages = multipartImages;
    }

    public List<byte[]> getImages() {
        return images;
    }

    public void setImages(List<byte[]> images) {
        this.images = images;
    }

    public List<KurtiAvailability> getAvailabilities() {
        return availabilities;
    }

    public void setAvailabilities(List<KurtiAvailability> availabilities) {
        this.availabilities = availabilities;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public KurtiFit getFit() {
        return fit;
    }

    public void setFit(KurtiFit fit) {
        this.fit = fit;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }
}
