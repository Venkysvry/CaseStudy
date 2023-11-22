package com.cropfield.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cropfield.project.Model.Crop;
import com.cropfield.project.Model.CropDto;
import com.cropfield.project.Model.Receipt;

@Service
public interface CropService {
	Crop addCrop(Crop crop);

	

	 List<Crop> getAllCropDetails();

	 Crop getCropbyId(int id);

	String deleteCrop(int id);
	
	 List<Crop> getCropbyType(String croptype);
	 List<Crop> getbyCropName(String name);
	Receipt receipt(Receipt r);
	List<Receipt> viewReceipts();
    List<Crop> cropByFId(String id);

   String UpdateCrop(int cropId, CropDto cropdto);
}
