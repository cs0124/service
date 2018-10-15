package com.dtelec.icmes.information.service.model;

import com.dtelec.icmes.information.repository.entity.LocationFullNameEntity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 位置信息(全部名称)model
 * 作者：孔轩
 */
@ApiModel
public class LocationFullNameModel {
	@ApiModelProperty(value = "位置信息ID")
    private int id;
    @ApiModelProperty(value = "位置信息编码")
    private String code;
	@ApiModelProperty(value = "位置信息名称")
	private String name;
	@ApiModelProperty(value = "位置信息全称")
	private String fullName;
	@ApiModelProperty(value = "父级位置信息ID")
    private int parentId;
    @ApiModelProperty(value = "父级位置信息编码")
    private String parentCode;
	@ApiModelProperty(value = "父级位置信息全称")
	private String parentFullName;
	@ApiModelProperty(value = "版本标志")
	private String versionTag;
	@ApiModelProperty(value = "是否有子集")
	private Boolean hasChild;
	
	/**
	 * 给模型赋值
	 * @param entity 位置全名实体类
	 */
	public void fillModel(LocationFullNameEntity entity) {
        this.id = entity.getId();
        this.code = entity.getCode();
        this.name = entity.getName();
		this.fullName = entity.getFullName();
        this.parentId = entity.getParentId();
        this.parentCode = entity.getParentCode();
		this.versionTag = entity.getVersionTag();
		this.hasChild = entity.getHasChild();
		this.parentFullName = entity.getParentFullName();
	}

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

	public Boolean getHasChild() {
		return hasChild;
	}

	public void setHasChild(Boolean hasChild) {
		this.hasChild = hasChild;
	}

	public String getParentFullName() {
		return parentFullName;
	}

	public void setParentFullName(String parentFullName) {
		this.parentFullName = parentFullName;
	}

	public String getVersionTag() {
		return versionTag;
	}

	public void setVersionTag(String versionTag) {
		this.versionTag = versionTag;
	}

}