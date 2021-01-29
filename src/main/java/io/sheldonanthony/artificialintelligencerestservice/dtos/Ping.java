package io.sheldonanthony.artificialintelligencerestservice.dtos;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Ping {
	
	private boolean isAlive;
	
	public Ping(){
	}
	
	public Ping(boolean isAlive) {
		super();
		this.isAlive = isAlive;
	}
	
	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
