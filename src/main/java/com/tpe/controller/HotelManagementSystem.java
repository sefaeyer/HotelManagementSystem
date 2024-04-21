package com.tpe.controller;

import com.tpe.config.HibernateUtils;
import com.tpe.repository.GuestRepository;
import com.tpe.repository.HotelRepository;
import com.tpe.repository.ReservationRepository;
import com.tpe.repository.RoomRepository;
import com.tpe.service.GuestService;
import com.tpe.service.HotelService;
import com.tpe.service.ReservationService;
import com.tpe.service.RoomService;

import java.util.Scanner;

public class HotelManagementSystem {

    private static Scanner scanner = new Scanner(System.in);

    //Ana menu
    public static void displayHotelManagementSystemMenu(){

        HotelRepository hotelRepository = new HotelRepository();
        HotelService hotelService = new HotelService(hotelRepository);

        RoomRepository roomRepository=new RoomRepository();
        RoomService roomService=new RoomService(hotelService,roomRepository);

        GuestRepository guestRepository=new GuestRepository();
        GuestService guestService=new GuestService(guestRepository);

        ReservationRepository reservationRepository=new ReservationRepository();
        ReservationService reservationService=new ReservationService(reservationRepository,guestService,roomService);


        boolean exit=false;


        while (!exit){
            System.out.println("========= Hotel MAnagement System =========");
            System.out.println("1.Hotel Operations");
            System.out.println("2.Room Operations");
            System.out.println("3.Guest Operations");
            System.out.println("4.Reservation Operations");
            System.out.println("0. Exit");
            System.out.println("Enter your choice : ");

            int choice= scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    displayHotelOperationsMenu(hotelService);
                    break;
                case 2:
                    displayRoomOperationsMenu(roomService);
                    break;
                case 3:
                    displayGuestOperationsMenu(guestService);
                    break;
                case 4:
                    displayReservationOperationsMenu(reservationService);
                    break;
                case 0:
                    exit=true;
                    System.out.println("Good Bye...");
                    HibernateUtils.shutDown();
                    break;
                default:
                    System.out.println("Invalid choice, please try again ");
                    break;
            }

        }
    }

    //hotel operations
    private static void displayHotelOperationsMenu(HotelService hotelService) {

        System.out.println("Hotel Operation Menu");

        boolean exit = false;
        while (!exit) {
            System.out.println("==== Hotel Operations ====");
            System.out.println("1. Add a new hotel");
            System.out.println("2. Find Hotel By ID");
            System.out.println("3. Delete Hotel By ID");
            System.out.println("4. Find All Hotels");
            System.out.println("5. Update Hotel By ID");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    //1-a save hotel
                    hotelService.saveHotel();
                    break;
                case 2:
                    //2-a: hotel bulma
                    System.out.println("Enter hotel ID : ");
                    Long id = scanner.nextLong();
                    scanner.nextLine();

                    hotelService.findHotelById(id);
                    break;
                case 3:
                    //7-a: hotel silme
                    System.out.println("Enter hotel ID : ");
                    Long hotelid = scanner.nextLong();
                    scanner.nextLine();

                    hotelService.deleteHotel(hotelid);
                    break;
                case 4:
                    //3-a: tum otelleri listeleme
                    hotelService.getAllHotels();

                    break;
                case 5:
                    //8-a hotel guncelleme
                    System.out.println("Enter hotel ID : ");
                    Long updatedHotelId = scanner.nextLong();
                    scanner.nextLine();

                    hotelService.updateHotelById(updatedHotelId);

                    break;
                case 0:
                    exit = true;
                    System.out.println("Returning to Main Menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

    }

    //room operations
    private static void displayRoomOperationsMenu(RoomService roomService) {

        //new RoomService();


        System.out.println("Room Operation Menu");
        boolean exit = false;
        while (!exit) {
            System.out.println("==== Room Operations ====");
            System.out.println("1. Add a new room");
            System.out.println("2. Find Room By ID");
            System.out.println("3. Delete Room By ID");
            System.out.println("4. Find All Rooms");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    //4-a : oda ekleme
                    roomService.saveRoom();

                    break;
                case 2:
                    //5-a
                    System.out.println("Enter room ID : ");
                    Long roomId = scanner.nextLong();
                    scanner.nextLine();

                    roomService.findRoomById(roomId);
                    break;
                case 3:
                    //odev1:delete
                    System.out.println("Enter room ID : ");
                    Long roomid = scanner.nextLong();
                    scanner.nextLine();

                    roomService.deleteRoomById(roomid);

                    break;
                case 4:
                    //6-a
                    roomService.getAllRooms();

                    break;
                case 0:
                    exit = true;
                    System.out.println("Returning to Main Menu...");

                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

    }

    //guest operations
    private static void displayGuestOperationsMenu(GuestService guestService) {
        System.out.println("Guest Operation Menu");

        boolean exit = false;
        while (!exit) {
            System.out.println("==== Guest Operations ====");
            System.out.println("1. Add a new guest");
            System.out.println("2. Find Guest By ID");
            System.out.println("3. Delete Guest By ID");
            System.out.println("4. Find All Guests");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    //9-a guest kaydetme
                    guestService.saveGuest();

                    break;
                case 2:
                    //odev: find
                    System.out.println("Enter the Guest ID : ");
                    Long guestId = scanner.nextLong();
                    scanner.nextLine();

                    guestService.findGuestById(guestId);

                    break;
                case 3:
                    //10-a:  guest silme
                    System.out.println("Enter the Guest ID : ");
                    Long id = scanner.nextLong();
                    scanner.nextLine();

                    guestService.deleteGuestById(id);


                    break;
                case 4:
                    //ödev3:allguest
                    guestService.findAllGuest();


                    break;
                case 0:
                    exit = true;
                    System.out.println("Returning to Main Menu...");
                    break;
                default:

                    break;
            }
        }
    }

    //reservation operations
    private static void displayReservationOperationsMenu(ReservationService reservationService) {
        System.out.println("Reservation Operation Menu");

        boolean exit = false;
        while (!exit) {
            System.out.println("==== Reservation Operations ====");
            System.out.println("1. Add a new reservation");
            System.out.println("2. Find Reservation By ID");
            System.out.println("3. Find All Reservations");
            System.out.println("4. Delete Reservation By ID");
            System.out.println("0. Return to Main Menu");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    //11-a reservation olusturma
                    reservationService.createReservation();

                    break;
                case 2:
                    //odev4 : find
                    System.out.println("Enter the Reservation ID : ");
                    Long reservationId = scanner.nextLong();
                    scanner.nextLine();

                    reservationService.findReservationById(reservationId);

                    break;
                case 3:
                    //ödev5:all
                    reservationService.findAllReservations();

                    break;
                case 4:
                    //12-a : reservation iptal
                    System.out.println("Enter the Reservation ID : ");
                    Long id = scanner.nextLong();
                    scanner.nextLine();

                    reservationService.deleteReservationById(id);

                    break;
                case 0:
                    exit = true;
                    System.out.println("Returning to Main Menu...");

                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }


    }




}
