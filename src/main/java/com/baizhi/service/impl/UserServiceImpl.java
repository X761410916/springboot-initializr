package com.baizhi.service.impl;

import com.baizhi.dao.UserDao;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.vo.Fuzzy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * @author 徐三
 * @company com.1999
 * @create 2019-11-28 10:17
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao ud;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> fuzzyQuery(User user) {
        return ud.fuzzyQuery(user);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Fuzzy queryPager(Fuzzy fuzzy) {
        /*
        * jqGrid： 要求返回数据为
        * page:当前页
        * rows:数据
        * total:总页数
        * records:总条数
        * */
        //总条数
        Integer count = ud.queryUserCount();
        fuzzy.setTotal(count);
        fuzzy.setStart(fuzzy.getPage());
        HashMap<String, Object> map = new HashMap<>();
        map.put("page",fuzzy.getPage());
        map.put("rows",ud.queryByPage(fuzzy));
        map.put("total",fuzzy.getTotal());
        map.put("records",count);
        fuzzy.setMap(map);
        return fuzzy;
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<User> queryAll() {
        return ud.queryAll();
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public User queryUserById(Integer userId) {
        return ud.queryUserById(userId);
    }

    @Override
    @Transactional
    public void insertUser(User user) {
        ud.insertUser(user);
    }

    @Override
    @Transactional
    public void deleteUserById(Integer userId) {
        ud.deleteUserById(userId);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        ud.updateUser(user);
    }
}
