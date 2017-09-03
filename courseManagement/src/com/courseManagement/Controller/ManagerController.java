package com.courseManagement.Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.courseManagement.Service.ManagerService;
import com.courseManagement.hibernate.Course;
import com.courseManagement.hibernate.Experiment;
import com.courseManagement.hibernate.Maker;
import com.courseManagement.hibernate.Manager;

/**
 * 用@Controller标记为控制层
 * 
 * @author qin
 *
 */
@Controller
public class ManagerController
{
	//自动扫描为Bean
    @Autowired
    public ManagerService managerservice;
    /*
     * 课程制作者登录使用的验证方法
     * 验证用户名和密码是否都正确。
     */
    @RequestMapping("/managerLogin")
    public String managerLogin(Manager manager,HttpServletRequest request){

        String ret = "error";
        //调用service层的登录方法
        Manager loginmanager = managerservice.managerLogin(manager.getName());
        //验证用户名和密码
        if (manager.getName()!=null) {
            if (loginmanager.getName().equals(manager.getName()) && loginmanager.getPassword().equals(manager.getPassword())) {
                //后台Controller之间的跳转
                ret =  "redirect:/selectCourse";
            }else{
                ret = "error";
            }
        }else {
            ret = "error";
        }
        return ret;
    }

    /*
     * 查找全部课程信息
     * 用于主页显示课程
     */
    @RequestMapping("/selectCourse")
    public String selectCourse(HttpServletRequest request){

        try {
            //用于接收查询结果的courselist。
            List<Course> courselist = new ArrayList<Course>();
            courselist = managerservice.selectCourse();
            //将查询记录结果放入requset中。
            request.setAttribute("courselist", courselist);
            return "indexM";
        } catch (Exception e) {
            System.out.println(e);
            return "error";
        }

    }
        /*
         * 查看课程下的实验的具体信息
         */
    @RequestMapping("/seeExperimentInfo")
    public String seeExpermentInfo(HttpServletRequest request){

        try {
            //接收课程ID
            String courseid = request.getParameter("id");
            int courseId = Integer.parseInt(courseid);
            //接收查询结果
            List<Experiment> experiment = new ArrayList<Experiment>();
            experiment = managerservice.seeExpermentInfo(courseId);
            //将查询出来的experiment放入request 中
            request.setAttribute("experiment", experiment);

            return "seeExperimentinfo";
        } catch (Exception e) {
            System.out.println(e);
            return "error";
        }

    }

    /*
     * 删除课程信息
     */
    @RequestMapping("/delcourseinfo")
    public String delcourseinfo(HttpServletRequest request){
        try {
            //接收课程Id
            String courseid = request.getParameter("id");
            int courseId = Integer.parseInt(courseid);
            //调用删除方法
            this.managerservice.delcourseinfo(courseId);
            return "delCsuccess";
        } catch (Exception e) {
            System.out.println(e);
            return "error";
        }

    }
    /*
     * 更新课程信息
     */
    @RequestMapping("/updcourseinfo")
    public String updcourseinfo(HttpServletRequest request){
        try {    
            //接收目标课程Id
            String courseid = request.getParameter("id");
            int courseId = Integer.parseInt(courseid);
            //根据课程Id查找课程
            Course course = managerservice.selectCourseById(courseId);
            List<Maker> makers = new ArrayList<Maker>();
            //查找全部的课程制作者
            makers=managerservice.selectMaker();
            //将结果放入request便于前台取用
            request.setAttribute("makers", makers);
            request.setAttribute("course", course);
            return "updcourseinfo";
        } catch (Exception e) {
            System.out.println(e);
            return "error";
        }

    }
    /*
     * 查找全部的课程制作者
     */
    @RequestMapping("/selectMaker")
    public String selectMaker(HttpServletRequest request){
        try {
            List<Maker> makers = new ArrayList<Maker>();
            makers=managerservice.selectMaker();
            //将查询结果放在rquest
            request.setAttribute("makers", makers);
            return "addCourse";
        } catch (Exception e) {
            System.out.println(e);
            return "error";
        }

    }
    /*
     * 添加课程信息
     */
    @RequestMapping("/addCourse")
    public String addCourse(Course course){
        try {
             //获取当前时间
               Date currentTime = new Date();
               //将日期转化为指定 格式
               SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
               String dateString = formatter.format(currentTime);
               //将时间赋值给实体
               course.setTime(dateString);
               //调用添加方法
               this.managerservice.addCourse(course);
               return "addCsuccess";
        } catch (Exception e) {
            System.out.println(e);
            return "error";
        }

    }
    /*
     * 执行更新操作
     */
    @RequestMapping("/update")
    public String updateCourse(Course course){
        try {
            //调用更新方法，注意save方法需要传入的是一个实体类的对象
            this.managerservice.updcourseinfo(course);
            return "updateSuccess";
        } catch (Exception e) {
            return "error";
        }
    }

}
