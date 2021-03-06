package com.example.service;

import com.example.entity.Area;

import java.util.List;

public interface AreaService {
    /*获取区域列表
       @return areaList
     */
    List<Area> getAreaList();
    /*通过区域ID获取区域信息
     * @param areaId
     * @return area
     * */
    Area getAreaById(int areaId);
    /*增加区域信息
     * @param area
     * @return */
    void addArea(Area area);
    /*修改区域信息
     * @param area
     * @return */
    void modifyArea(Area area);
    /*删除区域信息
     * @param areaId
     * @return*/
    boolean deleteArea(int areaId);
}
