package com.TrainList.train.controllers;

import com.TrainList.train.models.Train;
import com.TrainList.train.repositories.TrainRepository;
import com.TrainList.train.service.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class TrainController {

    @Autowired
    private TrainRepository trainRepository;
    @Autowired
    private TrainService trainService;

   @GetMapping ("/train/list")
    public String trainMain (Model model){
        Iterable<Train> trains = trainRepository.findAll();
        model.addAttribute("trains",trains);
        model.addAttribute("title","Список поездов");
        return "train-list";
    }

    @GetMapping ("/train/add")
    public String trainAdd (Model model) {
        model.addAttribute("title","Добавление поезда");
        return "train-add";
    }

    @PostMapping("/train/add")
    public String trainPostAdd(@RequestParam("trains_name") String trains_name,
                               @RequestParam ("send_from")String send_from,@RequestParam("place_to_send") String place_to_send,
                               @RequestParam("time_to_send") String time_to_send,@RequestParam("count_site_places") Integer count_site_places,
                               @RequestParam ("price")String price ,
                               Model model){
        trainService.saveTrainToDB(trains_name,send_from,place_to_send,time_to_send,count_site_places,price);
        return "redirect:/train/add";
    }



    @GetMapping("/buy/ticket/{id}")
    public String findById(@PathVariable(value = "id") Long id, Model model) {
        Optional<Train> trainId = trainRepository.findById(id);
        ArrayList<Train> res = new ArrayList<>();
        trainId.ifPresent(res::add);
        res.get(0).setCount_site_places(res.get(0).getCount_site_places() - 1 );
        trainRepository.save(res.get(0));
        model.addAttribute("trainId",res);
        return "buy-ticket";

    }

}