package com.tpe.service;

import com.tpe.domain.Hotel;
import com.tpe.domain.Room;
import com.tpe.repository.RoomRepository;

import java.util.List;
import java.util.Scanner;

//servceler servicelerle iletisime gecer veya kendi repolariyla iletisime gecer
public class RoomService {

    private Scanner scanner=new Scanner(System.in);

    private final HotelService hotelService;

    private final RoomRepository roomRepository;

    //param const
    public RoomService(HotelService hotelService, RoomRepository roomRepository) {
        this.hotelService = hotelService;
        this.roomRepository = roomRepository;
    }


    //4-b
    public void saveRoom() {

        Room room = new Room();

        System.out.println("Enter room ID : ");
        room.setId(scanner.nextLong());
        scanner.nextLine();

        System.out.println("Enter room number : ");
        room.setNumber(scanner.nextLine());

        System.out.println("Enter room capacity : ");
        room.setCapacity(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Enter hotel ID : ");
        Long hotelId= scanner.nextLong();
        scanner.nextLine();

        //girilen id hangi otele ait
        Hotel foundHotel=hotelService.findHotelById(hotelId);

        if(foundHotel!=null) {

            room.setHotel(foundHotel);// oda hangi otele aitse set edildi.
            //t_room tablosunda hotel_id sutununa bulunan hotelin id sini ekler

            //bu odayi otelin oda listesine ekliyoruz
            //foundHotel.getRooms().add(room); --> mappedBy bu islemi bizim yerimize yapiyor.
            foundHotel.getRooms().add(room);

            roomRepository.save(room);//tabloya eklendi

            System.out.println("Room is saved succesfully. Room id : " + room.getId());

        }else {
            System.out.println("Room could not saved");
        }


    }

    //5-b : id si verilen odayi tablodan bulup yazdirma ve geri dondurme
    public Room findRoomById(Long roomId) {
        return null;
    }

    //6-b : eger tablo bos degilse tum odalari listeleme
    public void getAllRooms() {
        List<Room> rooms = roomRepository.findAll();
        if (!rooms.isEmpty()) {
            for (Room room : rooms) {
                System.out.println(room);
            }
        } else {
            System.out.println("No rooms found!");
        }
    }

    public void deleteRoomById(Long id) {
        Room existingRoom =findRoomById(id);
        if (existingRoom != null) {
            roomRepository.delete(existingRoom);
            System.out.println("Room  deleted successfully. ID: " + id);
        }


    }
}
