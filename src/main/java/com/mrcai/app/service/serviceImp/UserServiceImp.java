package com.mrcai.app.service.serviceImp;

import com.mrcai.model.User;

/**
 * Created by Administrator on 2017/4/7.
 */
public interface UserServiceImp {
    /**
     * 用户是否已经存在
     * @param userName 用户名，手机号
     * @return
     */
    boolean isExist(Long userName);

    /**
     * 通过用户名查找
     * @param userName 用户名，手机号
     * @return
     */
    User findUserByUserName(Long userName);

    /**
     * 添加新用户
     * @param userName 用户名
     * @param password 密码
     * @param userType 用户类型
     * @return
     */
    boolean addUser(Long userName, String password, int userType);

    /**
     * 检验用户名和密码是否正确
     * @param userName
     * @param password
     * @return
     */
    boolean checkPassword(Long userName, String password);

    /**
     * 更新token
     * @param userName 手机号
     * @return
     */
    String updateToken(Long userName);
}
