package com.courseManagement.dao;

import java.util.List;

import com.courseManagement.hibernate.Course;
import com.courseManagement.hibernate.Experiment;
import com.courseManagement.hibernate.Maker;

public interface MakerDao {

    Maker makerLogin(String name);

    List<Course> selectCourseBymaekrId(int makerId);

    void makerReg(Maker maker);

    void addExpermentInfo(Experiment experiment);

    Course selectCourseByCourseId(int courseId1);

    void updateE(Experiment experiment);

}