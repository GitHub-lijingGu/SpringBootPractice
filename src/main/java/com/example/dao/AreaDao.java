package com.example.dao;

import com.example.entity.Area;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface AreaDao {
    /*列出区域列表
       @return areaList
     */
    List<Area> queryArea();
    /*根据ID列出具体区域
    * @return area
    * */
   Area queryAreaById(int areaId);
   /*插入区域信息
    * @param area
    * @return */
    void insertArea(Area area);
   /*更新区域信息
    * @param area
    * @return */
    void updateArea(Area area);
    /*删除区域信息
    * @param areaId
    * @return*/
    int deleteArea(int areaId);
}
