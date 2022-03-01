package com.huang.fileviwer.util;

import java.util.Properties;

public class PropertyUtil {
     static final String PropertyFile="/path.properties";
     static  final Properties prop = new Properties();
    static {
        try {
            prop.load(PropertyUtil.class.getResourceAsStream(PropertyFile));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
     public static  final String SrcPath=getProperty("src-path");
     public static  final String MapPath=getProperty("map-path");
     public static String getProperty(String name){
        if(name==null||name.isEmpty())return null;
        return prop.getProperty(name).trim();
     }
}
