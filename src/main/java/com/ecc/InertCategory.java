package com.ecc;

import java.io.*;
import java.sql.*;

/**
 * Created by Mr.Yangxiufeng on 2017/5/24.
 * Time:9:48
 * ProjectName:CategoryBoot
 */
public class InertCategory {
    public static void main(String[] args) {
        File file = new File("D:/cat.txt");
        save(file);
    }
    public static void save(File file){
        String driver = "com.mysql.jdbc.Driver";
        String dbName = "test";
        String passwrod = "123456";
        String userName = "root";
        String url = "jdbc:mysql://localhost:3306/" + dbName+"?useUnicode=true&characterEncoding=utf-8";
        try {
            Connection conn = null;
            try {
                Class.forName(driver);
                conn = DriverManager.getConnection(url, userName,
                        passwrod);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line=null;
            while ((line = br.readLine())!=null) {
                System.out.println("line=" + line);
                String[] a = line.split("\\t");
                String id = a[0];
                String catsLine = a[1];
                System.out.println("id=" + id+",catsLine="+catsLine);
                /**************临时表，存储到cat******************/
//                CatFinal category = new CatFinal();
//                category.setRootCode(id);
//                int endIndex = catsLine.lastIndexOf(">");
//                String cat = catsLine.substring(endIndex+1,catsLine.length());
//                category.setRootName(cat);
//                String sql;
//                sql = "insert into cat values("
//                        + "\'"+category.getRootCode()+"',"
//                        + "\'"+category.getRootName()+"'"
//                        + ")";
                /*********************************************/

                String[] cats = catsLine.split(">");
                int size = cats.length;
                CatFinal category = new CatFinal();
                String sql;
                String parentCode=null;
                category.setId(Integer.valueOf(id));
                switch (size){
                    case 1:
                        category.setCode(id);
                        category.setName(catsLine);
                        category.setRootCode(id);
                        category.setRootName(catsLine);
                        break;
                    case 2:
                        sql = "SELECT * FROM cat WHERE name="+"\'"+cats[0]+"\'";
                        parentCode = search(conn,sql);
                        category.setParentCode(parentCode);
                        category.setRootCode(parentCode);
                        category.setRootName(cats[0]);
                        category.setCode(id);
                        category.setName(cats[1]);
                        break;
                    case 3:
                        sql = "SELECT * FROM cat WHERE name="+"\'"+cats[1]+"\'";
                        parentCode = search(conn,sql);
                        category.setParentCode(parentCode);
                        category.setCode(id);
                        category.setName(cats[2]);
                        //查询根目录
                        sql = "SELECT * FROM cat WHERE name="+"\'"+cats[0]+"\'";
                        String grandfatherCode = search(conn,sql);
                        category.setRootCode(grandfatherCode);
                        category.setRootName(cats[0]);
                        break;
                    case 4:
                        sql = "SELECT * FROM cat WHERE name="+"\'"+cats[2]+"\'";
                        parentCode = search(conn,sql);
                        category.setParentCode(parentCode);
                        category.setCode(id);
                        category.setName(cats[2]);
                        //查询根目录
                        sql = "SELECT * FROM cat WHERE name="+"\'"+cats[0]+"\'";
                        String grandfatherCode1 = search(conn,sql);
                        category.setRootCode(grandfatherCode1);
                        category.setRootName(cats[0]);
                        break;
                }

//                for (int i = 0; i < cats.length; i++) {
//                    switch (i) {
//                        case 0:
//                            category.setCats1(cats[i]);
//                            break;
//                        case 1:
//                            category.setCats2(cats[i]);
//                            break;
//                        case 2:
//                            category.setCats3(cats[i]);
//                            break;
//                        case 3:
//                            category.setCats4(cats[i]);
//                            break;
//                    }
//                }

                 sql = "insert into category_final values("
                        + "\'"+category.getId()+"',"
                        + "\'"+category.getCode()+"',"
                        + "\'"+category.getName()+"',"
                        + "\'"+category.getParentCode()+"',"
                        + "\'"+category.getRootCode()+"',"
                        + "\'"+category.getRootName()+"'"
                        + ")";
//                    System.out.println(sql);
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.execute();
            }
            br.close();
            conn.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static String search(Connection conn,String sql){
//        return "";
        PreparedStatement ps = null;
        String code=null;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            boolean flag = rs.next();
            if (flag){
                code = rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return code;
    }
}
