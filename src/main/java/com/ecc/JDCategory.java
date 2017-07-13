package com.ecc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Mr.Yangxiufeng on 2017/7/13.
 * Time:9:56
 * ProjectName:CategoryBoot
 */
public class JDCategory {
    public static void main(String[] args) throws Exception{
        File file = new File("D:\\develop_space\\CategoryBoot\\src\\main\\resources\\category_2017_04.csv");
        save(file);
    }
    public static void save(File file) throws Exception{
        String driver = "com.mysql.jdbc.Driver";
        String dbName = "test";
        String passwrod = "123456";
        String userName = "root";
        String url = "jdbc:mysql://localhost:3306/" + dbName + "?useUnicode=true&characterEncoding=utf-8";
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line=null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = simpleDateFormat.format(new java.util.Date());
        Class.forName(driver);
        Connection conn = null;
        conn = DriverManager.getConnection(url, userName,
                passwrod);
        while ((line = br.readLine())!=null) {
            System.out.println("line=" + line);
            int index = line.lastIndexOf(",");
            String catId = line.substring(0,index-3);
            System.out.println("catid="+catId);
            String catName = line.substring(index+1,line.length());
            System.out.println("catname="+catName);
            if (catName.contains("'")){
                catName = catName.replace("'","''");
            }
            String selectSql = "SELECT * FROM category_jd WHERE cat_id="
                    + "\'"+catId+"'"
                    + "and "
                    +"cat_name="+"\'"+""+catName+""+"'";
            boolean flag = search(conn,selectSql);
            System.out.println("flag="+flag);
            if (!flag){
                String sql = "insert into category_jd (cat_id,cat_name,import_date) values("
                    + "\'"+catId+"',"
                    + "\'"+""+catName+""+"',"
                    + "\'"+ date+"'"
                    + ")";
            System.out.println(sql);
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.execute();
            }
        }
        br.close();
        conn.close();
    }
    private static boolean search(Connection conn,String sql) throws Exception{
        PreparedStatement ps = null;
        String code=null;
        ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        boolean flag = rs.next();
        return flag;
    }
}
