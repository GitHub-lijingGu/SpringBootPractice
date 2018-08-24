package com.example.dao;

import com.example.dao.AreaDao;
import com.example.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {
    @Autowired
    private AreaDao areaDao;

    @Test
    @Ignore
    public void queryAreaTest() {
        List<Area> areaList = areaDao.queryArea();
        assertEquals(2,areaList.size());
    }

    @Test
    @Ignore
    public void queryAreaById() {
        Area area=areaDao.queryAreaById(1);
        assertEquals("东苑",area.getAreaName());
    }

    @Test
    @Ignore
    public void insertArea() {
        Area area=new Area();
        area.setAreaName("南苑");
        area.setPriority(1);
        areaDao.insertArea(area);
        //返回影响函数
        /*int effectedNum =areaDao.insertArea(area);
        assertEquals(1 , effectedNum);*/
    }

    @Test
    @Ignore
    public void updateArea() {
        Area area=new Area();
        area.setAreaName("xi苑");
        area.setAreaId(3);
        area.setLastEditTime(new Date());
        areaDao.updateArea(area);
       /* int effectedNum =areaDao.updateArea(area);
        assertEquals(1 , effectedNum);*/
    }

    @Test
    @Ignore
    public void deleteArea() {
        int effectedNum = areaDao.deleteArea(3);
        assertEquals(1,effectedNum);
    }
}