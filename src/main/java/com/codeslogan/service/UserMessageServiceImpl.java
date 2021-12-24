package com.codeslogan.service;

import com.codeslogan.mapper.UserMessageMapper;
import com.codeslogan.pojo.UserMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class UserMessageServiceImpl implements UserMessageService {

    @Autowired
    UserMessageMapper userMessageMapper;

    @Override
    public void addMessage(UserMessage userMessage) {
        userMessageMapper.addMessage(userMessage);
    }

    @Override
    public void delMessage(int messageid) {
        userMessageMapper.delMessage(messageid);
    }

    @Override
    public void replyMessage(UserMessage message) {
        userMessageMapper.replyMessage(message);
    }

    @Override
    public Collection<UserMessage> queryMegByWuid(int wuid) {
        return userMessageMapper.queryMegByWuid(wuid);
    }

    @Override
    public Collection<UserMessage> queryMegByGuid(int guid) {
        return userMessageMapper.queryMegByGuid(guid);
    }

    @Override
    public UserMessage queryMegByMegid(int messageid) {
        return userMessageMapper.queryMegByMegid(messageid);
    }
}
