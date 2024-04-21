package com.tpe.domain;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_guest")
public class Guest {

    @Id//pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private LocalDateTime createdDate;

    @OneToMany(mappedBy = "guest",orphanRemoval = true)
    private List<Reservation> reservations =new ArrayList<>();

    @Embedded
    private Address address;

    @PrePersist//persist esnasinda calistir
    public void prePersist(){
        this.createdDate=LocalDateTime.now();
    }


    //getter setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

//    public void setCreatedDate(LocalDateTime createdDate) {
//        this.createdDate = createdDate;
//    }

    public List<Reservation> getReservations() {
        return reservations;
    }

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    //toString
    @Override
    public String toString() {
        return "Guest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdDate=" + createdDate +
                ", address=" + address +
                '}';
    }
}
