// ImagaReaderRunner.java
import java.awt.Image;
import java.io.IOException;
import imagereader.Runner;

public class ImageReaderRunner {
	public static void main(String[] args) throws IOException {
		ImageIOI imageioer = new ImageIOI();
		ImageProcessor processor = new ImageProcessor();
		Runner.run(imageioer, processor);
		Image image = imageioer.myRead("/home/administrator/Desktop/grid world/bmptest/1.bmp");
		Image imagegray = processor.showGray(image);
		imageioer.myWrite(imagegray, "/home/administrator/Desktop/goal/gray");
		Image imageb = processor.showChanelB(image);
		imageioer.myWrite(imageb, "/home/administrator/Desktop/goal/blue");
		Image imager = processor.showChanelR(image);
		imageioer.myWrite(imager, "/home/administrator/Desktop/goal/red");
		Image imageg = processor.showChanelG(image);
		imageioer.myWrite(imageg, "/home/administrator/Desktop/goal/green");
		
	}
}