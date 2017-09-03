package com.courseManagement.Service;

import java.util.List;

import com.courseManagement.hibernate.Course;
import com.courseManagement.hibernate.Experiment;
import com.courseManagement.hibernate.Maker;
import com.courseManagement.hibernate.Manager;

public interface ManagerService
{
	Manager managerLogin(String name);// 登录验证

	List<Course> selectCourse();// 查找课程

	List<Experiment> seeExpermentInfo(int courseId);// 查找实验信息

	void delcourseinfo(int courseId);// 删除课程

	List<Maker> selectMaker();// 查找所有制作者

	void addCourse(Course course);// 添加课程

	void updcourseinfo(Course course);// 更新课程

	Course selectCourseById(int courseId);// 根据Id查找课程
}
