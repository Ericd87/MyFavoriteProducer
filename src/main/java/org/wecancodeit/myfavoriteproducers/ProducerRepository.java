package org.wecancodeit.myfavoriteproducers;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ProducerRepository {

    Map<Long, Producer> producerList = new HashMap<>();

    public ProducerRepository(){
        Producer Pharrell = new Producer(1L, "Pharrell Williams", "Music Producer, Singer,Song Writer, Film Producer", "13", "20 songs on Billboard 100");
        Producer Timbaland = new Producer(2L, " Timbaland", "Music Producer, Dj,Song Writer, Rapper, Record Executive", "4", "19 songs on Billboard 100");
        Producer MannieFresh = new Producer(3L, "Mannie Fresh", "Dj, Music Producer, Recording Engineer, Song Writer, Rapper", "0", "6 songs on Billboard 100");
        Producer Southside = new Producer(4L, "Southside", "Music Producer, Rapper, Beat Maker", "0", "5 songs on Billboard 100");


        producerList.put(Pharrell.getId(), Pharrell);
        producerList.put(Timbaland.getId(), Timbaland);
        producerList.put(MannieFresh.getId(), MannieFresh);
        producerList.put(Southside.getId(), Southside);

    }

    public ProducerRepository(Producer ...producersToAdd){
            for(Producer producer: producersToAdd){
                producerList.put(producer.getId(), producer);

        }
     }
     public Producer findOne(Long id){ return producerList.get(id); }

     public Collection<Producer> findAll(){ return producerList.values(); }


}
