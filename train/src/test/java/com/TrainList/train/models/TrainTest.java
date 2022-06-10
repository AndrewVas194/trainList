package com.TrainList.train.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrainTest {

    Train train;

    @BeforeEach
    public void createTrain(){
        train = new Train("Train123","Grodno","Berlin","2022-05-12T23:55",16,"35");
    }

    @Test
    void getTrainsName() {
        assertEquals("Train123",train.getTrainsName());
    }

    @Test
    void setTrainsName() {
        train.setTrainsName("Train3333");
        assertEquals("Train3333",train.getTrainsName());
    }

    @Test
    void getSendfrom() {
        assertEquals("Grodno",train.getSendfrom());
    }

    @Test
    void setSendfrom() {
        train.setSendfrom("Brest");
        assertEquals("Brest",train.getSendfrom());
    }

    @Test
    void getTosend() {
        assertEquals("Berlin",train.getTosend());
    }

    @Test
    void setTosend() {
        train.setTosend("Vilnus");
        assertEquals("Vilnus",train.getTosend());
    }

    @Test
    void getTime_to_send() {
        assertEquals("2022-05-12T23:55",train.getTime_to_send());
    }

    @Test
    void setTime_to_send() {
        train.setTime_to_send("2022-07-06T12:00");
        assertEquals("2022-07-06T12:00",train.getTime_to_send());
    }

    @Test
    void getCount_site_places() {
        assertEquals(16,train.getCount_site_places());
    }

    @Test
    void setCount_site_places() {
        train.setCount_site_places(77);
        assertEquals(77,train.getCount_site_places());
    }

    @Test
    void getPrice() {
        assertEquals("35",train.getPrice());
    }

    @Test
    void setPrice() {
        train.setPrice("17");
        assertEquals("17",train.getPrice());
    }
}