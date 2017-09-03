package com.courseManagement.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.support.SessionAttributeStore;

import com.courseManagement.dao.MakerDao;
import com.courseManagement.hibernate.Course;
import com.courseManagement.hibernate.Experiment;
import com.courseManagement.hibernate.Maker;
/**
 * 
 * @Repository标注daoImpl层
 *
 */
@Repository
public class MakerDaoImpl implements MakerDao{
    @Autowired
     private SessionFactory sessionFactory;
    @Override
    public Maker makerLogin(String name) {
        List<Maker> maker = new ArrayList<Maker>();
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Maker where name=?").setParameter(0, name);
        maker = query.list();
        System.out.println(maker);
        //返回符合条件的manager的信息
        if(maker.size()!=0){
            return maker.get(0);
        } else{
        return null;
        }
    }
    @SuppressWarnings("unchecked")
    @Override
    public List<Course> selectCourseBymaekrId(int makerId) {
        List<Course> courses = new ArrayList<Course>();
        Session session = sessionFactory.getCurrentSession();
        //执行原生语句后将结果通过set方法注入到Course中
        Query query = session.createSQLQuery("select c.courseId,c.State,c.cIntroduce,c.cTitle,c.makerName,c.time"
                + " from course as c,maker as m where m.makerId=? and "
                + "m.name=c.makerName").setInteger(0, makerId).setResultTransformer
                (Transformers.aliasToBean(Course.class));
        courses = query.list();

        return courses;
    }
    @Override
    public void makerReg(Maker maker) {
        Session session = sessionFactory.getCurrentSession();
        //直接调用save方法
        session.save(maker);
    }
    @Override
    public void addExpermentInfo(Experiment experiment) {
        Session session = sessionFactory.getCurrentSession();
        session.save(experiment);

    }
    @Override
    public Course selectCourseByCourseId(int courseId1) {
        List<Course> courses = new ArrayList<Course>();
        Session session = sessionFactory.getCurrentSession();
        //单表查询执行hql语句
        Query query = session.createQuery("from Course where courseId=?").setInteger(0, courseId1);
        courses = query.list();    
        if (courses.size()>0) {
            return courses.get(0);
        }else{
            return null;
        }

    }
    @Override
    public void updateE(Experiment experiment) {
        Session session = sessionFactory.getCurrentSession();
        Query  query = session.createSQLQuery("update experiment set eTitle=?,eIntroduce=? where experimentId=?");
        query.setParameter(0, experiment.geteTitle());
        query.setParameter(1, experiment.geteIntroduce());
        query.setParameter(2, experiment.getExperimentId());
        query.executeUpdate();
        session.flush();
    }

}