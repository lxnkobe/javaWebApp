package com.ning.serviceimpl;

import com.ning.domain.User;
import com.ning.services.BasicService;
import com.ning.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ning on 12/8/15.
 */

@Service("basicService")
public class BasicServiceImpl implements BasicService{

    @Autowired
    private UserService userService;

    public User getLoginAdmin(String key) {
        return null;
    }

    @Override
    public User getLoginAdmin() {
        return null;
    }

    @Override
    public User getLoginByUserId(String name) {
        return userService.findByUsername(name);
    }
}
