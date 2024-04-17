package com.tpe.service;

import com.tpe.domain.Hotel;
import com.tpe.exceptions.HotelNotFoundException;
import com.tpe.repository.HotelRepository;

import java.util.List;
import java.util.Scanner;

public class HotelService {

    private Scanner scanner = new Scanner(System.in);

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }
//1-c:
    public void saveHotel(){

        Hotel hotel=new Hotel();


        System.out.println("Enter hotel ID");
        hotel.setId(scanner.nextLong());
        scanner.nextLine();

        System.out.println("Enter hotel name");
        hotel.setName(scanner.nextLine());

        System.out.println("Enter hotel location");
        hotel.setLocation(scanner.nextLine());


        hotelRepository.save(hotel);

        System.out.println("Hotel is saved succesfully. Hotel ID: "+hotel.getId());

    }

    //2-c: id verilen hoteli goruntule
    public Hotel findHotelById(Long id){
        Hotel foundHotel = hotelRepository.findById(id);
        try {
            if(foundHotel!=null) {
                System.out.println("-----------------------------------------------");
                System.out.println(foundHotel);
                System.out.println("-----------------------------------------------");

                return foundHotel;
            }else{
                throw new HotelNotFoundException("Hotel not found by ID: "+id);
            }
        }catch (HotelNotFoundException e){
            System.err.println(e.getMessage());
        }
        return null;
    }

    //3-c: tum hotelleri listeleme
    public void getAllHotels(){
        List<Hotel> allHotels = hotelRepository.findAll();
        if(!allHotels.isEmpty()){
            System.out.println("------------------------- ALL HOTELS -------------------------------");
            for (Hotel hotel:allHotels){
                System.out.println(hotel);
            }
            System.out.println("--------------------------------------------------------------------");
        }else{
            System.out.println("Hotel list is empty! ");
        }
    }

}
