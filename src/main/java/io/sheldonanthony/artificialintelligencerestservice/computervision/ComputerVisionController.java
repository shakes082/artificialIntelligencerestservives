package io.sheldonanthony.artificialintelligencerestservice.computervision;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.util.Base64;
import javax.imageio.ImageIO;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfRect;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.objdetect.Objdetect;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import nu.pattern.OpenCV;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * Copyright (c) 2020, Sheldon Anthony
 * All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the Apache License, Version 2.0 only, as
 * published by the Free Software Foundation.  
 * 
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the Apache License, Version 2.0
 * for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the Apache License, Version 2.0
 * along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Sheldon Anthony, PostNet Suite 129,
 * Private Bag X 1510, Glenvista, 2058, Johannesburg, South Africa
 * or visit https://shakes082.github.io/sheldonanthonyio.github.io/
 * if you need additional information
 *  or have any questions.
 */

@Controller
public class ComputerVisionController{
	
	private static Logger LOGGER = 
			LogManager.getLogger(ComputerVisionController.class);
	
	@Value("${opencv.faceDetectorCascadeClassifier}")
	private String faceDetectorCascadeClassifier;
	
	static{
		OpenCV.loadLocally();
	}
	
	/**
	 * 
	 */
	public ComputerVisionController(){
	}
	
	/**
	 * @param base64Image
	 * @return {@link Mat}
	 */
	public Mat convertBase64ToByteArray(String base64Image) {
		if(base64Image.contains(",")) {
			String iBase64Image = base64Image.split(",")[1];
			byte[] base64ImageByte = javax.xml.bind.DatatypeConverter.parseBase64Binary(iBase64Image);
			return Imgcodecs.imdecode(new MatOfByte(base64ImageByte), Imgcodecs.IMREAD_COLOR).clone();
		}
		else {
			byte[] base64ImageByte = javax.xml.bind.DatatypeConverter.parseBase64Binary(base64Image);
			return Imgcodecs.imdecode(new MatOfByte(base64ImageByte), Imgcodecs.IMREAD_COLOR).clone();
		}
	}

	/**
	 * 
	 * @param mat
	 * @return {@link String}
	 */
	public String convertMatToBase64(Mat mat) {
		MatOfByte mob = new MatOfByte();
		Imgcodecs.imencode(".png", mat, mob);
		byte ba[] = mob.toArray();
		BufferedImage bufferedImage = null;
		String base64String = null;
		try {
			bufferedImage = ImageIO.read(new ByteArrayInputStream(ba));
			base64String = imgToBase64String(bufferedImage, "png");
		}
		catch (IOException ioException) {
			LOGGER.error(ioException.getMessage());
			throw new RuntimeException("Unable To Read As A BufferedImage");
		}
		return base64String;
	}
	
	/**
	 * @param img
	 * @param formatName
	 * @return @{link String}
	 */
	private String imgToBase64String(final RenderedImage img, final String formatName){
	  final ByteArrayOutputStream os = new ByteArrayOutputStream();	  
	  try{
	    ImageIO.write(img, formatName, os);
	    return Base64.getEncoder().encodeToString(os.toByteArray());
	  }
	  catch (final IOException ioe){
	    throw new UncheckedIOException(ioe);
	  }
	}
	
	/**
	 * @param imageMat
	 * @return @{link Boolean}
	 */
	public boolean detectFaces(Mat imageMat){
		
		CascadeClassifier faceDetector = new CascadeClassifier(faceDetectorCascadeClassifier);
		
		MatOfRect faceDetections = new MatOfRect();
		Mat grayScaledMat = new Mat();
		
		// convert the frame in gray scale
		Imgproc.cvtColor(imageMat, grayScaledMat, Imgproc.COLOR_RGB2GRAY);
		
		// equalize the frame histogram to improve the result
		Imgproc.equalizeHist(grayScaledMat, grayScaledMat);
		
		int height = grayScaledMat.rows();
		int size = 0;
		if (Math.round(height * 0.2f) > 0)
		{
			size = Math.round(height * 0.2f);
		}
		
		faceDetector.detectMultiScale(grayScaledMat, faceDetections, 1.1, 2, 0 | 
				Objdetect.CASCADE_SCALE_IMAGE, new Size(size, size), new Size());
		
		if(faceDetections.toArray().length >= 1 ) {
			return true;
		}
		else{
			return false;
		}
		
	}

	/**
	 * @param imageMat
	 * @return {@link Mat}
	 */
	public Mat detectAndTraceFaces(Mat imageMat) {
		CascadeClassifier faceDetector = new CascadeClassifier(faceDetectorCascadeClassifier);
		
		MatOfRect faceDetections = new MatOfRect();
		Mat grayScaledMat = new Mat();
		
		// convert the frame in gray scale
		Imgproc.cvtColor(imageMat, grayScaledMat, Imgproc.COLOR_RGB2GRAY);
		
		// equalize the frame histogram to improve the result
		Imgproc.equalizeHist(grayScaledMat, grayScaledMat);
		
		int height = grayScaledMat.rows();
		int size = 0;
		if (Math.round(height * 0.2f) > 0)
		{
			size = Math.round(height * 0.2f);
		}
		
		faceDetector.detectMultiScale(grayScaledMat, faceDetections, 1.1, 2, 0 | 
				Objdetect.CASCADE_SCALE_IMAGE, new Size(size, size), new Size());
		
		Rect[] facesArray = faceDetections.toArray();
		
		for (int i = 0; i < facesArray.length; i++) {
			Imgproc.rectangle(imageMat, facesArray[i].tl(), facesArray[i].br(), new Scalar(0, 255, 0, 255), 3);
		 }
		
		return imageMat.clone();
	}
}
