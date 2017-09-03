package com.courseManagement.Controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.courseManagement.Service.MakerService;
import com.courseManagement.Service.ManagerService;
import com.courseManagement.hibernate.Course;
import com.courseManagement.hibernate.Experiment;
import com.courseManagement.hibernate.Maker;
/**
 * 
 *用@Controller标注控制层
 */

@Controller
public class MakerController {
    //spring 自动扫描加载为bean
    @Autowired
    private MakerService makerservice;
    @Autowired
    private ManagerService managerservice;
    /*
     * 课程制作者登录
     */

    @RequestMapping("/makerLogin")
    public String makerLogin(Maker maker,RedirectAttributes model){
        String ret = "error";
        //调用service层的登录方法
        Maker loginmaker = makerservice.makerLogin(maker.getName());
        //验证用户名和密码
        if (maker.getName()!=null) {
            if (loginmaker.getName().equals(loginmaker.getName()) && loginmaker.getPassword().
                        equals(loginmaker.getPassword())) {
                //Controller之间的传值，用model
                model.addAttribute("makerId",loginmaker.getMakerId());
                //跳转到另一个Controller
                ret =  "redirect:/selectCourseBymakerId";
            }else{
                ret = "error";
            }
        }else {
            ret = "error";
        }
        return ret;
    }
    /*
     * 登录成功后显示主页
     * 根据制作者ID查找课程
     */
    @RequestMapping("/selectCourseBymakerId")
    public String selectCourseBymaekrId(@ModelAttribute("makerId") int makerId,
            HttpServletRequest request,HttpSession session){
        try {
            List<Course> courselist = new ArrayList<Course>();
            //查找课程
            courselist = makerservice.selectCourseBymaekrId(makerId);
            //将值传到页面
            request.setAttribute("courselist", courselist);
            session.setAttribute("makerId", makerId);
            return "indexMa";
        } catch (Exception e) {
            System.out.println(e);
            return "error";
        }
    }
    /*
     * 注册
     */
    @RequestMapping("/makerReg")
    public String makerReg(Maker maker){
        try {
            //调用注册方法
            this.makerservice.makerReg(maker);
            return "registerSuccess";
        } catch (Exception e) {

            return "error";
        }
    }
    /*
     * 添加课程实验
     */
    @RequestMapping("/addExperimentInfo")
    public String addExpermentInfo(Experiment experiment,HttpServletRequest request){

        int courseId1 = Integer.parseInt(request.getParameter("id"));
        //获取当前时间
        Date currentTime = new Date();
         //将日期转化为指定 格式
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(currentTime);
        //将日期set到experiment实体中
        experiment.setTime(dateString);
        request.setAttribute("courseId", courseId1);
        //由于experiment中courseId是Course类型的对象，所以要先根据课程id获得course对象
        Course courseId = makerservice.selectCourseByCourseId(courseId1);
        experiment.setCourseId(courseId);
        try {
            //添加实验
            this.makerservice.addExpermentInfo(experiment);
            return "addEsuccess";
        } catch (Exception e) {
            return "error";
        }
    }
    /*
     * 课程制作者查看课程实验
     */
    @RequestMapping("/MakerseeExperimentInfo")
    public String MakerseeExpermentInfo(HttpServletRequest request){
        try {
            //获取课程ID和制作者ID
            String courseid = request.getParameter("id");
            String makerId1 = request.getParameter("makerId");
            //传值到页面
            request.setAttribute("makerId", makerId1);
            int courseId = Integer.parseInt(courseid);
            List<Experiment> experiment = new ArrayList<Experiment>();
            //查找课程实验
            experiment = managerservice.seeExpermentInfo(courseId);
            request.setAttribute("experiment", experiment);

            return "MakerseeExperimentInfo";
        } catch (Exception e) {
            System.out.println(e);
            return "error";
        }

    }
    /*
     * 显示课程实验页面有返回按钮，由于是页面传值
     * 不同于前面的selectCourseBymakerId是Controller之间传值
     * 所以新写一个方法，接收页面传的makerId
     * 新方法调用的和selectCourseBymakerId调用的方法一样
     * 只是接收makerId的方法不同
     */
    @RequestMapping("/selectCourseBymakerId2")
    public String selectCourseBymaekrId2(HttpServletRequest request,HttpSession session){
        try {
            //接收页面传的makerId
            String id = request.getParameter("id");
            int makerId=Integer.parseInt(id);
            List<Course> courselist = new ArrayList<Course>();
            courselist = makerservice.selectCourseBymaekrId(makerId);
            request.setAttribute("courselist", courselist);
            session.setAttribute("makerId", makerId);
            return "indexMa";
        } catch (Exception e) {
            System.out.println(e);
            return "error";
        }
    }
    /*
     * 更新课程实验信息
     * 本方法起着中转作用
     * 并不执行更新数据的操作
     */
    @RequestMapping("/updExperimentinfo")
    public String updExperimentinfo(HttpServletRequest request){
        try {
            //接收experimentId和makerId
            String id = request.getParameter("id");
            String makerId = request.getParameter("makerId");
            System.out.println("makerId="+makerId);
            int experimentid=Integer.parseInt(id);
            request.setAttribute("experimentid", experimentid);
            request.setAttribute("makerId", makerId);
            return "updExperimentinfo";
        } catch (Exception e) {
            System.out.println(e);
            return "error";
        }
    }
    /*
     * 执行更新操作
     */
    @RequestMapping("/updateE")
    public String updateE(Experiment experiment,HttpSession session,HttpServletRequest request){
        try {
            //执行更新操作
            this.makerservice.updateE(experiment);
            String makerId1=request.getParameter("makerId");
            //将值传递给页面，用于返回查看课程实验页面（因为selectCourseBymakerId2需要获得一个makerIds）
            session.setAttribute("makerId", makerId1);
            return "updateEsuccess";
        } catch (Exception e) {
            System.out.println(e);
            return "error";
        }
    }
}