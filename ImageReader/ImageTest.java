import static org.junit.Assert.*;
import imagereader.Runner;
import java.awt.Image;
import java.io.FileInputStream;

import javax.print.DocFlavor.BYTE_ARRAY;

import org.junit.Test;

public class ImageTest {
	//比较两个图片是否一样要比较他们的长度、宽度、像素点的个数、以及每一个像素点都要相等

	@Test
	public void testR() {
		try {
			//i have already change to image format in the runner class, so 
			// I use them directly
			ImageIOI imageFile = new ImageIOI();
			Image bfImage = imageFile.myRead("/home/administrator/Desktop/grid world/bmptest/1.bmp");
			Image IW = imageFile.myRead("/home/administrator/Desktop/goal/red.bmp");
			//这是我自己转化得到的图像
			Image Ii = imageFile.myRead("/home/administrator/Desktop/grid world/bmptest/goal/1_red_goal.bmp");
			//这是原来就已经有的图像
			assertEquals("ERROR1", IW.getWidth(null), Ii.getWidth(null));
			assertEquals("ERROR2", IW.getHeight(null), Ii.getHeight(null));
			//以上的两个函数里面，如果不相等的话就会报错ERROR
			
			FileInputStream fi1 = new FileInputStream("/home/administrator/Desktop/goal/red.bmp");  //this is the one write by myself
			FileInputStream fi2 = new FileInputStream("/home/administrator/Desktop/grid world/bmptest/goal/1_red_goal.bmp");
			//read the one which has alweady exist
			byte result[] = new byte[54];
			byte goal[] = new byte[54];
			fi1.read(result, 0, 54);
			fi2.read(goal, 0, 54);
			
			//计算位图全部像素所占用的字节数
			int resultSize = (((int)result[37]) & 0xff) << 24 |
					(((int)result[36]) & 0xff) << 16 |
					(((int)result[35]) & 0xff) << 8 |
					(int)result[34] & 0xff;
			
			int goalSize = (((int)goal[37]) & 0xff) << 24 |
					(((int)goal[36]) & 0xff) << 16 |
					(((int)goal[35]) & 0xff) << 8 |
					(int)goal[34] & 0xff;
			assertEquals("ERROR3", resultSize, goalSize);
			//位图所占用的字节数必须要相等才可以
			
			//读取位图调色板和数据信息
			byte r[] = new byte[resultSize];
			byte g[] = new byte[goalSize];
			fi1.read(r, 0, resultSize);
			fi2.read(g, 0, goalSize);
			for (int i = 0; i < goalSize; i++) {
				assertEquals("ERROR4", r[i], g[i]);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void testG() {
		try {
			//i have already change to image format in the runner class, so 
			// I use them directly
			ImageIOI imageFile = new ImageIOI();
			Image bfImage = imageFile.myRead("/home/administrator/Desktop/grid world/bmptest/1.bmp");
			Image IW = imageFile.myRead("/home/administrator/Desktop/goal/green.bmp");
			//这是我自己转化得到的图像
			Image Ii = imageFile.myRead("/home/administrator/Desktop/grid world/bmptest/goal/1_green_goal.bmp");
			//这是原来就已经有的图像
			assertEquals("ERROR1", IW.getWidth(null), Ii.getWidth(null));
			assertEquals("ERROR2", IW.getHeight(null), Ii.getHeight(null));
			//以上的两个函数里面，如果不相等的话就会报错ERROR
			
			FileInputStream fi1 = new FileInputStream("/home/administrator/Desktop/goal/green.bmp");  //this is the one write by myself
			FileInputStream fi2 = new FileInputStream("/home/administrator/Desktop/grid world/bmptest/goal/1_green_goal.bmp");
			//read the one which has alweady exist
			byte result[] = new byte[54];
			byte goal[] = new byte[54];
			fi1.read(result, 0, 54);
			fi2.read(goal, 0, 54);
			
			//计算位图全部像素所占用的字节数
			int resultSize = (((int)result[37]) & 0xff) << 24 |
					(((int)result[36]) & 0xff) << 16 |
					(((int)result[35]) & 0xff) << 8 |
					(int)result[34] & 0xff;
			
			int goalSize = (((int)goal[37]) & 0xff) << 24 |
					(((int)goal[36]) & 0xff) << 16 |
					(((int)goal[35]) & 0xff) << 8 |
					(int)goal[34] & 0xff;
			assertEquals("ERROR3", resultSize, goalSize);
			//位图所占用的字节数必须要相等才可以
			
			//读取位图调色板和数据信息
			byte r[] = new byte[resultSize];
			byte g[] = new byte[goalSize];
			fi1.read(r, 0, resultSize);
			fi2.read(g, 0, goalSize);
			for (int i = 0; i < goalSize; i++) {
				assertEquals("ERROR4", r[i], g[i]);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void testB() {
		try {
			//i have already change to image format in the runner class, so 
			// I use them directly
			ImageIOI imageFile = new ImageIOI();
			Image bfImage = imageFile.myRead("/home/administrator/Desktop/grid world/bmptest/1.bmp");
			Image IW = imageFile.myRead("/home/administrator/Desktop/goal/blue.bmp");
			//这是我自己转化得到的图像
			Image Ii = imageFile.myRead("/home/administrator/Desktop/grid world/bmptest/goal/1_blue_goal.bmp");
			//这是原来就已经有的图像
			assertEquals("ERROR1", IW.getWidth(null), Ii.getWidth(null));
			assertEquals("ERROR2", IW.getHeight(null), Ii.getHeight(null));
			//以上的两个函数里面，如果不相等的话就会报错ERROR
			
			FileInputStream fi1 = new FileInputStream("/home/administrator/Desktop/goal/blue.bmp");  //this is the one write by myself
			FileInputStream fi2 = new FileInputStream("/home/administrator/Desktop/grid world/bmptest/goal/1_blue_goal.bmp");
			//read the one which has alweady exist
			byte result[] = new byte[54];
			byte goal[] = new byte[54];
			fi1.read(result, 0, 54);
			fi2.read(goal, 0, 54);
			
			//计算位图全部像素所占用的字节数
			int resultSize = (((int)result[37]) & 0xff) << 24 |
					(((int)result[36]) & 0xff) << 16 |
					(((int)result[35]) & 0xff) << 8 |
					(int)result[34] & 0xff;
			
			int goalSize = (((int)goal[37]) & 0xff) << 24 |
					(((int)goal[36]) & 0xff) << 16 |
					(((int)goal[35]) & 0xff) << 8 |
					(int)goal[34] & 0xff;
			assertEquals("ERROR3", resultSize, goalSize);
			//位图所占用的字节数必须要相等才可以
			
			//读取位图调色板和数据信息
			byte r[] = new byte[resultSize];
			byte g[] = new byte[goalSize];
			fi1.read(r, 0, resultSize);
			fi2.read(g, 0, goalSize);
			for (int i = 0; i < goalSize; i++) {
				assertEquals("ERROR4", r[i], g[i]);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void testGray() {
		try {
			//i have already change to image format in the runner class, so 
			// I use them directly
			ImageIOI imageFile = new ImageIOI();
			Image bfImage = imageFile.myRead("/home/administrator/Desktop/grid world/bmptest/1.bmp");
			Image IW = imageFile.myRead("/home/administrator/Desktop/goal/gray.bmp");
			//这是我自己转化得到的图像
			Image Ii = imageFile.myRead("/home/administrator/Desktop/grid world/bmptest/goal/1_gray_goal.bmp");
			//这是原来就已经有的图像
			assertEquals("ERROR1", IW.getWidth(null), Ii.getWidth(null));
			assertEquals("ERROR2", IW.getHeight(null), Ii.getHeight(null));
			//以上的两个函数里面，如果不相等的话就会报错ERROR
			
			FileInputStream fi1 = new FileInputStream("/home/administrator/Desktop/goal/gray.bmp");  //this is the one write by myself
			FileInputStream fi2 = new FileInputStream("/home/administrator/Desktop/grid world/bmptest/goal/1_gray_goal.bmp");
			//read the one which has alweady exist
			byte result[] = new byte[54];
			byte goal[] = new byte[54];
			fi1.read(result, 0, 54);
			fi2.read(goal, 0, 54);
			
			//计算位图全部像素所占用的字节数
			int resultSize = (((int)result[37]) & 0xff) << 24 |
					(((int)result[36]) & 0xff) << 16 |
					(((int)result[35]) & 0xff) << 8 |
					(int)result[34] & 0xff;
			
			int goalSize = (((int)goal[37]) & 0xff) << 24 |
					(((int)goal[36]) & 0xff) << 16 |
					(((int)goal[35]) & 0xff) << 8 |
					(int)goal[34] & 0xff;
			assertEquals("ERROR3", resultSize, goalSize);
			//位图所占用的字节数必须要相等才可以
			
			//读取位图调色板和数据信息
			byte r[] = new byte[resultSize];
			byte g[] = new byte[goalSize];
			fi1.read(r, 0, resultSize);
			fi2.read(g, 0, goalSize);
			for (int i = 0; i < goalSize; i++) {
				assertEquals("ERROR4", r[i], g[i]);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
