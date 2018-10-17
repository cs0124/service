package com.dtelec.icmes.information.repository.entity;

import java.util.Date;

/**
 * 位置信息Entity
 * 作者：孔轩
 */
public class LocationEntity {

    /**
     * 位置Id
     */
    private int id;
    
    /**
     * 位置编码
     */
    private String code;

    /**
     * 名称
     */
    private String name;

    private String fullName;

    private String parentFullName;

    /**
     * 层级关系
     */
    private int parentId;

    /**
     * 父级位置编码
     */
    private String parentCode;

    /**
     * 用于高并发的数据版本控制
     */
    private String versionTag;

    /**
     * 位置信息创建时间
     */
    private Date createTime;
    /**
     * 位置信息更新时间
     */
    private Date updateTime;

    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }
    
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    public String getFullName() {
      return fullName;
    }

    public void setFullName(String fullName) {
      this.fullName = fullName;
    }

    public String getParentFullName() {
      return parentFullName;
    }

    public void setparentName(String parentFullName) {
      this.parentFullName = parentFullName;
    }

    public int getParentId() {
      return parentId;
    }

    public void setParentId(int parentId) {
      this.parentId = parentId;
    }

    public String getParentCode() {
      return parentCode;
    }

    public void setParentCode(String parentCode) {
      this.parentCode = parentCode;
    }

    public String getVersionTag() {
      return versionTag;
    }
  
    public void setVersionTag(String versionTag) {
      this.versionTag = versionTag;
    }
    public Date getCreateTime() {
      return createTime;
    }
  
    public void setCreateTime(Date createTime) {
      this.createTime = createTime;
    }
  
    public Date getUpdateTime() {
      return updateTime;
    }
  
    public void setUpdateTime(Date updateTime) {
      this.updateTime = updateTime;
    }
}