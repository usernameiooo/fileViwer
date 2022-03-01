package com.huang.fileviwer.core;

import com.huang.fileviwer.util.FileUtil;

import java.io.File;

/**文件的描述*/
public class FileDesc {
    String path;
    String vPath;
    File file;
    String name;
    long bytes;
    String size;
    String type;
    String time;
    Resource resource;
    public FileDesc(File file){
        this.file=file;
        this.path= file.getAbsolutePath();
        this.vPath= FileUtil.realToVirtual(path);
        this.resource=Resource.getFrom(path);
        this.name=file.getName();
    }
    public boolean isDir(){
        return file.isDirectory();
    }
    public boolean isFile(){
        return file.isFile();
    }
    public boolean isResource(){
        return resource!=null;
    }
    public Resource getResource() {
        return resource;
    }

    public String getPath() {
        return path;
    }

    public String getVPath() {
        return vPath;
    }
    public String getName() {
        return name;
    }
}
