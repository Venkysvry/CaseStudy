package com.cropfield.project;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.cropfield.project.Model.Crop;
import com.cropfield.project.repositories.CropRepository;
import com.cropfield.project.service.CropServiceImpl;
import com.cropfield.project.service.SequenceGeneratorService;


@SpringBootTest
public class CropfieldService {
	
//	@Autowired
//	private MockMvc mockMvc;
//	
//	private Crop crop;
//	private List<Crop> cropList;
//	
	@Autowired
	private CropServiceImpl cropServiceImpl;
	@MockBean
	CropRepository cropRepository;
	@Mock
	SequenceGeneratorService generatorService;
	
//	@Test
//	void addCrop() {
//		Crop crop = new Crop( 101,"fruit","banana","1000","hyderabad","10000","this is banana","7780796045","101");
//		when(cropRepository.insert(crop)).thenReturn(crop);
//		Crop crop1=cropServiceImpl.addCrop(crop);
//		assertEquals(crop.getCropId(),crop1.getCropId());
//	}
	
	@Test
	 void viewAllCrop() {
		when(cropRepository.findAll()).thenReturn(Stream.of(
				new Crop( 101, "fruit", "banana", "1000", "hyderabad", "10000","this is banana", "7780796045","101"),
						
				new Crop( 102, "fruit", "banana", "1000", "hyderabad", "10000","this is banana", "7780796045","101"))
				.collect(Collectors.toList()));
				assertEquals(2,cropServiceImpl.getAllCropDetails().size());
	}
	

	
	@Test
	void testgetCropbyId() { //pass
		
		Crop crop = new Crop();
		crop.setCropId(101);
		crop.setCropType("fruit");
		crop.setCropName("apple");
		crop.setQuantity("10kg");
		crop.setLocationName("mandrup");
		crop.setCropPrice("1000");
		crop.setDescription("this is fruit");
        crop.setContact("7780796045");	
        crop.setfId("102");
		when(cropRepository.findByCropId(101)).thenReturn(crop);
		Crop crops = cropServiceImpl.getCropbyId(101);
		assertEquals(101, crops.getCropId());
	}
	
	@Test
	void testgetCropbyType(){
		
		when(cropRepository.findByCropType("Fruit")).thenReturn(Stream.of(
				new Crop( 101, "fruit", "banana", "1000", "hyderabad", "10000","this is banana", "7780796045","101"),
				
				new Crop( 102, "fruit", "banana", "1000", "hyderabad", "10000","this is banana", "7780796045","101"))
				.collect(Collectors.toList()));
		assertEquals(2, cropServiceImpl.getCropbyType("Fruit").size());
	}
	
	@Test
	void testgetbyCropName()  { //red

		when(cropRepository.findByCropName("banana")).thenReturn(Stream.of(
				new Crop( 101, "fruit", "banana", "1000", "hyderabad", "10000","this is banana", "7780796045","101"),
				
				new Crop( 102, "fruit", "banana", "1000", "hyderabad", "10000","this is banana", "7780796045","101"))
				.collect(Collectors.toList()));
		assertEquals(2, cropServiceImpl.getbyCropName("banana").size());
	
	}
	
	@Test
	void testdeleteCrop() { //pass

		Crop crop = new Crop();
		crop.setCropId(101);
		crop.setCropType("fruit");
		crop.setCropName("apple");
		crop.setQuantity("10kg");
		crop.setLocationName("mandrup");
		crop.setCropPrice("1000");
		crop.setDescription("this is fruit");
        crop.setContact("7780796045");	
        crop.setfId("102");
		
		when(cropRepository.findByCropId(101)).thenReturn(crop);
		cropServiceImpl.deleteCrop(101);
	}
	
	@Test
	void testUpdateCrop() {
		Crop crop = new Crop();
		crop.setCropId(101);
		crop.setCropType("fruit");
		crop.setCropName("apple");
		crop.setQuantity("10kg");
		crop.setLocationName("mandrup");
		crop.setCropPrice("1000");
		crop.setDescription("this is fruit");
        crop.setContact("7780796045");	
        crop.setfId("102");
		
		when(cropRepository.save(crop)).thenReturn(crop);
		assertEquals("mandrup",crop.getLocationName());
	}
	

}
