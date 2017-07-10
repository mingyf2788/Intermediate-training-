import imagereader.IImageProcessor;  
import java.awt.*;
import java.awt.image.*;

public class ImageProcessor implements IImageProcessor {
	private static final int sixteen = 16;
	private static final int eight = 8;
	private static final double R = 0.299;
	private static final double G = 0.587;
	private static final double B = 0.114;
	private static final int RED = 0xffff0000;
	private static final int GREEN = 0xff00ff00;
	private static final int BLUE = 0xff0000ff;
	private static final int RR = 0x00ff0000;
	private static final int GG = 0x0000ff00;
	private static final int BB = 0x000000ff;
	private static final int zero = 0;

	public Image showChanelR(Image sourceImage) {
		BufferedImage bufim = new BufferedImage(sourceImage.getWidth(null),
			sourceImage.getHeight(null), BufferedImage.TYPE_INT_RGB);
		//三个参数分别代表图像的长度、宽度、以及类型
			//  BufferedImage是Image的一个子类，BufferedImage生成的图片在内存里有一个图像缓冲区，
			//利用这个缓冲区我们可以很方便的操作这个图片，
			//通常用来做图片修改操作如大小变换、图片变灰、设置图片透明或不透明等。
		bufim.getGraphics().drawImage(sourceImage, zero, zero, sourceImage.getWidth(null),
			sourceImage.getHeight(null), null);
		//获取一个图像，0,0是图像起始的位置,sourceImage.getWidth(null),是获取图片的宽度，，null则是绘画图片以默认类型画出

		int pixels[] = new int[sourceImage.getWidth(null) * sourceImage.getHeight(null)];
		//获取图片的所有像素点
		int red[] = new int[sourceImage.getWidth(null) * sourceImage.getHeight(null)];
		//用于存储图片中的红色的像素点
		bufim.getRGB(zero, zero, sourceImage.getWidth(null), sourceImage.getHeight(null), 
			pixels, zero, sourceImage.getWidth(null));
		/*
		方法 getRGB(int startX, int startY, int w, int h, int rgbArray, int offset, int scansize) 
		容易且高效地提取图像的像素值。这个方法可以将图像中矩形区域的像素数据传输到一个整数数组中。
		getRGB() 方法的参数如下：
		startX, startY 是要提取的区域左上角图像的坐标
		w, h 是要提取的区域的宽度和高度
		rgbArray 是接收像素值的整数数组
		offset 是数组中接收第一个像素值的位置的索引。
		scansize 是图像中相邻两行中具有相同行索引的像素的索引偏移值。
		如果这个值与要提取的区域的宽度相同，那么一行的第一个像素就会存储在数组中
		前一行最后一个像素后 面的索引位置。
		如果这个值大于提取区域的宽度，那么数组中，在一行最后和下一行开始之间就会有一些未使用的索引
		*/
		for (int i = zero; i < sourceImage.getWidth(null) * sourceImage.getHeight(null); i++) {
			red[i] = pixels[i] & RED;
		}
		bufim.setRGB(zero, zero, sourceImage.getWidth(null), 
			sourceImage.getHeight(null), red, 0, sourceImage.getWidth(null));
		return bufim;
	}

	public Image showChanelG(Image sourceImage) {
		BufferedImage bufim = new BufferedImage(sourceImage.getWidth(null),
			sourceImage.getHeight(null), BufferedImage.TYPE_INT_RGB);
		//三个参数分别代表图像的长度、宽度、以及类型
			//  BufferedImage是Image的一个子类，BufferedImage生成的图片在内存里有一个图像缓冲区，
			//利用这个缓冲区我们可以很方便的操作这个图片，
			//通常用来做图片修改操作如大小变换、图片变灰、设置图片透明或不透明等。
		bufim.getGraphics().drawImage(sourceImage, zero, zero, sourceImage.getWidth(null),
			sourceImage.getHeight(null), null);
		//获取一个图像，0,0是图像起始的位置,sourceImage.getWidth(null),是获取图片的宽度，，null则是绘画图片以默认类型画出

		int pixels[] = new int[sourceImage.getWidth(null) * sourceImage.getHeight(null)];
		//获取图片的所有像素点
		int green[] = new int[sourceImage.getWidth(null) * sourceImage.getHeight(null)];
		//用于存储图片中的红色的像素点
		bufim.getRGB(zero, zero, sourceImage.getWidth(null), sourceImage.getHeight(null), 
			pixels, zero, sourceImage.getWidth(null));
		/*
		方法 getRGB(int startX, int startY, int w, int h, int rgbArray, int offset, int scansize) 
		容易且高效地提取图像的像素值。这个方法可以将图像中矩形区域的像素数据传输到一个整数数组中。
		getRGB() 方法的参数如下：
		startX, startY 是要提取的区域左上角图像的坐标
		w, h 是要提取的区域的宽度和高度
		rgbArray 是接收像素值的整数数组
		offset 是数组中接收第一个像素值的位置的索引。
		scansize 是图像中相邻两行中具有相同行索引的像素的索引偏移值。
		如果这个值与要提取的区域的宽度相同，那么一行的第一个像素就会存储在数组中
		前一行最后一个像素后 面的索引位置。
		如果这个值大于提取区域的宽度，那么数组中，在一行最后和下一行开始之间就会有一些未使用的索引
		*/
		for (int i = zero; i < sourceImage.getWidth(null) * sourceImage.getHeight(null); i++) {
			green[i] = pixels[i] & GREEN;
		}
		bufim.setRGB(zero, zero, sourceImage.getWidth(null), 
			sourceImage.getHeight(null), green, 0, sourceImage.getWidth(null));
		return bufim;
	}
	//public Image showChanelB(Image arg0) {
	public Image showChanelB(Image sourceImage) {
		BufferedImage bufim = new BufferedImage(sourceImage.getWidth(null),
			sourceImage.getHeight(null), BufferedImage.TYPE_INT_RGB);
		//三个参数分别代表图像的长度、宽度、以及类型
			//  BufferedImage是Image的一个子类，BufferedImage生成的图片在内存里有一个图像缓冲区，
			//利用这个缓冲区我们可以很方便的操作这个图片，
			//通常用来做图片修改操作如大小变换、图片变灰、设置图片透明或不透明等。
		bufim.getGraphics().drawImage(sourceImage, zero, zero, sourceImage.getWidth(null),
			sourceImage.getHeight(null), null);
		//获取一个图像，0,0是图像起始的位置,sourceImage.getWidth(null),是获取图片的宽度，，null则是绘画图片以默认类型画出

		int pixels[] = new int[sourceImage.getWidth(null) * sourceImage.getHeight(null)];
		//获取图片的所有像素点
		int blue[] = new int[sourceImage.getWidth(null) * sourceImage.getHeight(null)];
		//用于存储图片中的红色的像素点
		bufim.getRGB(zero, zero, sourceImage.getWidth(null), sourceImage.getHeight(null), 
			pixels, zero, sourceImage.getWidth(null));
		/*
		方法 getRGB(int startX, int startY, int w, int h, int rgbArray, int offset, int scansize) 
		容易且高效地提取图像的像素值。这个方法可以将图像中矩形区域的像素数据传输到一个整数数组中。
		getRGB() 方法的参数如下：
		startX, startY 是要提取的区域左上角图像的坐标
		w, h 是要提取的区域的宽度和高度
		rgbArray 是接收像素值的整数数组
		offset 是数组中接收第一个像素值的位置的索引。
		scansize 是图像中相邻两行中具有相同行索引的像素的索引偏移值。
		如果这个值与要提取的区域的宽度相同，那么一行的第一个像素就会存储在数组中
		前一行最后一个像素后 面的索引位置。
		如果这个值大于提取区域的宽度，那么数组中，在一行最后和下一行开始之间就会有一些未使用的索引
		*/
		for (int i = zero; i < sourceImage.getWidth(null) * sourceImage.getHeight(null); i++) {
			blue[i] = pixels[i] & BLUE;
		}
		bufim.setRGB(zero, zero, sourceImage.getWidth(null), 
			sourceImage.getHeight(null), blue, 0, sourceImage.getWidth(null));
		return bufim;
	}

	public Image showGray(Image sourceImage) {
		BufferedImage bufim = new BufferedImage(sourceImage.getWidth(null),
			sourceImage.getHeight(null), BufferedImage.TYPE_INT_RGB);
		//三个参数分别代表图像的长度、宽度、以及类型
			//  BufferedImage是Image的一个子类，BufferedImage生成的图片在内存里有一个图像缓冲区，
			//利用这个缓冲区我们可以很方便的操作这个图片，
			//通常用来做图片修改操作如大小变换、图片变灰、设置图片透明或不透明等。
		bufim.getGraphics().drawImage(sourceImage, zero, zero, sourceImage.getWidth(null),
			sourceImage.getHeight(null), null);
		//获取一个图像，0,0是图像起始的位置,sourceImage.getWidth(null),是获取图片的宽度，，null则是绘画图片以默认类型画出

		int pixels[] = new int[sourceImage.getWidth(null) * sourceImage.getHeight(null)];
		//获取图片的所有像素点
		int gray[] = new int[sourceImage.getWidth(null) * sourceImage.getHeight(null)];
		//用于存储图片中的红色的像素点
		bufim.getRGB(zero, zero, sourceImage.getWidth(null),sourceImage.getHeight(null), 
			pixels, zero, sourceImage.getWidth(null));
		/*
		方法 getRGB(int startX, int startY, int w, int h, int rgbArray, int offset, int scansize) 
		容易且高效地提取图像的像素值。这个方法可以将图像中矩形区域的像素数据传输到一个整数数组中。
		getRGB() 方法的参数如下：
		startX, startY 是要提取的区域左上角图像的坐标
		w, h 是要提取的区域的宽度和高度
		rgbArray 是接收像素值的整数数组
		offset 是数组中接收第一个像素值的位置的索引。
		scansize 是图像中相邻两行中具有相同行索引的像素的索引偏移值。
		如果这个值与要提取的区域的宽度相同，那么一行的第一个像素就会存储在数组中
		前一行最后一个像素后 面的索引位置。
		如果这个值大于提取区域的宽度，那么数组中，在一行最后和下一行开始之间就会有一些未使用的索引
		*/
		for (int i = zero; i < sourceImage.getWidth(null) * sourceImage.getHeight(null); i++) {
			int gray_ = (int)(((pixels[i] & RR) >> sixteen) * R + 
				((pixels[i] & GG) >> eight) * G + (pixels[i] & BB) * B);
			gray[i] = gray_ << sixteen | gray_ << eight | gray_;
		}
		bufim.setRGB(zero, zero, sourceImage.getWidth(null), 
			sourceImage.getHeight(null), gray, zero, sourceImage.getWidth(null));
		return bufim;
	}
	
}