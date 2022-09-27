package com.yang.Service;

import com.yang.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
}
