package com.safwan.realestate.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

public interface ImagesService extends CrudService <Images, Long> {
     Set<Images> findAllById(Long id);
     Set<Images> findAllByApartment(Apartment apartment);
     public void saveImageFile(Long recipeId, MultipartFile file);
}
