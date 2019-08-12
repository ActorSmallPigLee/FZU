package ioDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileControl {
	public static void main(String[] args) {
		String fileUrl1 = "C:\\Users\\Administrator\\Desktop\\file\\SWIFT gpi - COVER (gCOV) - Service Rulebook Advance Information - 18 January 2018_Confidential.pdf";
		String fileUrl2 = "";
		for (int i = 1000; i <= 50000; i+=1000) {
			System.out.println(i);
			fileUrl2 = "C:\\Users\\Administrator\\Desktop\\file\\SWIFT gpi - COVER (gCOV) - Service Rulebook Advance Information - 18 January 2018_Confidential_"+i+".pdf";
			CopyFile(fileUrl1, fileUrl2, i);
		}

	}
	//复制文件
	@SuppressWarnings("resource")
	public  static void CopyFile(String fileUrl1,String fileUrl2,int byteLength) {
		File file1 = new File(fileUrl1);
		File file2 = new File(fileUrl2);
		FileInputStream  fileInputStream = null;
		FileOutputStream fileOutputStream = null;
		try {
			fileInputStream   = new FileInputStream(file1);
			fileOutputStream = new FileOutputStream(file2);
			
			byte[] bs=new byte[byteLength];
			int i ;
			long currentTimeMillis1 = System.currentTimeMillis();
			while((i=fileInputStream.read(bs))!=-1) {
					fileOutputStream.write(bs, 0, i);
			}
			long currentTimeMillis2 = System.currentTimeMillis();
			System.out.println("数组长度："+byteLength+",耗时："+(currentTimeMillis2-currentTimeMillis1));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(fileInputStream!=null) {
				try {
					fileInputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(fileOutputStream!=null) {
				try {
					fileOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
