package io.sheldonanthony.artificialintelligencerestservice.dtos;

import org.apache.commons.lang3.builder.ToStringBuilder;

public final class DetectIfFacesAreWearingMasksRequest {
	
	private String uuid;
	
	private String base64EncodedImage; 
	
	public DetectIfFacesAreWearingMasksRequest(){
	}
	

	public DetectIfFacesAreWearingMasksRequest(String uuid, String base64EncodedImage) {
		super();
		this.uuid = uuid;
		this.base64EncodedImage = base64EncodedImage;
	}



	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getBase64EncodedImage() {
		return base64EncodedImage;
	}

	public void setBase64EncodedImage(String base64EncodedImage) {
		this.base64EncodedImage = base64EncodedImage;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
