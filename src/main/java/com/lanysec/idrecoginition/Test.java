package com.lanysec.idrecoginition;

import net.sourceforge.tess4j.Tesseract;

import java.io.File;

public class Test {

    public static String test(String path){
        File imageFile = new File(path);
        Tesseract instance = new Tesseract();
        instance.setDatapath("D:/work/idre/tesseract/tessdata"); //设置训练库的位置
        instance.setLanguage("chi_sim");
        try {
            String result = instance.doOCR(imageFile);
            System.out.println(result);
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }
        return "";
    }

    private final String LANG_OPTION = "-1";
    private final String EOL = System.getProperty("line.separator");

    private String tessPath = new File("tesseract").getAbsolutePath();

    public String recognizeText(File imageFile) throws Exception{
        File outputFile = new File(imageFile.getParentFile(),"output");
        StringBuffer str8 = new StringBuffer();
        List<String> cmd = new ArrayList<String>();
        String os = System.getProperty("os.name");
        if(os.toLowerCase().startsWith("win")){
            cmd.add("tesseract");
        }else{
            cmd.add("tesseract");
        }
        cmd.add(imageFile.getName());
        cmd.add(outputFile.getName());
        cmd.add("digits");
        ProcessBuilder pb = new ProcessBuilder();
        pb.directory(imageFile.getParentFile());
        pb.command(cmd);
        pb.redirectErrorStream(true);
        Process process = pb.start();
        int w = process.waitFor();
        if(w == 0){
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    new FileInputStream(outputFile.getAbsoluteFile() + ".txt"),"UTF-8"));
            String str;
            while((str = in.readLine()) != null){
                str8.append(str).append(EOL);
            }
            in.close();
        }else{
            String msg;
            switch (w){
                case 1:
                    msg = "Errors accessing files. There may be spaces in your image's filename.";
                    break;
                case 29:
                    msg = "Cannot recognize the image or its selected region.";
                    break;
                case 31:
                    msg = "Unsupported image format.";
                    break;
                default:
                    msg = "Errors occurred.";
            }
            throw new RuntimeException(msg);
        }
        new File(outputFile.getAbsolutePath() + ".txt").delete();
        return str8.toString().replace("\\s*", "");
    }

    public static void main(String[] args){
        Test.test("D:/work/idre/img_src/id_card2.jpg");
        /*Test test = new Test();
        try{
            System.out.println(test.recognizeText(new File("D:/work/idre/img_src/22.png")));
        }catch(Exception e){
            e.printStackTrace();
        }*/
    }
}
