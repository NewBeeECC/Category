package com.ecc;

import java.io.Serializable;

/**
 * Created by Mr.Yangxiufeng on 2016/11/10.
 * Time:10:25
 * ProjectName:CategoryBoot
 */
public class Category implements Serializable{

    private Integer id;
    private String code;
    private String cats1;
    private String cats2;
    private String cats3;
    private String cats4;
    private String parentCode;
    private String categoryName;

    private String grandfatherCode;
    private String greatGrandfatherCode;

    private String rootCode;
    private String rootName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCats1() {
        return cats1;
    }

    public void setCats1(String cats1) {
        this.cats1 = cats1;
    }

    public String getCats2() {
        return cats2;
    }

    public void setCats2(String cats2) {
        this.cats2 = cats2;
    }

    public String getCats3() {
        return cats3;
    }

    public void setCats3(String cats3) {
        this.cats3 = cats3;
    }

    public String getCats4() {
        return cats4;
    }

    public void setCats4(String cats4) {
        this.cats4 = cats4;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getGrandfatherCode() {
        return grandfatherCode;
    }

    public void setGrandfatherCode(String grandfatherCode) {
        this.grandfatherCode = grandfatherCode;
    }

    public String getGreatGrandfatherCode() {
        return greatGrandfatherCode;
    }

    public void setGreatGrandfatherCode(String greatGrandfatherCode) {
        this.greatGrandfatherCode = greatGrandfatherCode;
    }

    public String getRootCode() {
        return rootCode;
    }

    public void setRootCode(String rootCode) {
        this.rootCode = rootCode;
    }

    public String getRootName() {
        return rootName;
    }

    public void setRootName(String rootName) {
        this.rootName = rootName;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", cats1='" + cats1 + '\'' +
                ", cats2='" + cats2 + '\'' +
                ", cats3='" + cats3 + '\'' +
                ", cats4='" + cats4 + '\'' +
                ", parentCode='" + parentCode + '\'' +
                '}';
    }
}
