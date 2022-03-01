package com.huang.fileviwer.controller;

import com.huang.fileviwer.core.FileManager;
import com.huang.fileviwer.core.Resource;
import com.huang.fileviwer.util.FileUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DirController {
    FileManager fileManager=new FileManager(FileUtil.realDir);
    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView mav=new ModelAndView();
        mav.setViewName("/index");
        mav.addObject("root",fileManager.baseDirPath);
        mav.addObject("folders",fileManager.parentFolders());
        mav.addObject("files",fileManager.listFiles());
        mav.addObject("fileDescs",fileManager.listFileDescs());
        return mav;
    }
    @ResponseBody
    @RequestMapping("/openDir")
    public Map<String,String> openDir(@RequestBody Map<String,String> reqParas){
        fileManager.openDir(reqParas.get("path"));
        Map<String,String> map=new HashMap<>();
        map.put("result","success");

         return map;
    }

}
