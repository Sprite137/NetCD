package com.example.netcd;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * @author: xuzhi
 * @data: 2024/7/30
 */

public class AllTests {
    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4,8,10, TimeUnit.SECONDS,new LinkedBlockingDeque<>());

    public void getPosition(Player player, File file) throws InterruptedException {
        while(!player.isComplete()){
            System.err.println(player.getPosition());
            TimeUnit.SECONDS.sleep(1);
        }
    }

    // mp3spi 09年停更
    @Test
    public void mp3spiTest() throws JavaLayerException, FileNotFoundException, InterruptedException {
        File file=new File("F:\\code\\backend\\code\\NetCD\\src\\main\\resources\\static\\mp3\\test.mp3");
        FileInputStream stream=new FileInputStream(file);
        Player player=new Player(stream);
        threadPoolExecutor.submit(new Thread(() ->{
            try {
                player.play();
            } catch (JavaLayerException e) {
                throw new RuntimeException(e);
            }
        }));
        getPosition(player,file);
    }

    //JAVAFx 不好安装,而且不好用
    @Test
    public void JAVAFxTest() throws InterruptedException {
        Media sound = new Media(new File("test.mp3").toURI().getPath());
        MediaPlayer mp1 = new MediaPlayer(sound);
        mp1.play();
    }

}
