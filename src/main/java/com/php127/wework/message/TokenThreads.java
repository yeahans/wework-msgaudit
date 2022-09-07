package com.php127.wework.message;

import com.php127.wework.utils.PropertiesUtil;

public class TokenThreads extends Thread{

    private Thread thread;

    public void run() {
        while (true){
            AccessToken accessToken = new AccessToken();
            String token = accessToken.getToken("wwc92974a314c84866","2PvRo2o0V-YANbZlzncW_3syC2atfdM15_y0hK2SoKs");
            PropertiesUtil.updateProperties("ACCESS_TOKEN",token);

            // 获取外部联系人Token
            String wbToken = accessToken.getToken("wwc92974a314c84866","k-eGDqMduQXYklZ9QxhcTCYQriBtA_a-DYTq_Pm-DLY");
            PropertiesUtil.updateProperties("WB_TOKEN",token);
            try {
                Thread.sleep(5400000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }


    public void start () {
        System.out.println("开始线程: ");
        if (thread == null) {
            thread = new Thread (this);
            thread.start ();
        }


    }


}
