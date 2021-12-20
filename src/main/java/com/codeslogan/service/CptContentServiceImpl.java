package com.codeslogan.service;

import com.codeslogan.mapper.CptContentMapper;
import com.codeslogan.pojo.CptContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: codeslogan
 * @Date: 2021-12-17 16:15
 */
@Service
public class CptContentServiceImpl implements CptContentService{

    @Autowired
    CptContentMapper cptContentMapper;

    @Override
    public CptContent queryCptContentById(int id) {
        return cptContentMapper.queryCptContentById(id);
    }
}
