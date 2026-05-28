package com.spring.example.controller;

import com.spring.example.model.MessageInfo;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/message")
@RestController
public class MessageController {
    List<MessageInfo> messageInfoList = new ArrayList<>();

//    @PostMapping(value = "/publish")
    @PostMapping(value = "/publish", produces = "application/json")
    public String publish(@RequestBody MessageInfo messageInfo) {
        // 1. 接收前端的数据后校验是否合法
        if (!StringUtils.hasLength(messageInfo.getFrom())
         || !StringUtils.hasLength(messageInfo.getTo())
         || !StringUtils.hasLength(messageInfo.getMessage())) {
            return "{\"ok\": 0}";
        }
        // 2. 存储数据到内存中
        messageInfoList.add(messageInfo);
        // 3. 返回结果
        return "{\"ok\": 1}";
    }

    @GetMapping("/getList")
    public List<MessageInfo> getList() {
        return messageInfoList;
    }
}
