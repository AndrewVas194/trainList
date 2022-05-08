package com.TrainList.train.models;

import javax.persistence.*;

@Entity
public class Train {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String trains_name;
    private String send_from;
    private String place_to_send;
    private String time_to_send;
    private Integer count_site_places;
    private String price;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTrains_name() { return trains_name; }
    public void setTrains_name(String trains_name) { this.trains_name = trains_name; }

    public String getSend_from() { return send_from; }
    public void setSend_from(String send_from) { this.send_from = send_from; }

    public String getPlace_to_send() { return place_to_send; }
    public void setPlace_to_send(String place_to_send) { this.place_to_send = place_to_send; }

    public String getTime_to_send() { return time_to_send; }
    public void setTime_to_send(String time_to_send) { this.time_to_send = time_to_send; }

    public Integer getCount_site_places() { return count_site_places; }
    public void setCount_site_places(Integer count_site_places) { this.count_site_places = count_site_places; }

    public String getPrice() { return price; }
    public void setPrice(String price) { this.price = price; }


    public Train() {
    }

    public Train(String trains_name, String send_from, String place_to_send,
                 String time_to_send, Integer count_site_places, String price) {

        this.trains_name = trains_name;
        this.send_from = send_from;
        this.place_to_send = place_to_send;
        this.time_to_send = time_to_send;
        this.count_site_places = count_site_places;
        this.price = price;
    }
}

