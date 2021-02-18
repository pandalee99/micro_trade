package com.sodse.trade.websocket;

import com.alibaba.fastjson.JSON;
import com.sodse.trade.common.lang.Result;
import com.sodse.trade.controller.BaseController;
import com.sodse.trade.domain.ChatRecord;
import com.sodse.trade.tools.snow.RandomId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@RestController
@RequestMapping("/socket")
public class SocketController extends BaseController {

    @Autowired
    private SocketIoService socketIoService;

//    @GetMapping("/send")
//    public String sendMsg(@RequestParam("content")String content,@RequestParam("loginUser")String loginUser){
//        socketIoService.pushMessageToUser(new PushMessage(loginUser,content));
//        return "OK";
//    }
    @PostMapping("/send_message_to_friend")
    public Result send_message_to_friend(@Validated @RequestBody ChatRecord chatRecord){
        Long userId = chatRecord.getUserId();
        Long talkerId = chatRecord.getTalkerId();
        chatRecord.setId(new RandomId().nextId());
        chatRecord.setCreateTime(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        chatRecordService.insert(chatRecord);
        //单人测试用
//        socketIoService.pushMessageToUser(new PushMessage(chatRecord.getUserId().toString(),"",chatRecord.getContent()));
        chatRecord.setUserId(talkerId);
        chatRecord.setTalkerId(userId);
        chatRecord.setIsSend(0);
        chatRecord.setId(new RandomId().nextId());
        chatRecordService.insert(chatRecord);
        //实际使用
        socketIoService.pushMessageToUser(new PushMessage(chatRecord.getUserId().toString(),"",chatRecord.getContent()));

        return Result.succ(chatRecord);
    }

}
