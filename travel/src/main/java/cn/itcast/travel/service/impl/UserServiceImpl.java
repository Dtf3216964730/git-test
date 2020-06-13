package cn.itcast.travel.service.impl;

import cn.itcast.travel.dao.UserDao;
import cn.itcast.travel.dao.impl.UserDaoImpl;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.util.MailUtils;
import cn.itcast.travel.util.UuidUtil;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    /**
     * 注册用户的方法
     * @param user
     * @return
     */
    @Override
    public boolean regist(User user) {
        User u  = userDao.findByUsername(user.getUsername());
        if (u != null){
            return false;
        }
        //保存用户信息
        user.setCode(UuidUtil.getUuid());
        user.setCode("N");
        userDao.save(user);
        //激活邮箱
        String content ="<a href='http://localhost/travel/activeUserServlet？code="+user.getCode()+"'>";
        MailUtils.sendMail(user.getEmail(),content,"激活邮箱");

        return false;
    }
}
