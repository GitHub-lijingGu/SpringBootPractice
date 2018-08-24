package com.example.controller;

import com.example.entity.Area;
import com.example.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
/*根路由*/
@RequestMapping("/supperadmin")
public class AreaController {
    @Autowired
    private AreaService areaService;
    @GetMapping("/arealist")
    private Map<String,Object> areaList(){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        List<Area> list=areaService.getAreaList();
        //将结果put到areaList中，便于前台从此Key中获取结果列表
        modelMap.put("areaList",list);
        return  modelMap;
    }
    @GetMapping("/getareabyid")
    private Map<String,Object> getAreaById(Integer areaId){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        Area area=areaService.getAreaById(areaId);
        modelMap.put("area",area);
        return  modelMap;

    }

    @PostMapping("/addarea")
    /*因为前端不可能给我们传来Area对象，所以需加@RequestBody接收前端传来的json值*/

    /*private Map<String,Object> addArea(@RequestBody Area area){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        *//*added存着areaService.addArea(area)返回的Boolean值*//*
        modelMap.put("added",areaService.addArea(area));
        return modelMap;
    }*/
    private void addArea(Area area){
//        Area area1=new Area();
//        area1.setAreaName(area.getAreaName());
//        area1.setPriority(area.getPriority());

        areaService.addArea(area);
    }
    //疑问：更新操作：用post还是put
    @PostMapping("/modifyarea")
    /*private Map<String,Object> modifyArea(@RequestBody Area area){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        *//*added存着areaService.addArea(area)返回的Boolean值*//*
        modelMap.put("modified",areaService.modifyArea(area));
        return modelMap;
    }*/
    private void modifyArea(Area area){
//        Area area2 = new Area();
//        area2.setAreaId(area.getAreaId());
//        area2.setAreaName(area.getAreaName());
//        area2.setPriority(area.getPriority());
//        area2.setLastEditTime(new Date());
        areaService.modifyArea(area);
    }

    @DeleteMapping("/deletearea")
    private Map<String,Object> deleteArea(Integer areaId){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        modelMap.put("deleted",areaService.deleteArea(areaId));
        return modelMap;
    }




}
