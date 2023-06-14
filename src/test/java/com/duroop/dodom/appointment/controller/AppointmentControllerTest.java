package com.duroop.dodom.appointment.controller;

import com.duroop.dodom.domain.appointment.dto.AppointmentDto;
import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//@WebMvcTest(AppointmentControllerTest.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AppointmentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private Gson gson;

    @Test
    @DisplayName("예약 테스트")
    //@WithMockUser(username = "테스트_최고관리자", roles = {"SUPER"})
    void postAppointmentTest() throws Exception {

        //Given
        LocalDateTime d = LocalDateTime.parse("2023-06-09T23:59:59");
        AppointmentDto.Post post = AppointmentDto.Post.builder()
                .email("user1@gmail.com")
                .date(d)
                .inquiry("잘 부탁드립니다.")
                .method("call")
                .counselorId(1L).build();

        String content = gson.toJson(post);

        //When
        ResultActions actions =
                mockMvc.perform(
                        post("/appointments")
                                .accept(MediaType.APPLICATION_JSON)
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(content)
                                .with(csrf())

                );

        // then
        actions
                .andExpect(status().isCreated())
                .andExpect(header().string("Location", is(startsWith("/appointments"))));  // (9)
    }

}
