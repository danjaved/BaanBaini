package com.baanBaini.BaanBaini.kurtis.models.reponseModels;

import com.baanBaini.BaanBaini.kurtis.kurtiFeatures.KurtiAvailability;
import com.baanBaini.BaanBaini.kurtis.kurtiFeatures.KurtiLength;
import com.baanBaini.BaanBaini.kurtis.kurtiFeatures.KurtiMaterial;
import com.baanBaini.BaanBaini.kurtis.kurtiFeatures.KurtiSize;

import java.util.List;

public class KurtisAdditionResponseModel {
    private String publicId;
    private String name;
    private KurtiMaterial material;
    private int price;
    private String description;
    private List<KurtiLength>  length;
    private List<String> imgUrls;
    private List<KurtiAvailability> availabilities;
    private String color;
    private String fit;
    private String pattern;

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

    public List<String> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<String> imgUrls) {
        this.imgUrls = imgUrls;
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
}