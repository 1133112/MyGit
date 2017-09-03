package com.courseManagement.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courseManagement.Service.ManagerService;
import com.courseManagement.dao.ManagerDao;
import com.courseManagement.hibernate.Course;
import com.courseManagement.hibernate.Experiment;
import com.courseManagement.hibernate.Maker;
import com.courseManagement.hibernate.Manager;

/**
 * 用@Service标注service层
 * 
 * @author qin
 *
 */
@Service
public class ManagerServiceImpl implements ManagerService
{
	// 自动扫描
	@Autowired
	public ManagerDao managerdao;

	@Override
	public Manager managerLogin(String name)
	{
		Manager manager = managerdao.managerLogin(name);
		return manager;
	}

	@Override
	public List<Course> selectCourse()
	{
		List<Course> list = managerdao.selectCourse();
		return list;
	}

	@Override
	public List<Experiment> seeExpermentInfo(int courseId)
	{
		List<Experiment> experiment = managerdao.seeExpermentInfo(courseId);
		return experiment;
	}

	@Override
	public void delcourseinfo(int courseId)
	{
		this.managerdao.delcourseinfo(courseId);
	}

	@Override
	public List<Maker> selectMaker()
	{
		List<Maker> makers = managerdao.selectMaker();
		return makers;
	}

	@Override
	public void addCourse(Course course)
	{
		this.managerdao.addCourse(course);
	}

	@Override
	public void updcourseinfo(Course course)
	{
		this.managerdao.updcourseinfo(course);
	}

	@Override
	public Course selectCourseById(int courseId)
	{
		Course course = managerdao.selectCourseById(courseId);
		return course;
	}

}
