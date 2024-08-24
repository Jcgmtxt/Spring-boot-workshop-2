package com.Riwi.workshop.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //El requerimiento dice String sin embargo solo se crea la base de datos is es Integer
    private Integer id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name = "date",nullable = false)
    private LocalDate date;

    @Column(name = "location",nullable = false)
    private String location;

    @Column(name = "capacity",nullable = false)
    private int capacity;

    public Event(){

    }

    public Event(Integer id, String name, LocalDate date, String location, int capacity) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.location = location;
        this.capacity = capacity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
