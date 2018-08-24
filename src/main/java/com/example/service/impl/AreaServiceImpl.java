package com.example.service.impl;

import com.example.dao.AreaDao;
import com.example.entity.Area;
import com.example.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;
    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }

    @Override
    public Area getAreaById(int areaId) {
        //测试统一异常处理类
        //int a=1/0;
        return areaDao.queryAreaById(areaId);
    }

    /*增删改，需要事务进行控制*/
    @Transactional
    @Override
    public void addArea(Area area) {

        /*判断传入的值非空，也不能是空字符串*/
        if(area.getAreaName()!=null && !"".equals(area.getAreaName())){
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try{
                areaDao.insertArea(area);
               /*int effectedNum =areaDao.insertArea(area);
               if(effectedNum>0){
                   return true;
               }else{
                   RuntimeException会自动执行事务回滚
                   throw new RuntimeException("插入区域信息失败");
               }*/
            }catch (Exception e){
                throw new RuntimeException("插入区域信息失败"+e.getMessage());
            }
        }else{
            throw new RuntimeException("区域信息不能为空");
        }
    }

    @Override
    public void modifyArea(Area area) {
        /*空值判断，主要是areaId不为空*/
        if(area.getAreaId()!=null && area.getAreaId()>0){
            //设置默认值
            area.setLastEditTime(new Date());
            try{
                areaDao.updateArea(area);
                //更新区域信息
                /*int effectedNum =areaDao.updateArea(area);
                if(effectedNum>0){
                    return true;
                }else{
                    *//*RuntimeException会自动执行事务回滚*//*
                    throw new RuntimeException("更新区域信息失败");
                }*/
            }catch (Exception e){
                throw new RuntimeException("更新区域信息失败"+e.toString());
            }
        }else{
            throw new RuntimeException("区域信息不能为空");
        }
    }

    @Override
    public boolean deleteArea(int areaId) {

        if(areaId>0){
            try{
                //删除区域信息
                int effectedNum =areaDao.deleteArea(areaId);
                if(effectedNum>0){
                    return true;
                }else{
                    /*RuntimeException会自动执行事务回滚*/
                    throw new RuntimeException("删除区域信息失败");
                }
            }catch (Exception e){
                throw new RuntimeException("删除区域信息失败"+e.toString());
            }
        }else{
            throw new RuntimeException("区域Id不能为空");
        }
    }
}
