package com.safwan.realestate.controller;

import com.safwan.realestate.model.*;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/apartments")
public class ApartmentController {
    private final ApartmentService apartmentService;
    private final ImagesService imagesService;

    public ApartmentController(ApartmentService apartmentService, ImagesService imagesService) {
        this.apartmentService = apartmentService;
        this.imagesService = imagesService;
    }


    @InitBinder
    public void setAllowedFields(WebDataBinder webDataBinder){
        webDataBinder.setDisallowedFields("id");
    }


    @RequestMapping({"/find", "/find.html"})
    public String findOwners(Model model){

        model.addAttribute("apartment",new Apartment());



        return "findApartments";
    }


    @GetMapping()
    public String processFindForm(Apartment apartment, BindingResult result, Model model){
        List<Apartment> results=null;

        if (apartment.getPrice() != 0)
            results = apartmentService.findByPriceLessThan(apartment.getPrice());
        else if (apartment.getArea() != 0){
            results = apartmentService.findByAreaGreaterThan(apartment.getArea());}
        else if(apartment.getName() != null)//apartment.setName("");
            results = apartmentService.findAllByNameLike("%" + apartment.getName() + "%");
        else {
            apartment.setName("");
            results = apartmentService.findAllByNameLike("%" + apartment.getName() + "%");
        }

        if(results.isEmpty()){
            result.rejectValue("name","notFound","not found");
            return "apartments/find";
        }else if (results.size()==1){
            apartment = results.get(0);
            System.out.println(apartment.getId());
            return "redirect:/apartments/" + apartment.getId();
        }else {
            model.addAttribute("selections", results);
            return "apartmentList";
        }
    }

    @GetMapping("/{apartmentId}")
    public ModelAndView showOwner(@PathVariable("apartmentId") Long apartmentId) throws IOException {



        ModelAndView mav = new ModelAndView("apartmentDetails");
        Apartment apartment = apartmentService.findById(apartmentId);
        //apartment.setImage(dataa);
        mav.addObject(apartment);
        ImagesBase64 imagesBase64 = new ImagesBase64();
        apartment.setImages(imagesService.findAllByApartment(apartment));
        for (Images images:apartment.getImages())
        {
            int i=0;
            Byte[] temp = images.getBase64();
            byte[] im = new byte[temp.length];
            for(Byte b:temp)im[i++]=b;

            imagesBase64.getImages().add(new String(Base64.encodeBase64(im), "UTF-8"));
            System.out.println(imagesBase64.getImages().toString());


            // imagesBase64.getImages()
           // for (String s: imagesBase64.getImages()) System.out.println(s);
        }
        mav.addObject("messages", imagesBase64.getImages());
        return mav;
    }


    @GetMapping("/{id}/image")
    public String showUploadForm(@PathVariable String id, Model model){
        model.addAttribute("apartment", apartmentService.findById(Long.valueOf(id)));

        return "imageuploadform";
    }


    @PostMapping("/{id}/image")
    public String handleImagePost(@PathVariable String id, @RequestParam("imagefile") MultipartFile file){

        imagesService.saveImageFile(Long.valueOf(id), file);

        return "redirect:/apartments/" + id ;
    }


    @GetMapping("/add")
    public String addApartment(Model model){
        Set<Images> imagesSet = new HashSet<>();
        Apartment apartment = new  Apartment("",0.0,"",0.0, imagesSet);
        model.addAttribute("newapartment", apartment);

        return "addapartment";
    }


    @PostMapping("/add")
    public String processCreationForm(Apartment apartment, BindingResult result) {

        Apartment save =  apartmentService.save(apartment);
            return "redirect:/apartments/" + save.getId();
    }



}
