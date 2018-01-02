package com.lanysec.idrecoginition;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.util.Arrays;

public class Main {
    private static final Double avatarSpacePer = 0.16;
    private static final Double avatarPer = 0.28;


    public void cutImage(File srcImg, File destImg, Rectangle rect) throws Exception{
        if(srcImg.exists()){
            FileInputStream fis = null;
            ImageInputStream iis = null;
            OutputStream ops = null;
            try{
                fis = new FileInputStream(srcImg);
                String types = Arrays.toString(ImageIO.getReaderFormatNames()).replace("]",",");
                String suffix = null;

            }catch(Exception e){
                e.printStackTrace();
            }finally{

            }
        }else{
            String msg = "src image is not exists!";
            throw new RuntimeException(msg);
        }
    }
}
