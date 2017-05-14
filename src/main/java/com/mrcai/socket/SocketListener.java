package com.mrcai.socket;

import com.mrcai.mapper.WaterLevelMapper;
import com.mrcai.util.ObjectToValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Administrator on 2017/5/14 0014.
 */
@Component
public class SocketListener implements ApplicationListener<ApplicationReadyEvent>{

    @Autowired
    WaterLevelMapper waterLevelMapper;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        System.out.println("SocketListener");
        oneServer();
    }
    private void oneServer() {
        try {
            ServerSocket ss = new ServerSocket(1208);
            System.out.println("ServerSocket start!");
            Socket s = ss.accept();
            while(true){
                BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
                System.out.println(br.readLine());
                String msg = br.readLine();
                String[] msgValue = msg.split("/");
                int areaId = Integer.parseInt(msgValue[0]);
                int hardwareId = Integer.parseInt(msgValue[1]);
                double waterLevel = Double.parseDouble(msgValue[2]);
                waterLevelMapper.addWaterLevel(areaId, hardwareId, waterLevel, (int)(System.currentTimeMillis() / 1000));
            }
        } catch (IOException e) {
            System.out.println("socket error:" + e);
        }
    }
}
