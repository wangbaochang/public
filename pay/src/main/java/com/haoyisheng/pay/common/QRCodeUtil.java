package com.haoyisheng.pay.common;

import java.io.ByteArrayOutputStream;
import java.util.Hashtable;

import org.apache.commons.codec.binary.Base64;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

/**
 * 
 * @author wangbaochang
 *
 */
public class QRCodeUtil {
	
	public static String getQRCodeImageBase64String(String content){
		return getQRCodeImageBase64String(content,null,null);
	}
	
	/**
	 * 生成指定内容二维码图片
	 * @param content 内容容
	 * @param width
	 * @param height
	 * @return 二维码图片Base64编码字符串
	 */
	public static String getQRCodeImageBase64String(String content,Integer width,Integer height){
		String imageBase64String="";
		Integer w = width!=null ? width:100;   
		Integer h = height!=null ?height:100;   
        String format = "png";   
        Hashtable<EncodeHintType,String> hints= new Hashtable<EncodeHintType,String>();   
        hints.put(EncodeHintType.CHARACTER_SET, "utf-8");  
        ByteArrayOutputStream os=null;
        try{
	        BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, w, h,hints);  
	        os=new ByteArrayOutputStream();
        	MatrixToImageWriter.writeToStream(bitMatrix, format, os);
        	byte[] bytes=os.toByteArray();
        	imageBase64String= Base64.encodeBase64String(bytes);  
        	os.close();
        }
        catch(Exception e){
        	
        }
        finally {
			if(os!=null){
				try{
					os.close();
				}
				catch(Exception e){
					
				}
			}
		}
        return imageBase64String;
	}

}
