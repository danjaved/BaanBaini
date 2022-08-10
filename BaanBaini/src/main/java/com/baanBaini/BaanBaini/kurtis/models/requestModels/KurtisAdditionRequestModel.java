package com.baanBaini.BaanBaini.kurtis.models.requestModels;

import com.baanBaini.BaanBaini.kurtis.kurtiFeatures.KurtiAvailability;
import com.baanBaini.BaanBaini.kurtis.kurtiFeatures.KurtiLength;
import com.baanBaini.BaanBaini.kurtis.kurtiFeatures.KurtiMaterial;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class KurtisAdditionRequestModel {
    private String name;
    private KurtiMaterial material;
    private int price;
    private String description;
    private KurtiLength[] length;
    private List<KurtiAvailability> availabilities;
    private String color;
    private String fit;
    private String pattern;

    private MultipartFile[] multipartImages;

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

    public KurtiLength[] getLength() {
        return length;
    }

    public void setLength(KurtiLength[] length) {
        this.length = length;
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

    public String getFit() {
        return fit;
    }

    public void setFit(String fit) {
        this.fit = fit;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public MultipartFile[] getMultipartImages() {
        return multipartImages;
    }

    public void setMultipartImages(MultipartFile[] multipartImages) {
        this.multipartImages = multipartImages;
    }
}
