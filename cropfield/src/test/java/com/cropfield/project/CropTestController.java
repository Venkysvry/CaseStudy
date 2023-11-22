package com.cropfield.project;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.cropfield.project.Model.Crop;
import com.cropfield.project.Model.CropDto;
import com.cropfield.project.controller.CropController;
import com.cropfield.project.service.CropService;
import com.cropfield.project.service.SequenceGeneratorService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(MockitoExtension.class)
public class CropTestController {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private CropService cropService;
	private Crop crop;
	private List<Crop> cropList;
	private CropDto cropDto;
	
	@Autowired
	private SequenceGeneratorService generatorService;
	
	@InjectMocks
	private CropController cropController;
	
	@BeforeEach
	public void setUp() {
		crop=new Crop( 101, "Fruit", "apple", "1000", "hyderabad", "10000","this is banana", "7780796045","102");
		
		cropDto=	new CropDto("101", 101,"Fruit", "apple", "10kg","mandrup",
				"10000", "this is apple", "7780796045");
//		cropList.add(crop);
		mockMvc = MockMvcBuilders.standaloneSetup(cropController).build();
	}
	
	@Test
	void addCropTest() throws Exception {
		when(cropService.addCrop(any())).thenReturn(crop);
		mockMvc.perform(post("/crop/add")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(crop)))
				.andExpect(status().isCreated());
		verify(cropService, times(1)).addCrop(any());
		
	}
	
	@Test
	void viewAllCropTest() throws Exception{
		when(cropService.getAllCropDetails()).thenReturn(cropList);
		mockMvc.perform(MockMvcRequestBuilders.get("/crop/viewAll")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(crop)))
				.andDo(MockMvcResultHandlers.print());
				verify(cropService,times(1)).getAllCropDetails();
												
	}
	
	@Test
	void getCropByIdTest() throws Exception {		
		when(cropService.getCropbyId(crop.getCropId())).thenReturn(crop);
		mockMvc.perform(MockMvcRequestBuilders.get("/crop/getcropbyId/101")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(crop)))
				.andDo(MockMvcResultHandlers.print());
				verify(cropService,times(1)).getCropbyId(101);
	}
	
	@Test
	void getCropByTypeTest() throws Exception{
		when(cropService.getCropbyType(crop.getCropType())).thenReturn(cropList);
		System.out.println(cropList);
		mockMvc.perform(MockMvcRequestBuilders.get("/crop/getcropbytype/Fruit")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(crop)))
				.andDo(MockMvcResultHandlers.print());
				verify(cropService,times(1)).getCropbyType("Fruit");	
	}
	
	@Test
	void getCropByNameTest() throws Exception{
		when(cropService.getbyCropName(crop.getCropName())).thenReturn(cropList);
		mockMvc.perform(MockMvcRequestBuilders.get("/crop/getcropbyname/apple")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(crop)))
				.andDo(MockMvcResultHandlers.print());
				verify(cropService,times(1)).getbyCropName("apple");
	}
	
	@Test
	void getCropByUserId() throws Exception{
		when(cropService.cropByFId(crop.getfId())).thenReturn(cropList);
		mockMvc.perform(MockMvcRequestBuilders.get("/crop/viewByFarmer/102")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(crop)))
				.andDo(MockMvcResultHandlers.print());
				verify(cropService,times(1)).cropByFId("102");
	}
	
	@Test
	void updateCropTest() throws Exception{
		when(cropService.UpdateCrop(cropDto.getCropId(), cropDto)).thenReturn("updated");
		mockMvc.perform(MockMvcRequestBuilders.put("/crop/update")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(crop)))
				.andDo(MockMvcResultHandlers.print());
				verify(cropService,times(1)).UpdateCrop(cropDto.getCropId(), cropDto);
	}
	
	@Test
	void deleteCrop() throws Exception{
		cropService.deleteCrop(crop.getCropId());
		mockMvc.perform(MockMvcRequestBuilders.delete("/crop/deletebyId/101",1)
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(crop)))
				.andDo(MockMvcResultHandlers.print()).andExpect(status().isOk());
	}
	
	public static String asJsonString(final Object obj) {
		try {
			final ObjectMapper mapper = new ObjectMapper();
			final String jsonContent = mapper.writeValueAsString(obj);
			return jsonContent;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
