package com.safwan.realestate.loadData;

import com.safwan.realestate.model.Apartment;

import com.safwan.realestate.model.ApartmentService;
import com.safwan.realestate.model.Images;
import org.apache.tomcat.util.codec.binary.Base64;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.io.File;
import java.io.FileInputStream;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {
    public DataLoader(ApartmentService apartmentService) {
        this.apartmentService = apartmentService;
    }

    private final ApartmentService apartmentService;
    @Override
    public void run(String... args) throws Exception {

        if(apartmentService.findAll().size()==0){

            Apartment[] apartments = new Apartment[9];

            apartments[0] = new Apartment(1L,"first",20000000,"latakia-Syria, 1 Street",55);
            apartments[1] = new Apartment(2L,"second",50000000,"latakia-Syria university",75);
            apartments[2] = new Apartment(3L,"3-rd",40000000,"latakia-Syria 8 tishreen",35);
            apartments[3] = new Apartment(4L,"4-th",70000000,"latakia-Syria by the sea",90);
            apartments[4] = new Apartment(5L,"5-th",55000000,"latakia-Syria kasab",150);
            apartments[5] = new Apartment(6L,"6-th",39000000,"latakia-Syria jableh city",43);
            apartments[6] = new Apartment(7L,"7-th",25000000,"latakia-Syria thawra",39);
            apartments[7] = new Apartment(8L,"8-th",46000000,"latakia-Syria haroon",41);
            apartments[8] = new Apartment(9L,"9-th",30000000,"latakia-Syria ",59);
            int imad = 1;
             for(int k=1;k<9;k++){
                for (int i=1;i<5;i++){
                try {

                    File file = new File("D:\\img\\"+k+""+i+".jpg");
                    FileInputStream fileInputStreamReader = new FileInputStream(file);
                       // dataa = encodeFileToBase64Binary(new File(file);
                    byte[] bytes = new byte[(int)file.length()];
                    fileInputStreamReader.read(bytes);
                    Byte[] image = new Byte[bytes.length];
                    int j=0;
                    for(byte b:bytes)image[j++]=b;
                    //System.out.println(dataa+" "+ dataa.length());
                    System.out.println("\t"+imad++);
                    apartments[k-1].getImages().add(new Images(Long.parseLong(""+k+""+i),apartments[k-1],image));

                    } catch (Exception e) {
//                        e.printStackTrace();
//                    apartmentService.save(apartments[k-1]);
                    }}apartmentService.save(apartments[k-1]);}

//            apartmentService.save(apartment);
//            apartmentService.save(apartment1);
//            apartmentService.save(apartment2);
//            apartmentService.save(apartment3);
//            apartmentService.save(apartment4);
//            apartmentService.save(apartment5);
//            apartmentService.save(apartment6);
//            apartmentService.save(apartment7);
//            apartmentService.save(apartment8);
        }

        List<Apartment> list = apartmentService.findByPriceGreaterThan(50000000);
        for (Apartment apartment9 : list)
            System.out.println(apartment9.toString());

    }


}
