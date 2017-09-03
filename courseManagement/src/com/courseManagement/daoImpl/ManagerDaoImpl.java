package com.courseManagement.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.courseManagement.dao.ManagerDao;
import com.courseManagement.hibernate.Course;
import com.courseManagement.hibernate.Experiment;
import com.courseManagement.hibernate.Maker;
import com.courseManagement.hibernate.Manager;

/**
 * 
 * @author qin 
 * 用@Repository标注Dao组件
 */
@Repository
public class ManagerDaoImpl implements ManagerDao
{
	// spring自动扫描注册
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Manager managerLogin(String name)
	{
		// TODO Auto-generated method stub
		List<Manager> manager = new ArrayList<Manager>();
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Manager where name=?").setParameter(0, name);
		manager = query.list();
		System.out.println(manager);
		// 返回符合条件的manager的信息
		if (manager.size() != 0)
		{
			return manager.get(0);
		} else
		{
			return null;
		}
	}

	@Override
	public List<Course> selectCourse()
	{
		// TODO Auto-generated method stub
		List<Course> courselist = new ArrayList<Course>();
		Session session = sessionFactory.getCurrentSession();
		// 执行原生sql语句后，要将结果集通过setter方法注入到实体Course中
		Query query = session.createSQLQuery("select * from course")
				.setResultTransformer(Transformers.aliasToBean(Course.class));
		courselist = query.list();
		return courselist;
	}

	@Override
	public List<Experiment> seeExpermentInfo(int courseId)
	{
		// TODO Auto-generated method stub
		List<Experiment> experiment = new ArrayList<Experiment>();
		Session session = sessionFactory.getCurrentSession();
		// 根据courseId查找实验信息
		Query query = session
				.createSQLQuery("select e.experimentId,e.eIntroduce,e.eTitle,e.time from experiment as e,"
						+ "course as c where e.courseId=? and " + "c.courseId=e.courseId")
				.setParameter(0, courseId).setResultTransformer(Transformers.aliasToBean(Experiment.class));
		experiment = query.list();
		return experiment;
	}

	/*
	 * 删除选中的课程 同时级联删除课程下的所有实验类容
	 */
	@Override
	public void delcourseinfo(int courseId)
	{
		// TODO Auto-generated method stub
		/*
		 * 在这里我们使用的是getCurrentSession()方法 由于我们在配置文件中已经配置了OpenSessionInViewFilter，所以导致
		 * session在执行delete方法前就已经提交过了，所以我们需要在最后加上一个flush方法
		 */
		Session session = sessionFactory.getCurrentSession();
		// 加载Course实体类
		Course course = (Course) session.load(Course.class, courseId);
		// 执行删除
		session.delete(course);
		session.flush();
		// 如果使用的是Opensession()方法，那么我们需要手动的去提交事务并关闭session
		// 即在delete方法的后面加上
		// Transaction t = session.beginTransaction();
		// t.commit();
		// session.close();
	}

	@Override
	public void updcourseinfo(Course course)
	{
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		// 调用update方法后，和使用delete方法一样，都需要在之后使用flush方法，操作才能生效
		session.update(course);
		session.flush();
	}

	@Override
	public List<Maker> selectMaker()
	{
		// TODO Auto-generated method stub
		List<Maker> makers = new ArrayList<Maker>();
		Session session = sessionFactory.getCurrentSession();
		// 查找所有的课程制作者
		Query query = session.createSQLQuery("select * from maker")
				.setResultTransformer(Transformers.aliasToBean(Maker.class));
		makers = query.list();
		return makers;
	}

	@Override
	public void addCourse(Course course)
	{
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		// 直接调用save方法完成数据储存
		session.save(course);
	}

	@Override
	public Course selectCourseById(int courseId)
	{
		// TODO Auto-generated method stub
		List<Course> course = new ArrayList<Course>();
		Session session = sessionFactory.getCurrentSession();
		// 根据课程Id查找课程信息
		Query query = session.createQuery("from Course where courseId=?").setParameter(0, courseId);
		course = query.list();
		System.out.println(course);
		// 返回符合条件的manager的信息
		if (course.size() != 0)
		{
			return course.get(0);
		} else
		{
			return null;
		}
	}

}
