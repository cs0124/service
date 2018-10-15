package com.dtelec.icmes.information.repository.entity;

/**
 * 工艺实体类
 *
 */
public class ProcessEntity {
	/**标识符*/
	private int id;
	/**工艺编码*/
	private String code;
	/**工艺名称*/
	private String name;
	/**用于高并发版本控制*/
	private String versionTag;
	/**创建时间*/
	private long createTime;
	/**修改时间*/
	private long updateTime;
	
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
	public String getVersionTag() {
		return versionTag;
	}
	public void setVersionTag(String versionTag) {
		this.versionTag = versionTag;
	}
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	public long getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(long updateTime) {
		this.updateTime = updateTime;
	}
	
	
}
