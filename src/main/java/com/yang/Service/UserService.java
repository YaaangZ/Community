package com.yang.Service;

import com.yang.Model.User;
import com.yang.Model.UserExample;
import com.yang.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public void createOrUpdate(User user) {
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andAccountIdEqualTo(user.getAccountId());
        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() == 0) {
            // do inserting
            user.setGmtCreate(System.currentTimeMillis());
            user.setGmtModified(user.getGmtCreate());
            userMapper.insert(user);
        } else {
            // do updating
            User dbUser = users.get(0);
            User updateUser = new User();
            UserExample userExample1 = new UserExample();
            updateUser.setGmtModified(System.currentTimeMillis());
            updateUser.setPhotoUrl(user.getPhotoUrl());
            updateUser.setName(user.getName());
            updateUser.setToken(user.getToken());
            userExample1.createCriteria()
                    .andIdEqualTo(dbUser.getId());
            userMapper.updateByExampleSelective(updateUser, userExample1);
        }
    }
}
