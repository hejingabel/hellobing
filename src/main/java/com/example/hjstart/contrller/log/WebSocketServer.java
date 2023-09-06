package com.example.hjstart.contrller.log;


import com.example.hjstart.comm.utils.TailLogUtil;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import cn.hutool.core.date.DateUtil;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

@ServerEndpoint("/websocket/{id}")
@Component
public class WebSocketServer {

    private Process process;

    private InputStream inputStream;

    private static ApplicationContext applicationContext;

    public static void setApplicationContext(ApplicationContext applicationContext) {
        WebSocketServer.applicationContext = applicationContext;
    }

    /**
     * 新的WebSocket请求开启
     */
    @OnOpen
    public void onOpen(@PathParam("id") String id, Session session) {
        String filePath=getPathById(id);
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while (true) {
                while ((line = reader.readLine()) != null) {
                    // 将每行日志内容发送到WebSocket
                    if (session != null && session.isOpen()) {
                        session.getBasicRemote().sendText(line);
                    }
                }
                // 等待一段时间再继续读取
                Thread.sleep(1000); // 可以根据需要调整等待时间
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * WebSocket请求关闭
     */
    @OnClose
    public void onClose() {
        if(inputStream != null){
            try {
                inputStream.close();
            } catch (IOException e) {
                System.out.println("close websocket error.:" + e);
            }
        }

        if(process != null){
            process.destroy();
        }
    }

    @OnError
    public void onError(Throwable thr) {
        System.out.println("websocket error." + thr);
    }

    private String getPathById(String id) {
        System.out.println(id);
        return "D:\\logs\\logs\\auth-api-ext-impl.log";
    }

}
