package io.sheldonanthony.artificialintelligencerestservice.service;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Base64;

import javax.imageio.ImageIO;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.imgcodecs.Imgcodecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import io.sheldonanthony.artificialintelligencerestservice.computervision.ComputerVisionController;
import io.sheldonanthony.artificialintelligencerestservice.dtos.DetectAndTraceFacesRequest;
import io.sheldonanthony.artificialintelligencerestservice.dtos.DetectAndTraceFacesResponse;
import io.sheldonanthony.artificialintelligencerestservice.dtos.DetectFacesRequest;
import io.sheldonanthony.artificialintelligencerestservice.dtos.DetectFacesResponse;
import io.sheldonanthony.artificialintelligencerestservice.dtos.DetectIfFacesAreWearingMasksRequest;
import io.sheldonanthony.artificialintelligencerestservice.dtos.DetectIfFacesAreWearingMasksResponse;
import io.sheldonanthony.artificialintelligencerestservice.dtos.Ping;

@Service("artificialintelligenceservice")
public class ArtificialIntelligenceServiceImpl implements ArtificialIntelligenceServiceIF{
	
	@Autowired
	@Qualifier("computerVisionController")
	private ComputerVisionController computerVisionController;

	@Override
	public Ping ping(){
		Ping ping = new Ping();
		ping.setAlive(true);
		return ping;
	}

	@Override
	public DetectFacesResponse detectFaces(DetectFacesRequest detectFacesRequest){
		
		Mat matImage = null;
		
		boolean hasDetected = false;
		
		DetectFacesResponse detectFacesResponse = new DetectFacesResponse();
		
		try{
			matImage = computerVisionController.convertBase64ToByteArray(detectFacesRequest.getBase64EncodedImage());
			hasDetected = computerVisionController.detectFaces(matImage);
			detectFacesResponse.setDetectedFaces(hasDetected);
		}
		catch (RuntimeException runtimeException) {
			throw runtimeException;
		}
		
		return detectFacesResponse;
	}

	@Override
	public DetectAndTraceFacesResponse detectAndTraceFaces(DetectAndTraceFacesRequest 
			detectAndTraceFacesRequest){
		
		Mat matImage = null;
		
		DetectAndTraceFacesResponse detectAndTraceFacesResponse = new DetectAndTraceFacesResponse();
		
		BufferedImage bi = null;  
		
		try{
			matImage = computerVisionController.convertBase64ToByteArray(detectAndTraceFacesRequest.getBase64EncodedImage());
			Mat tracedImage = computerVisionController.detectAndTraceFaces(matImage);
			MatOfByte mob=new MatOfByte();
			Imgcodecs.imencode(".png", tracedImage, mob);
			byte ba[]=mob.toArray();
			bi = ImageIO.read(new ByteArrayInputStream(ba));
			detectAndTraceFacesResponse.setBase64EncodedImage(imgToBase64String(bi, "png"));
		}
		catch (RuntimeException runtimeException) {
			throw runtimeException;
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return detectAndTraceFacesResponse;
	}

	public static String imgToBase64String(final RenderedImage img, final String formatName)
	{
	  final ByteArrayOutputStream os = new ByteArrayOutputStream();
	
	  try
	  {
	    ImageIO.write(img, formatName, os);
	    return Base64.getEncoder().encodeToString(os.toByteArray());
	  }
	  catch (final IOException ioe)
	  {
	    throw new UncheckedIOException(ioe);
	  }
	}

	@Override
	public DetectIfFacesAreWearingMasksResponse detectIfFaceWearingMask(
			DetectIfFacesAreWearingMasksRequest detectIfFacesAreWearingMasksRequest){
		DetectIfFacesAreWearingMasksResponse detectIfFacesAreWearingMasksResponse = 
				new DetectIfFacesAreWearingMasksResponse();
		detectIfFacesAreWearingMasksResponse.setWearingMask(true);
		return detectIfFacesAreWearingMasksResponse;
	}
	
}
