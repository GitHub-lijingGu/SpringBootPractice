package com.example.service;

import com.example.entity.Area;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaServiceTest {

    @Autowired
    private AreaService areaService;
    @Test
    public void getAreaList() {
        List<Area> areaList=areaService.getAreaList();
        //Assert.assertEquals(java.util.Optional.of(new Integer(7)),java.util.Optional.of (areaList.size()));
       //Assert.assertEquals(new Integer(7), java.util.Optional.ofNullable(areaList.size()));
        //Assert.assertEquals(java.util.Optional.of(new Integer(7)),areaList.size());
        Assert.assertEquals(java.util.Optional.of(new Integer(7)),java.util.Optional.of(areaList.size()));
    }

    @Test
    public void getAreaById() {
        Area area=areaService.getAreaById(1);
        Assert.assertEquals(new Integer(4),area.getPriority());
    }


    @Test
    public void addArea() {
    }

    @Test
    public void modifyArea() {
    }

    @Test
    public void deleteArea() {
    }
}