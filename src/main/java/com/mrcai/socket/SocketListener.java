package com.mrcai.socket;

import com.mrcai.app.model.mapper.WaterLevelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2017/5/14 0014.
 */
@RestController
public class SocketListener{

    @Autowired
    WaterLevelMapper waterLevelMapper;

    @GetMapping(value = "/startSocket")
    public void oneServer() {
        ServerSocket ss = null;
        Socket s = null;
        BufferedReader br = null;
        try {
            ss = new ServerSocket(1208);
            System.out.println("服务器已启动");
            while(true){
                s = ss.accept();
                ServerSocketThread thread = new ServerSocketThread(s);
                thread.start();
            }
        } catch (IOException e) {
        }
    }

    class ServerSocketThread extends Thread{
        private Socket socket = null;
//        private BufferedReader br = null;
//        private PrintWriter pw = null;
        //声明构造函数,接收客户端请求socket
        public ServerSocketThread(Socket s) {
            this.socket=s;
        }
        @Override
        public void run() {

            while(true){
                try {
                    byte[] buf = new byte[1024];
                    InputStream in=socket.getInputStream();
                    int len = in.read(buf);
                    String sb = new String(buf,0,len);
                    System.out.println("from client: "+sb );
                    if(sb.indexOf("/")==-1){
                        System.out.println(sb.toString());
                    }else{
                        String[] strArray= sb.split("/");
                        int aid = Integer.valueOf(strArray[0]);
                        int hid = Integer.valueOf(strArray[1]);
                        double level = Double.valueOf(strArray[2]);
                        waterLevelMapper.addWaterLevel(aid, hid, level, (int)(System.currentTimeMillis() / 1000));
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    break;
                }
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
