package com.example.netcd.player;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioPlayer {
        public static void main(String[] args) {
            try {
                AudioInputStream audioStream = AudioSystem.getAudioInputStream(AudioPlayer.class.getResourceAsStream("src/main/java/com/example/netcd/player/test.mp3"));
                Clip clip = AudioSystem.getClip();
                clip.open(audioStream);
                clip.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }