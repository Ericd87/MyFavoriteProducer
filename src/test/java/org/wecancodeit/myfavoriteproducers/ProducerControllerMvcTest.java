package org.wecancodeit.myfavoriteproducers;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Collection;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(ProducerController.class)
public class ProducerControllerMvcTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ProducerRepository producerRepo;

    @Mock
    private Producer producerPharrell;

    @Mock
    private Producer producerTimbaland;

    @Test
    public void shouldBeOkForAllProducersInTheProducersTemplate() throws Exception {
        mockMvc.perform(get("/producers"))
                .andExpect(status().isOk()).andExpect(view().name("producersTemplate"));
    }

    @Test
    public void shouldFindAllProducersInModel() throws Exception {
        Collection<Producer> allProducersInModel = Arrays.asList(producerPharrell, producerTimbaland);
        when(producerRepo.findAll()).thenReturn(allProducersInModel);
        mockMvc.perform(get("/producers"))
                .andExpect(model().attribute("producerModel", allProducersInModel));
    }

    @Test
    public void shouldBeOkForOneProducerInTheProducerTemplate() throws Exception {
        Long producerPharrellId = 1L;
        when(producerRepo.findOne(producerPharrellId)).thenReturn(producerPharrell);
        mockMvc.perform(get("/producer?id=1")).andExpect(status().isOk())
                .andExpect(view().name("producersTemplate"));
    }

    @Test
    public void shouldFindProducerOneInModel() throws Exception {
        Long producerPharrellId = 1L;
        when(producerRepo.findOne(producerPharrellId)).thenReturn(producerPharrell);
        mockMvc.perform(get("/producer?id=1"))
                .andExpect(model().attribute("producerModel", producerPharrell));
    }

    @Test
    public void shouldBeNotFoundRequestNotInModel() throws Exception {
        Long producerTimbalandId = 2L;
        when(producerRepo.findOne(producerTimbalandId)).thenReturn(producerTimbaland);
        mockMvc.perform(get("/producer?id=3")).andExpect(status().isNotFound());
    }

}
