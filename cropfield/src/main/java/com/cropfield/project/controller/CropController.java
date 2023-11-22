package com.cropfield.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cropfield.project.Model.Crop;
import com.cropfield.project.Model.CropDto;
import com.cropfield.project.Model.Receipt;
import com.cropfield.project.service.CropService;
@CrossOrigin (origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/crop")
public class CropController {
	Logger logger =LoggerFactory.getLogger(CropController.class);
	@Autowired
	public CropService cropservice;

	@PostMapping("/add")
	public ResponseEntity<Crop> add(@RequestBody Crop crop) {
		logger.info("you are inside of add controller method");
		Crop c = cropservice.addCrop(crop);
		return new ResponseEntity<Crop>(c, HttpStatus.CREATED);
	}

	@PutMapping("/update/{cropId}")
	public ResponseEntity<List<Crop>> update(@PathVariable int cropId,@RequestBody  CropDto cropdto) {
		logger.info("you are inside of update controller method");
		String s = cropservice.UpdateCrop(cropId,cropdto);
		List<Crop> list=cropservice.getAllCropDetails();
		return new ResponseEntity<List<Crop>>(list, HttpStatus.ACCEPTED);
	}

	@GetMapping("/viewAll")
	public String getAll() {
		return "viewAll";
//		logger.info("you are inside of viewAll controller method");
//		List<Crop> list = cropservice.getAllCropDetails();
//		return new ResponseEntity<List<Crop>>(list, HttpStatus.OK);
	}

	@GetMapping("/getcropbyId/{id}")
	public ResponseEntity<Crop> getById(@PathVariable int id) {
		logger.info("you are inside of getcropbyId controller method");
		Crop c = cropservice.getCropbyId(id);
		return new ResponseEntity<Crop>(c, HttpStatus.OK);
	}


	@DeleteMapping("/deletebyId/{id}")
	public ResponseEntity<List<Crop>> deleteCropbyId(@PathVariable int id) {
		logger.info("you are inside of deletebyId controller method");
		cropservice.deleteCrop(id);
		List<Crop>list=cropservice.getAllCropDetails();
		return new ResponseEntity<List<Crop>>(list, HttpStatus.OK);
	}

	@GetMapping("/getcropbytype/{type}")
	public ResponseEntity<List<Crop>> viewBytype(@PathVariable String type) {
		logger.info("you are inside of getcropbytype controller method");
		List<Crop> c = cropservice.getCropbyType(type);
		return new ResponseEntity<List<Crop>>(c, HttpStatus.OK);
	}
	@GetMapping("/getcropbyname/{name}")
	public ResponseEntity<List<Crop>> viewByname(@PathVariable String name) {
		logger.info("you are inside of getcropbyname controller method");
		List<Crop> c = cropservice.getbyCropName(name);
		return new ResponseEntity<List<Crop>>(c, HttpStatus.OK);
	}
	@PostMapping("/receipt")
	public ResponseEntity<Receipt> receipt(@RequestBody Receipt receipt){
		logger.info("you are inside of receipt controller method");
		return new ResponseEntity<Receipt>(cropservice.receipt(receipt),HttpStatus.OK);
		}
	@GetMapping("/viewReceipts")
	public ResponseEntity<List<Receipt>> viewAllReceipt(){
		logger.info("you are inside of viewreceipts controller method");
		List<Receipt> list=cropservice.viewReceipts();
		return new ResponseEntity<List<Receipt>>(list,HttpStatus.OK);
	}
	@GetMapping("/viewByFarmer/{id}")
	public ResponseEntity<List<Crop>> viewFarmer(@PathVariable String id){
		logger.info("you are inside of viewbyfarmer controller method");
		List<Crop> list=cropservice.cropByFId(id);
		return new ResponseEntity<List<Crop>>(list, HttpStatus.OK);
	}
	
}
