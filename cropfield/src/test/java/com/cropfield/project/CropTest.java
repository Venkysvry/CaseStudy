package com.cropfield.project;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cropfield.project.Model.Crop;

@SpringBootTest
public class CropTest {
	private Crop crop;
	
	@Test
	public void SetCropNameTest() {
Crop c=new Crop();
c.setCropName("banana");
assertEquals(c.getCropName(), "banana");
}

}
