package com.mrcai.app.service;

import com.mrcai.app.auth.Token;
import com.mrcai.app.repository.UserOperation;
import com.mrcai.app.service.serviceImp.UserServiceImp;
import com.mrcai.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Administrator on 2017/4/6.
 */
@Service
public class UserService implements UserServiceImp {

    @Autowired
    private UserOperation userOperation;

    @Override
    public boolean isExist(Long userName) {
        return findUserByUserName(userName) != null;
    }

    @Override
    public User findUserByUserName(Long userName) {
        User user = userOperation.findByUserName(userName);
        if (user == null)
            return null;
        return user;
    }

    @Override
    public boolean addUser(Long userName, String password, int userType) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        user.setUserType(userType);
        user.setUserRegisterDate(new Date());
        userOperation.addUser(user);
        return isExist(userName);
    }

    @Override
    public boolean checkPassword(Long userName, String password) {
        return findUserByUserName(userName).getPassword().equals(password);
    }

    @Override
    public String updateToken(Long userName) {
        String userToken = new String(Token.userToToken(findUserByUserName(userName)).getSignature());
        if (!userOperation.updateUserToken(userName, userToken))
            return null;
        return userToken;
    }

}
