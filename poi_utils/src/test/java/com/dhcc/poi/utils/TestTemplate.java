/**
 * Copyright (c) 2008-2013 by DHCC
 * All rights reserved.
 */

package com.dhcc.poi.utils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.junit.Test;

import com.dhcc.poi.model.User;

public class TestTemplate {

    @Test
    public void test01(){
        ExcelTemplate et = ExcelTemplate.getInstance().readTemplateByClasspath("/excel/default.xls");
        et.createNewRow(); 
        et.createCell("1111");
        et.createCell("aaaa");
        et.createCell("a1");
        et.createCell("a2a2");
        et.createNewRow();
        et.createCell("22222");
        et.createCell("cccc");
        et.createCell("a1");
        et.createCell("a2a2");
        et.createNewRow();
        et.createCell("3333");
        et.createCell(123);
        et.createCell("a1");
        et.createCell(new Date());
        et.createNewRow();
        et.createCell("4444");
        et.createCell("eeee");
        et.createCell("a1");
        et.createCell("a2a2");
        Map<String, String> map = new HashMap<String, String>();
        map.put("title", "测试用例标题");
        map.put("date", new Date().toString());
        map.put("dept", "运维产品开发部");
        et.replaceFinalData(map);
        et.insertSer();
        et.writeToFile("e:/work/test/test01.xls");
    }
    
    @Test
    public void test02(){
        List<User> users = new ArrayList<User>();
        users.add(new User(1, "zyy", "zyy", 22));
        users.add(new User(2, "mmq", "mmq", 23));
        users.add(new User(3, "jjm", "jjm", 24));
        users.add(new User(4, "zwt", "zwt", 28));
        Map<String, String> datas = new HashMap<String, String>();
        datas.put("title","用户信息");
        datas.put("date", new Date().toString());
        datas.put("dept", "学生公寓办事处");
      
        try {
            ExcelUtil.getInstance().exportObj2ExcelByTemplate(datas, "/excel/user.xls", "e:/work/test/tus.xls", users, User.class, true);
//            ExcelUtil.getInstance().exportObj2Excel("e:/work/test/sss.xlsx", users, User.class,true);
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    
    @Test
    public void testRead() {
        try {
            List<Object> os = ExcelUtil.getInstance().readExcel2ObjsByPath("e:/work/test/tus.xls", User.class, 1,2);
            for (Object o : os) {
                System.out.println(o);
            }
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
    
}
