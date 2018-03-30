package com.alten.vehicle;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.alten.vehicle.model.Vehicle;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs(outputDir = "target/snippets")
public class VehicleServiceApplicationTests {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void testCreateVehicle() throws Exception {
		String id = "V-Test-1D-123";
		String registrationNo= "V-Test-REG-1";
		Vehicle vehicle = new Vehicle(id, registrationNo);
		
		mockMvc.perform(post("/vehicle")
		.contentType(MediaType.APPLICATION_JSON)
        .content(new ObjectMapper().writeValueAsString(vehicle)))
		.andDo(print())
		.andExpect(status().isOk())
		.andExpect(content().string(id))
		.andDo(document("Vehicle"));
	
	}

}
