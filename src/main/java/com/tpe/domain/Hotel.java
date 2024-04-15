package com.tpe.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "t_hotel")
public class Hotel {

    @Id//primary key
    private Long id;

    @Column(nullable = false)
    private  String name;

    @Column(nullable = false)
    private String location;

    //todo : one-to-many !!!
    private List<Room> rooms = new ArrayList<>();



    //paramsiz const -->  hibernate data cekerken(fetch) default const kullanir
    public Hotel() {
    }


    //param const
    public Hotel(Long id, String name, String location) {
        this.id = id;
        this.name = name;
        this.location = location;
    }



    // getter-setter
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }


    //toString
    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                ", rooms=" + rooms +
                '}';
    }
}
