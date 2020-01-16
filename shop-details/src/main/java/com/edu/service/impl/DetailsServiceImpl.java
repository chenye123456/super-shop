package com.edu.service.impl;

import com.edu.pojo.GoodsPojo;
import com.edu.repository.DetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import service.DetailsService;

@Service
@com.alibaba.dubbo.config.annotation.Service
public class DetailsServiceImpl implements DetailsService {

    @Autowired
    DetailsRepository detailsRepository;

    @Override
    public GoodsPojo findByGid(int gid) {
        return detailsRepository.findByGid(gid);
    }
}
