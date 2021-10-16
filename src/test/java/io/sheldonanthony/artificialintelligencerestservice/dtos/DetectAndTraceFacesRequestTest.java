package io.sheldonanthony.artificialintelligencerestservice.dtos;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

public class DetectAndTraceFacesRequestTest{
	
	private DetectAndTraceFacesRequest detectAndTraceFacesRequest;
	
	@Before
    public void setUp(){
		detectAndTraceFacesRequest = new DetectAndTraceFacesRequest();
	}
	
	@Test
	public void testNull(){
		assertNotNull(detectAndTraceFacesRequest);
	}
	
	@Test
	public void testDetectAndTraceFacesRequest() {
		detectAndTraceFacesRequest = new DetectAndTraceFacesRequest(null, null);
		assertNotNull(detectAndTraceFacesRequest);
	}
}
