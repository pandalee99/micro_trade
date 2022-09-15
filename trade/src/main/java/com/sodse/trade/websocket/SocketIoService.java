package com.sodse.trade.websocket;

public interface SocketIoService {

    /**
     * 推送的事件
     */
    String PUSH_EVENT = "push_event";

    /**
     * 启动服务
     *
     * @throws Exception
     */
    void start() throws Exception;

    /**
     * 停止服务
     */
    void stop();

    /**
     * 推送信息
     *
     * @param pushMessage
     */
    void pushMessageToUser(PushMessage pushMessage);

}

