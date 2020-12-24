package com.safwan.realestate.model;

import java.util.HashSet;
import java.util.Set;

public class ImagesBase64 {

    public Set<String> getImages() {
        return images;
    }

    public void setImages(Set<String> images) {
        this.images = images;
    }

    Set<String> images = new HashSet<>();
    public ImagesBase64() {
    }
}
