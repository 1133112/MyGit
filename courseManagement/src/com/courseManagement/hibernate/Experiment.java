package com.courseManagement.hibernate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name="experiment")
public class Experiment
{
	/**
	 * @id标识主键
	 * @GeneratedValue标识主键生成策略
	 * (strategy=GenerationType.IDENTITY)表示为自动增长的主键(只适用于mysql)
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="experimentId")
	private int experimentId;//主键
    private String eTitle;//实验标题
    private String eIntroduce;//实验简介
    private String time;//实验生成时间（类型为String的原因是会对日期进行格式转换）
    /*
     * @ManyToOne多对一
     * @JoinColum中：
     * name表示在本表中的外键的名字
     * referencedColumnName表示关联表的列名
     * 
     */
    @ManyToOne
    @JoinColumn(name="courseId",referencedColumnName = "courseId")
    private Course courseId;
	public int getExperimentId()
	{
		return experimentId;
	}
	public void setExperimentId(int experimentId)
	{
		this.experimentId = experimentId;
	}
	public String geteTitle()
	{
		return eTitle;
	}
	public void seteTitle(String eTitle)
	{
		this.eTitle = eTitle;
	}
	public String geteIntroduce()
	{
		return eIntroduce;
	}
	public void seteIntroduce(String eIntroduce)
	{
		this.eIntroduce = eIntroduce;
	}
	public String getTime()
	{
		return time;
	}
	public void setTime(String time)
	{
		this.time = time;
	}
	public Course getCourseId()
	{
		return courseId;
	}
	public void setCourseId(Course courseId)
	{
		this.courseId = courseId;
	}
    
}
