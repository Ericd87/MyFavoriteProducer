package org.wecancodeit.myfavoriteproducers;

import org.junit.jupiter.api.Test;

import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class ProducerRepositoryTest {

    private ProducerRepository producerTest;
    private Producer producerPharrell = new Producer(1L, "producer Pharrell Williams", "Music Producer, Singer,Song Writer, Film Producer", "13", "20 songs on Billboard 100");
    private Producer producerTimbaland = new Producer(2L, "producer Timbaland", "Music Producer, Dj,Song Writer, Rapper, Record Executive", "4", "19 songs on Billboard 100");
    private Producer producerMannieFresh = new Producer(3L, "Mannie Fresh", "Dj, Music Producer, Recording Engineer, Song Writer, Rapper", "0", "6 songs on Billboard 100");
    private Producer producerSouthside = new Producer(4L, "Southside", "Music Producer, Rapper, Beat Maker", "0", "5 songs on Billboard 100");

    @Test
    public void shouldFindProducerOne() {
        Producer producerPharrell = new Producer(1L, "producer Pharrell Williams", "Music Producer, Singer,Song Writer, Film Producer", "13", "20 song on Billboard 100");
        producerTest = new ProducerRepository(producerPharrell);
        Producer foundProducer = producerTest.findOne(1L);
        assertEquals(foundProducer, producerPharrell);

    }

    @Test
    public void shouldFindProducerOneAndProducerTwo() {
        Producer producerPharrell = new Producer(1L, "producer Pharrell Williams", "Music Producer, Singer,Song Writer, Film Producer", "13", "20 song on Billboard 100");
        Producer producerTimbaland = new Producer(2L, "producer Timberland", "Music Producer, Dj,Song Writer, Rapper, Record Executive", "4", "19 song on Billboard 100");
        producerTest = new ProducerRepository(producerPharrell, producerTimbaland);
        Collection<Producer> foundProducers = producerTest.findAll();
        assertThat(foundProducers).contains(producerPharrell, producerTimbaland);

    }




}
