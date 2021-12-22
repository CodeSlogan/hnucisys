package com.codeslogan.service;

import com.codeslogan.pojo.User;
import com.codeslogan.pojo.UserMessage;

public interface UserMessageService {
    public void addMessage(UserMessage userMessage);

    // 根据发送方id查询
    public UserMessage queryMegByWuid(int wuid);

    // 根据接收方id查
    public UserMessage queryMegByGuid(int guid);

    // 根据信息id查
    public UserMessage queryMegByMegid(int messageid);
}
