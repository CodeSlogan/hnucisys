package com.codeslogan.service;

import com.codeslogan.pojo.User;
import com.codeslogan.pojo.UserMessage;

import java.util.Collection;

public interface UserMessageService {
    public void addMessage(UserMessage userMessage);

    public void delMessage(int messageid);

    // 根据发送方id查询
    public Collection<UserMessage> queryMegByWuid(int wuid);

    // 根据接收方id查
    public Collection<UserMessage> queryMegByGuid(int guid);

    // 根据信息id查
    public UserMessage queryMegByMegid(int messageid);
}
