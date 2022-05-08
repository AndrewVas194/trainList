package com.TrainList.train.service;


import com.TrainList.train.models.Train;
import com.TrainList.train.repositories.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TrainService {
    @Autowired
    private TrainRepository trainRepository;


    public void saveTrainToDB( String trains_name, String send_from, String place_to_send,
                                String time_to_send, Integer count_site_places, String price)
    {
        Train train=new Train();
        /*train.setId(id);*/
        train.setTrains_name(trains_name);
        train.setSend_from(send_from);
        train.setPlace_to_send(place_to_send);
        train.setTime_to_send(time_to_send);
        train.setCount_site_places(count_site_places);
        train.setPrice(price);
        trainRepository.save(train);

    }


}
