package org.wecancodeit.myfavoriteproducers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;


@Controller
public class ProducerController {

    @Resource
    private ProducerRepository producerRepo;

    @RequestMapping("/producers")
    public String findAllProducers(Model model, long id) throws ProducerNotFoundException {
        model.addAttribute("producersModel", producerRepo.findAll());
        return "producersTemplate";


    @RequestMapping("/producer")
    public String findOneProducer(@RequestParam(value ="id")Long id, Model model){

        if(producerRepo,findOneProducer(id)) == null){
            throw new ProducerNotFoundException();
            }

            model.addAttribute("producerModel", producerRepo.findOne(id));
            return "producerTemplate";

        }

}

    private void findOneProducer(long id) {
    }

