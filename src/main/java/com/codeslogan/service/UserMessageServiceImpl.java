package com.codeslogan.service;

import com.codeslogan.mapper.UserMessageMapper;
import com.codeslogan.pojo.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMessageServiceImpl implements UserMessageService{

    @Autowired
    UserMessageMapper userMessageMapper;

    @Override
    public void addMessage(UserMessage userMessage) {
        userMessageMapper.addMessage(userMessage);
    }
}
