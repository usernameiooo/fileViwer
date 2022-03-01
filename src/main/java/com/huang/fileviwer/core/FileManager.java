package com.huang.fileviwer.core;

import com.huang.fileviwer.util.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileManager {
   public final String baseDirPath;
   public final File baseDir;
   public FileManager(String baseDirPath){
       if(!FileUtil.verifyDir(baseDirPath)){
           System.exit(-1);
       }
       File file=new File(baseDirPath);
       this.baseDir=file;
       this.baseDirPath=baseDirPath;
       currDir=file;
   }
   File currDir;
   public void openDir(String path){
       if(!FileUtil.verifyDir(path))return;
       if(!path.startsWith(baseDirPath))return;
       currDir=new File(path);
   }
   public void goBackToRoot(){
       currDir=baseDir;
   }
   public void goBackToParent(){
       if(currDir.equals(baseDir))return;
       currDir= currDir.getParentFile();

   }
   public File[] listFiles(){
       return currDir.listFiles();
   }
   public FileDesc[] listFileDescs(){
       File[] files = listFiles();
       FileDesc[] fileDescs=new FileDesc[files.length];
       for(int i=0;i< files.length;i++){
           fileDescs[i]=new FileDesc(files[i]);
       }
       return fileDescs;
    }
   /**列出从根目录到当前目录所经过的目录*/
   public List<File> parentFolders(){
       List<File> dirs=new ArrayList<>();
       File dir=currDir;
       while (dir!=null&&!dir.equals(baseDir)){
           dirs.add(dir);
           dir=dir.getParentFile();
       }
       Collections.reverse(dirs);
       return dirs;
   }
   public void scan(){

   }
}
