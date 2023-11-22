package com.cropfield.project.Model;



import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cropdetail")
public class Crop {
	 @Transient
	public static final String SEQUENCE_NAME = "sequence";
	@Id
	private int cropId;
 
	private String cropType;
    
	private String cropName;
   
	private String quantity;
   
	private String locationName;
   
	private String cropPrice;
	private String description;
	private String contact;
    private String fId;
	

	public Crop() {

	}


	public Crop(int cropId, String cropType, String cropName, String quantity, String locationName, String cropPrice,
			String description, String contact,String id) {
		super();
		this.cropId = cropId;
		this.cropType = cropType;
		this.cropName = cropName;
		this.quantity = quantity;
		this.locationName = locationName;
		this.cropPrice = cropPrice;
		this.description = description;
		this.contact = contact;
		this.fId=id;
	}


	public static String getSequenceName() {
		return SEQUENCE_NAME;
	}


	public int getCropId() {
		return cropId;
	}


	public void setCropId(int cropId) {
		this.cropId = cropId;
	}


	public String getCropType() {
		return cropType;
	}


	public void setCropType(String cropType) {
		this.cropType = cropType;
	}


	public String getCropName() {
		return cropName;
	}


	public void setCropName(String cropName) {
		this.cropName = cropName;
	}


	public String getQuantity() {
		return quantity;
	}


	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}


	public String getLocationName() {
		return locationName;
	}


	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}


	public String getCropPrice() {
		return cropPrice;
	}


	public void setCropPrice(String cropPrice) {
		this.cropPrice = cropPrice;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getContact() {
		return contact;
	}


	public void setContact(String contact) {
		this.contact = contact;
	}


	public String getfId() {
		return fId;
	}


	public void setfId(String fId) {
		this.fId = fId;
	}


	@Override
	public String toString() {
		return "Crop [cropId=" + cropId + ", cropType=" + cropType + ", cropName=" + cropName + ", quantity=" + quantity
				+ ", locationName=" + locationName + ", cropPrice=" + cropPrice + ", description=" + description
				+ ", contact=" + contact + ", fId=" + fId + "]";
	}


	


	

	

	
}