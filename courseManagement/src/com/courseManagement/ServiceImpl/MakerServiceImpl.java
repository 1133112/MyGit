package com.courseManagement.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courseManagement.Service.MakerService;
import com.courseManagement.dao.MakerDao;
import com.courseManagement.hibernate.Course;
import com.courseManagement.hibernate.Experiment;
import com.courseManagement.hibernate.Maker;
/**
 * 
 * @Service标注服务层
 *
 */
@Service
public class MakerServiceImpl implements MakerService{
    @Autowired
    private MakerDao makerdao;
    //重写方法，调用dao层
    @Override
    public Maker makerLogin(String name) {
        Maker loginmaker = makerdao.makerLogin(name);
        return loginmaker;
    }

    @Override
    public List<Course> selectCourseBymaekrId(int makerId) {
        List<Course> list = makerdao.selectCourseBymaekrId(makerId);
        return list;
    }

    @Override
    public void makerReg(Maker maker) {
            this.makerdao.makerReg(maker);

    }

    @Override
    public void addExpermentInfo(Experiment experiment) {
    this.makerdao.addExpermentInfo(experiment);
    }

    @Override
    public Course selectCourseByCourseId(int courseId1) {
        Course courseId = makerdao.selectCourseByCourseId(courseId1);
        return courseId;
    }

    @Override
    public void updateE(Experiment experiment) {
        this.makerdao.updateE(experiment);
    }
}