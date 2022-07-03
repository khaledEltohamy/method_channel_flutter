package com.example.example_background_service

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.provider.Settings

class MusicService : Service() {
    private lateinit var player :MediaPlayer
    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        player = MediaPlayer.create(this , Settings.System.DEFAULT_ALARM_ALERT_URI) as MediaPlayer
        player.setLooping(true)
        player.start()
        return START_STICKY
    }

    override fun onDestroy() {
        player.stop()
    }
}