package com.codeslogan.mapper;

import com.codeslogan.pojo.UserMessage;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMessageMapper {
    public void addMessage(UserMessage userMessage);
}
