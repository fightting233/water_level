package com.mrcai.app.repository;

import com.mongodb.WriteResult;
import com.mrcai.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/4/18.
 */
@Service
public class UserOperation {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    MongoOperations operations;

    /**
     * 更改密码
     * @param userName
     * @param password
     * @return
     */
    public boolean updatePassword(Long userName, String password){
        WriteResult writeResult= operations.updateFirst(
                new Query(new Criteria("userName").is(userName)),
                new Update().set("password", password),
                User.class);
        System.out.println(writeResult.toString());
        return writeResult.isUpdateOfExisting();
    }

    /**
     * 更新token
     * @param userName
     * @param token
     * @return
     */
    public boolean updateUserToken(Long userName, String token){
        WriteResult writeResult = operations.updateFirst(new Query(new Criteria("userName").is(userName)),
                new Update().set("token", token), User.class);
        System.out.println(writeResult.toString());
        return writeResult.isUpdateOfExisting();
    }

    /**
     * 通过手机号查找用户
     * @param userName
     * @return
     */
    public User findByUserName(Long userName){
        return operations.findOne(new Query(new Criteria("userName").is(userName)), User.class);
    }

    /**
     * 添加一个用户
     * @param user
     */
    public void addUser(User user){
        operations.insert(user);
    }

    /**
     * 删除一个用户
     * @param userName
     * @return
     */
    public boolean deleteUser(Long userName){
        WriteResult writeResult = operations.remove(new Query(new Criteria("userName").is(userName)), User.class);
        System.out.println(writeResult.toString());
        return writeResult.isUpdateOfExisting();
    };

}
