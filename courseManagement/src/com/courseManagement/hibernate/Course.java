package com.courseManagement.hibernate;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

/**
 * 
 * @author qin
 *
 * maker表的实体类
 * 用@Entity标记为实体类
 * 用@Table标记对应的数据表
 */
@Entity
@Table(name="course")
public class Course
{
	/**
	 * @id标识主键
	 * @GeneratedValue标识主键生成策略
	 * (strategy=GenerationType.IDENTITY)表示为自动增长的主键(只适用于mysql)
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="courseId")
	private int courseId;//主键
	private String cTitle;
	private String cIntroduce;
	private String makerName;
	private String  time;
	private String State;
	
	//@OneToMany映射关系
    //CascadeType为级联属性（ALL表示全部级联，包括级联删除等）
    //@JoinColum为对应的多的一方的列

    @OneToMany(targetEntity=Experiment.class,orphanRemoval=true)
    @Cascade(value={CascadeType.ALL})
    @JoinColumn(name="courseId")
    private Set<Experiment> e = new HashSet<>(); 
    public Set<Experiment> getE()
	{
		return e;
	}
	public void setE(Set<Experiment> e)
	{
		this.e = e;
	}
	public int getCourseId()
	{
		return courseId;
	}
	public void setCourseId(int courseId)
	{
		this.courseId = courseId;
	}
	public String getcTitle()
	{
		return cTitle;
	}
	public void setcTitle(String cTitle)
	{
		this.cTitle = cTitle;
	}
	public String getcIntroduce()
	{
		return cIntroduce;
	}
	public void setcIntroduce(String cIntroduce)
	{
		this.cIntroduce = cIntroduce;
	}
	public String getMakerName()
	{
		return makerName;
	}
	public void setMakerName(String makerName)
	{
		this.makerName = makerName;
	}
	public String getTime()
	{
		return time;
	}
	public void setTime(String time)
	{
		this.time = time;
	}
	public String getState()
	{
		return State;
	}
	public void setState(String state)
	{
		State = state;
	}
	
	

}
