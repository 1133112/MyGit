package com.courseManagement.Service;

import java.util.List;

import com.courseManagement.hibernate.Course;
import com.courseManagement.hibernate.Experiment;
import com.courseManagement.hibernate.Maker;

public interface MakerService {
    //登陆
    Maker makerLogin(String name);
    //查找课程        
    List<Course> selectCourseBymaekrId(int makerId);
    //注册
    void makerReg(Maker maker);
    //添加实验信息    
    void addExpermentInfo(Experiment experiment);
    //查找课程    
    Course selectCourseByCourseId(int courseId1);
    //更新操作
    void updateE(Experiment experiment);



}