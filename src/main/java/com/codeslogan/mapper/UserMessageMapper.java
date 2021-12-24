package com.codeslogan.mapper;

import com.codeslogan.pojo.UserMessage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Mapper
@Repository
public interface UserMessageMapper {
    public void addMessage(UserMessage userMessage);

    public void delMessage(int messageid);

    public void replyMessage(UserMessage message);

    // 根据发送方id查询
    public Collection<UserMessage> queryMegByWuid(int wuid);

    // 根据接收方id查
    public Collection<UserMessage> queryMegByGuid(int guid);

    // 根据信息id查
    public UserMessage queryMegByMegid(int messageid);
}
