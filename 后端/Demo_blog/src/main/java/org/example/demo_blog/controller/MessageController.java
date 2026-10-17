package org.example.demo_blog.controller;

import org.example.demo_blog.pojo.MessageInfo;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/message")
@RestController
public class MessageController {
    // 用List<MessageInfo>来存储留言信息
    private final List<MessageInfo> messageInfos = new ArrayList<>();

    /**
     * 获取留言信息列表
     * @param
     * @return List<MessageInfo>
     */
    @GetMapping("/getList")
    public List<MessageInfo> getList() {
        return messageInfos;
    }

    /**
     * 发布新留言
     * @param messageInfo 留言信息
     * @return boolean
     */
    @PostMapping("/publish")
    public boolean publish(MessageInfo messageInfo) {
        // 打印日志
        System.out.println(messageInfo);

        // 非空校验
        if (!StringUtils.hasLength(messageInfo.getFrom())
        || !StringUtils.hasLength(messageInfo.getTo())
        || !StringUtils.hasLength(messageInfo.getMessage())) {
            return false;
        }

        // 将留言信息添加到列表中
        messageInfos.add(messageInfo);

        // 返回成功信息
        return true;
    }
}
