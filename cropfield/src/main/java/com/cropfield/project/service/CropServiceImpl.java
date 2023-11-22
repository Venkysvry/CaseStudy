package com.cropfield.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.cropfield.project.Model.Crop;
import com.cropfield.project.Model.CropDto;
import com.cropfield.project.Model.Receipt;
import com.cropfield.project.exceptions.EmptyListException;
import com.cropfield.project.repositories.CropRepository;
import com.cropfield.project.repositories.ReceiptRepo;

@Service
public class CropServiceImpl implements CropService {
	@Autowired
	MongoOperations mongoOperations;

	@Autowired
	SequenceGeneratorService generatorService;

	@Autowired
	CropRepository crp;
	@Autowired
	ReceiptRepo receiptrepo;

	@Override
	public Crop addCrop(Crop crop) {
		crop.setCropId(generatorService.generateSequence(Crop.SEQUENCE_NAME));
		if(crop.getCropName().isEmpty()||crop.getCropType().isEmpty()
				||crop.getQuantity().isEmpty() || crop.getContact().isEmpty()||crop.getLocationName().isEmpty()
				||crop.getCropPrice().isEmpty()) throw new EmptyListException();
		crp.save(crop);

		return crop;
	}

	

	@Override
	public List<Crop> getAllCropDetails() {
		List<Crop> list = new ArrayList<Crop>();
		
		list.addAll(crp.findAll());
		if(list.isEmpty()) throw new EmptyListException();
		return list;
	}

	@Override
	public Crop getCropbyId(int id) throws  MethodArgumentTypeMismatchException   {
		if(id<0) throw new IllegalStateException();
		Crop c = crp.findByCropId(id);
		if(c==null)throw new NoSuchElementException();
		return c;
	}

	@Override
	public String deleteCrop(int id) throws MethodArgumentTypeMismatchException{
		if(id<0) throw new IllegalStateException();
		crp.deleteById(id);
		return "deleted sucessfully";
	}

	@Override
	public List<Crop> getCropbyType(String croptype) {
		List<Crop> c = crp.findByCropType(croptype);
		if(c.isEmpty()) throw new EmptyListException();
		return c;
	}

	@Override
	public List<Crop> getbyCropName(String name) {
		List<Crop> c = crp.findByCropName(name);
		if(c.isEmpty()) throw new EmptyListException();
		return c;
	}

	@Override
	public Receipt receipt(Receipt r) {
		r.setReceiptId(generatorService.generateSequence(Crop.SEQUENCE_NAME));
		receiptrepo.save(r);
		return r;
	}

	@Override
	public List<Receipt> viewReceipts() {
		receiptrepo.findAll();
		return receiptrepo.findAll();
	}

	@Override
	public List<Crop> cropByFId(String id) {
		List<Crop> c=crp.findByfId(id);
		if(c.isEmpty()) {
			throw new EmptyListException();
		}
		return c;
	}



	@Override
	public String UpdateCrop(int cropId, CropDto cropdto) {
		Crop c=crp.findByCropId(cropId);
		if(c==null) {
			throw new NoSuchElementException();}
	
		c.setCropId(cropId);
		c.setfId(cropdto.getfId());
		c.setContact(cropdto.getContact());
		c.setCropName(cropdto.getCropName());
		c.setCropType(cropdto.getCropType());
		c.setCropPrice(cropdto.getCropPrice());
		c.setDescription(cropdto.getDescription());
		c.setQuantity(cropdto.getQuantity());
		c.setLocationName(cropdto.getLocationName());
		crp.save(c);
		return "updated succesfully";
	}

}
