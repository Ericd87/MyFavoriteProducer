package org.wecancodeit.myfavoriteproducers;

import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ProducerRepository {

    Map<Long, Producer> producerList = new HashMap<>();

    public ProducerRepository(){
        Producer Pharrell = new Producer(1L, "", "", "","");
        Producer Timbaland = new Producer(2L, "", "", "","");
        Producer MannieFresh = new Producer(3L, "", "", "","");
        Producer Southside = new Producer(4L, "", "", "","");

        producerList.put(Pharrell.getid(), Pharrell);
        producerList.put(Timbaland.getid(), Timbaland);
        producerList.put(MannieFresh.getid(), MannieFresh);
        producerList.put(Southside.getid(), Southside);

    }

    public ProducerRepository(Producer ...producerToAdd){
            for (Producer producer: producerToAdd){
                producerList.put(producer.getid(), producer);

        }
     }

    public Producer findOne(Long id){
            return producerList.get(id);
        }

    public Collection<Producer> findAll(){
            return producerList.values();
        }


}
