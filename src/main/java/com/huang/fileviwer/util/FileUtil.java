package com.huang.fileviwer.util;

import java.io.File;
import java.util.List;

public class FileUtil {
    public static String realDir=PropertyUtil.getProperty("src-path");
    public static String virtualDir=PropertyUtil.getProperty("map-path");
    public static String realToVirtual(String realPtah){
        if(realPtah==null||realPtah.isEmpty())return null;
        return realPtah.replace(realDir,virtualDir);
    }
    public static boolean verifyDir(String path){
        if(path==null||path.isEmpty()){
            System.out.println("根目录为空:"+path);
            return false;
        }
        File file=new File(path);
        if(!file.exists()||!file.isDirectory()){
            System.out.println("根目录不存在或不是文件夹:"+path);
            return false;
        }
        return true;
    }
}
