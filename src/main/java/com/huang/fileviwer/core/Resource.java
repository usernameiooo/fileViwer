package com.huang.fileviwer.core;

import com.huang.fileviwer.util.FileUtil;

import java.io.File;

/**资源文件类
 * 可以在网页查看的文件*/
public abstract class Resource {
    public String path;
    public String type;
    public static Resource getFrom(String path){
        if(path==null||path.isEmpty())return null;
        File file=new File(path);
        if(!file.exists()||!file.isFile())return null;
        Resource resource=null;
        if(Txt.isResource(path))resource=new Txt(path);
        else if(Picture.isResource(path))resource= new Picture(path);
        else if(Video.isResource(path))resource= new Video(path);
        if(resource!=null){
            resource.setPath(path);
            return resource;
        }
        return null;
    }
    private void setPath(String path){
        this.path=path;
    }
    public String getType() {
        return type;
    }
    public String getVirtualPath(){
        return FileUtil.realToVirtual(path);
    }
    public static boolean isResource(String path){
        return false;
    }
    private static boolean isResource(String path,String[] pattern){
        int i = path.lastIndexOf(".");
        if(i==-1)return false;
        path=path.substring(i);
        for(String p:pattern){
            if(path.equalsIgnoreCase(p))return true;
        }
        return false;
    }
    /**文本文件*/
    static public class Txt extends Resource{
        public Txt(String path){
            type="Txt";
        }
        public static String[] TxtPatterns={".txt"};
          public static boolean isResource(String path){
              return Resource.isResource(path,TxtPatterns);
          }
    }
    /**图片文件*/
    static public class Picture extends Resource{
        public Picture(String path){
        type="Picture";}
        public static String[] PicPatterns={".jpg",".jepg",".png",".gif"};
        public static boolean isResource(String path){
            return Resource.isResource(path,PicPatterns);
        }
    }
    /**视频文件*/
    static public class Video extends Resource{
        public Video(String path){
            type="Video";
        }
        public static String[] VidPatterns={".avi",".mp4",".wmv",".mov"};
        public static boolean isResource(String path){
            return Resource.isResource(path,VidPatterns);
        }
    }
}
