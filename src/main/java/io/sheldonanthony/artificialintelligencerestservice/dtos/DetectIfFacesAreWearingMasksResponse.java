package io.sheldonanthony.artificialintelligencerestservice.dtos;

import org.apache.commons.lang3.builder.ToStringBuilder;

public final class DetectIfFacesAreWearingMasksResponse {

	private boolean wearingMask;
	
	public DetectIfFacesAreWearingMasksResponse(){
	}
	
	public DetectIfFacesAreWearingMasksResponse(boolean wearingMask) {
		super();
		this.wearingMask = wearingMask;
	}

	public boolean isWearingMask() {
		return wearingMask;
	}

	public void setWearingMask(boolean wearingMask) {
		this.wearingMask = wearingMask;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
	
}
