package com.lanysec.idrecoginition;

import net.sourceforge.tess4j.Tesseract;

import java.io.File;

public class Test {

    public static String test(String path){
        File imageFile = new File(path);
        Tesseract instance = new Tesseract();
        instance.setDatapath("D:\\work\\idre\\data"); //设置训练库的位置
        instance.setLanguage("eng");
        try {
            String result = instance.doOCR(imageFile);
            System.out.println(result);
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    public static void main(String[] args){
        Test.test("D:\\work\\idre\\img_src\\id_card.jpg");
    }
}
