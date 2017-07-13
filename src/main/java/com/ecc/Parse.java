package com.ecc;

import java.io.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * Created by Mr.Yangxiufeng on 2016/11/10.
 * Time:10:05
 * ProjectName:CategoryBoot
 */
public class Parse {
    public static void main(String[] args) {
//        File file = new File("D:/cat.txt");
//        save(file);
    }
    public static void save(File file){
//        String driver = "com.mysql.jdbc.Driver";
//        String dbName = "test";
//        String passwrod = "123456";
//        String userName = "root";
//        String url = "jdbc:mysql://localhost:3306/" + dbName+"?useUnicode=true&characterEncoding=utf-8";
//        try {
//            Connection conn = null;
//            try {
//                Class.forName(driver);
//                conn = DriverManager.getConnection(url, userName,
//                        passwrod);
//            } catch (ClassNotFoundException e) {
//                e.printStackTrace();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//            BufferedReader br = new BufferedReader(new FileReader(file));
//            String line=null;
//            while ((line = br.readLine())!=null) {
////                System.out.println("line=" + line);
//                //得到ID
//                int idIndex = line.indexOf(":");
////                System.out.println("idIndex=" + idIndex);
//                int idEnd = line.indexOf("  ");
////                System.out.println("idEnd=" + idEnd);
//                String id = line.substring(idIndex + 1, idEnd);
////                System.out.println("id=" + id);
//                Category category = new Category();
//                category.setId(Integer.valueOf(id));
//
//                String catsLine = line.substring(line.lastIndexOf(":") + 1, line.length());
//                System.out.println("catsLine=" + catsLine);
//                String[] cats = catsLine.split(">");
//                int size = cats.length;
//                String sql;
//                String parentCode=null;
//                String grandfatherCode=null;
//                String greatGrandfatherCode=null;
//                switch (size){
//                    case 1:
//                        category.setParentCode(id);
//                        category.setCategoryName(cats[0]);
//                        category.setCats4(cats[0]);
//                        category.setRootCode(id);
//                        category.setRootName(cats[0]);
//                        break;
//                    case 2:
//                        sql = "SELECT * FROM category WHERE category1="+"\'"+cats[0]+"\'" + " AND category2 is NULL";
//                        parentCode = search(conn,sql);
//                        category.setParentCode(parentCode);
//                        category.setCategoryName(cats[1]);
//                        category.setCats4(cats[1]);
//                        category.setCats3(cats[0]);
//                        category.setRootCode(parentCode);
//                        category.setRootName(cats[0]);
//                        break;
//                    case 3:
//                        sql = "SELECT * FROM category WHERE category2="+"\'"+cats[1]+"\'"+ " AND category3 is NULL";
//                        parentCode = search(conn,sql);
//                        category.setParentCode(parentCode);
//                        category.setCategoryName(cats[2]);
//                        category.setCats4(cats[2]);
//                        category.setCats3(cats[1]);
//                        category.setCats2(cats[0]);
//                        //祖先
//                        sql = "SELECT * FROM category WHERE category1="+"\'"+cats[0]+"\'" + " AND category2 is NULL";
//                        grandfatherCode = search(conn,sql);
//                        category.setGrandfatherCode(grandfatherCode);
//                        category.setRootCode(grandfatherCode);
//                        category.setRootName(cats[0]);
//                        break;
//                    case 4:
//                        sql = "SELECT * FROM category WHERE category3="+"\'"+cats[2]+"\'" + "AND category4 is NULL";
//                        parentCode = search(conn,sql);
//                        category.setParentCode(parentCode);
//                        category.setCategoryName(cats[3]);
//                        category.setCats4(cats[3]);
//                        category.setCats3(cats[2]);
//                        category.setCats2(cats[1]);
//                        category.setCats1(cats[0]);
//                        //祖先
//                        sql = "SELECT * FROM category WHERE category2="+"\'"+cats[1]+"\'"+ " AND category3 is NULL";
//                        grandfatherCode = search(conn,sql);
//                        category.setGrandfatherCode(grandfatherCode);
//                        //曾祖
//                        sql = "SELECT * FROM category WHERE category1="+"\'"+cats[0]+"\'" + " AND category2 is NULL";
//                        greatGrandfatherCode = search(conn,sql);
//                        category.setGreatGrandfatherCode(greatGrandfatherCode);
//                        category.setRootCode(greatGrandfatherCode);
//                        category.setRootName(cats[0]);
//                        break;
//                }
//
////                for (int i = 0; i < cats.length; i++) {
////                    switch (i) {
////                        case 0:
////                            category.setCats1(cats[i]);
////                            break;
////                        case 1:
////                            category.setCats2(cats[i]);
////                            break;
////                        case 2:
////                            category.setCats3(cats[i]);
////                            break;
////                        case 3:
////                            category.setCats4(cats[i]);
////                            break;
////                    }
////                }
//
//                    sql = "insert into category1 values("
//                            + "\'"+category.getId()+"',"
//                            + "\'"+category.getId()+"',"
//                            + "\'"+"阿里系"+"',"
//                            + "\'"+category.getCats1()+"',"
//                            + "\'"+category.getCats2()+"',"
//                            + "\'"+category.getCats3()+"',"
//                            + "\'"+category.getCats4()+"',"
//                            + "\'"+category.getParentCode()+"',"
//                            + "\'"+category.getGrandfatherCode()+"',"
//                            + "\'"+category.getGreatGrandfatherCode()+"',"
//                            + "\'"+category.getRootCode()+"',"
//                            + "\'"+category.getRootName()+"'"
//                            + ")";
////                    System.out.println(sql);
////                    PreparedStatement ps = conn.prepareStatement(sql);
////                    ps.execute();
//            }
//            br.close();
//            conn.close();
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }catch (IOException e){
//            e.printStackTrace();
//        }catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }

//    private static String search(Connection conn,String sql){
//        PreparedStatement ps = null;
//        String code=null;
//        try {
//            ps = conn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            boolean flag = rs.next();
//            if (flag){
//                code = rs.getString(1);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return code;
    }
}
