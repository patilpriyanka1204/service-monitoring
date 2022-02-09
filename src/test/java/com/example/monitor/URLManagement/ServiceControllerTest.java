package com.example.monitor.URLManagement;

import com.example.monitor.URLManagement.Controller.URLController;
import com.example.monitor.URLManagement.Service.MonitorService;
import org.apache.http.protocol.HTTP;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(URLController.class)
@AutoConfigureMockMvc
public class ServiceControllerTest {

    @MockBean
    private MonitorService monitorService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void createNewService() throws Exception {
        mockMvc.perform(post("/services")
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON).
                content("")).andExpect(status().isBadRequest());

    }

    @Test
    public void shouldgetAllservicesinData() throws Exception {
        mockMvc.perform(get("/services")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());


    }

    @Test
    public void shouldgetMonitoringDetails() throws Exception {
        mockMvc.perform(get("/services/monitors")
                        .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());


    }

    @Test
    public void malfuctionedURlBadRequest() throws Exception {
        mockMvc.perform(post("/services")
                .contentType(APPLICATION_JSON)
                .accept(APPLICATION_JSON).
                content("{\"name\": \"Alex\", \"url\": \"hdgfshjg\"}")).andExpect(status().isBadRequest());


    }

}
