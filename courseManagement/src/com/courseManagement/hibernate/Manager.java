package com.courseManagement.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author qin
 *
 * maker表的实体类
 * 用@Entity标记为实体类
 * 用@Table标记对应的数据表
 */
@Entity
@Table(name="manager")
public class Manager
{
	/**
	 * @id标识主键
	 * @GeneratedValue标识主键生成策略
	 * (strategy=GenerationType.IDENTITY)表示为自动增长的主键(只适用于mysql)
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="managerId")
	private int managerId;//主键
    private String name;//课程管理者姓名
    private String password;//密码
	public int getManagerId()
	{
		return managerId;
	}
	public void setManagerId(int managerId)
	{
		this.managerId = managerId;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password; 
	}
	

}
