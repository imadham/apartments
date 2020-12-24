package com.safwan.realestate.model;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
@Service
public class ImageSrviceImpl implements ImagesService {
    public ImageSrviceImpl(ImageRepository imageRepository, ApartmentRepository apartmentRepository) {
        this.imageRepository = imageRepository;
        this.apartmentRepository = apartmentRepository;
    }

    private final ImageRepository imageRepository;
    private final ApartmentRepository apartmentRepository;
    @Override
    public Set<Images> findAll() {
        Set<Images> images = new HashSet<>();
         imageRepository.findAll().forEach(images::add);
         return images;
    }

    @Override
    public Images findById(Long aLong) {
        return null;
    }

    @Override
    public Images save(Images object) {
        return null;
    }

    @Override
    public void delete(Images object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Set<Images> findAllById(Long id) {
        Set<Images> images = new HashSet<>();
        imageRepository.findAllById(id).forEach(images::add);
        return images;
    }

    @Override
    public Set<Images> findAllByApartment(Apartment apartment) {
        Set<Images> images = new HashSet<>();
        imageRepository.findAllByApartment(apartment).forEach(images::add);
        return images;
    }

    @Override
    public void saveImageFile(Long apartmentId, MultipartFile file) {
        try {
            Apartment apartment = apartmentRepository.findById(apartmentId).get();

            Byte[] byteObjects = new Byte[file.getBytes().length];

            int i = 0;

            for (byte b : file.getBytes()){
                byteObjects[i++] = b;
            }

            apartment.getImages().add(new Images(apartment,byteObjects));

            apartmentRepository.save(apartment);
        } catch (IOException e) {

            System.err.println("error during saving image");

            e.printStackTrace();
        }
    }


}
