package com.baizhi.controller;

import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.vo.Fuzzy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 徐三
 * @company com.1999
 * @create 2019-11-27 22:54
 */

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService us;

    /*文件上传*/
    @ResponseBody
    @RequestMapping("/upload")
    public String upload(MultipartFile file, HttpSession session){
        //1. 获得 upload的路径
        String realPath = session.getServletContext().getRealPath("/upload/img");
        //2. 判断文件夹是否存在
        System.out.println(realPath);
        File file1 = new File(realPath);
        if(!file1.exists()){
            file1.mkdirs();
        }
        //3.获取文件真实名字
        String originalFilename = file.getOriginalFilename();

        //4. 为了防止同一个文件多次上传发生覆盖  拼接时间戳
        String name = new Date().getTime()+"_"+originalFilename;

        //5.文件上传
        try {
            file.transferTo(new File(realPath,name));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "上传成功";
    }


    /*模糊查询*/
    @ResponseBody
    @RequestMapping("/fuzzyQuery")
    public List<User> fuzzyQuery(User user,Model model){
        return us.fuzzyQuery(user);
    }
    /*查询所有*/
    @ResponseBody
    @RequestMapping("/queryAll")
    public List<User> queryAll(Model model){
        List<User> users = us.queryAll();
        model.addAttribute("users",users);
        return users;
    }

    /*分页查询*/
    @ResponseBody
    @RequestMapping("pageQuery")
    public Map<String,Object> pageQuery(Fuzzy fuzzy){
        return us.queryPager(fuzzy).getMap();
    }

    /*曾删改*/
    @RequestMapping("edit")
    public void edit(String oper,User user,Integer id){
        //增加
        if ("add".equals(oper)){
            us.insertUser(user);
        }
        //删除
        if ("del".equals(oper)){
            us.deleteUserById(id);
        }
        //修改
        if ("edit".equals(oper)){
            us.updateUser(user);
        }

    }
    /*id查询*/
    @ResponseBody
    @RequestMapping("queryByUserId")
    public User queryByUserId(String id){
        return us.queryUserById(Integer.parseInt(id));
    }

/*    *//*添加*//*
    @ResponseBody
    @RequestMapping("/insertUser")
    public String insertUser(User user){
        user.setRegist_time(new Date());
        us.insertUser(user);
        return null;
    }

    *//*删除*//*
    @ResponseBody
    @RequestMapping("/deleteUser")
    public String deleteUser(Integer id){
        us.deleteUserById(id);
        return null;
    }

    *//*修改*//*
    @ResponseBody
    @RequestMapping("/updateUser")
    public String updateUser(User user, HttpServletRequest request){
        us.updateUser(user);
        return null;
    }*/
}
