package org.wecancodeit.myfavoriteproducers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;


@Controller
public class ProducerController {

    @Resource
    private ProducerRepository producerRepo;

    @RequestMapping("/producers")
    public String findAllProducers(Model model){
        model.addAttribute("producersModel", producerRepo.findAll());
        return "producersTemplate";
    }

}

