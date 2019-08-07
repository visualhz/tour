package com.gxu.tour.service.Impl;

import com.gxu.tour.entity.Identity;
import com.gxu.tour.entity.Log;
import com.gxu.tour.entity.SoucreOfAccess;
import com.gxu.tour.entity.User;
import com.gxu.tour.mapper.UserAndLogMapping;
import com.gxu.tour.service.UserAndLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserAndLogServiceImpl implements UserAndLogService {

    @Autowired
    UserAndLogMapping userAndLogMapping;

    @Override
    public Log getLogById(Integer id) {
        return userAndLogMapping.getLogById(id);
    }

    @Override
    public SoucreOfAccess getNumbersOfAccessSource(int year, int month) {
        return userAndLogMapping.getNumbersOfAccessSource(year, month);
    }

    @Override
    public User getUserById(Integer id) {
        return userAndLogMapping.getUserById(id);
    }

    @Override
    public List<User> getUsers() {
        return userAndLogMapping.getAllUser();
    }

    @Override
    public List<Identity> getVisitorIdentityStatistics() {
        return userAndLogMapping.getVisitorIdentityStatistics();
    }

}
