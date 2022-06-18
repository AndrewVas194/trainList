package com.TrainList.train.service;


import com.TrainList.train.models.Train;
import com.TrainList.train.repositories.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TrainService {
    @Autowired
    private TrainRepository trainRepository;


    public void saveTrainToDB( String trainsName, String sendfrom, String tosend,
                                String time_to_send, Integer count_site_places, String price)
    {
        Train train=new Train();
        /*train.setId(id);*/
        train.setTrainsName(trainsName);
        train.setSendfrom(sendfrom);
        train.setTosend(tosend);
        train.setTime_to_send(time_to_send);
        train.setCount_site_places(count_site_places);
        train.setPrice(price);
        trainRepository.save(train);
    }
}
