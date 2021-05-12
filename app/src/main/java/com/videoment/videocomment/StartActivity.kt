package com.videoment.videocomment

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class StartActivity : AppCompatActivity(R.layout.start_activity) {
    val API_KEY = "apiKey"
    val VIDEO_URL = "videoUrl"
    val VIDEO_NAME = "videoName"
    val CHANNEL_ID = "channelID"
    val USER_ID = "userId"
    val USER_NAME = "userName"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //call full video + chat room
        val videoChatIntent = Intent(this, com.videoment.videochatroom.MainActivity::class.java)
        videoChatIntent.putExtra(API_KEY, "API_KEY")
        videoChatIntent.putExtra(CHANNEL_ID, "channelID")
        videoChatIntent.putExtra(USER_ID, "userId")
        videoChatIntent.putExtra(USER_NAME, "userName")
        videoChatIntent.putExtra(VIDEO_NAME, "videoName")
        videoChatIntent.putExtra(VIDEO_URL, "videoUrl")
        startActivity(videoChatIntent)
        this.finish()

        //call chat room as flagment inflate to framelayout
        /*val chatOnlyActivity = Intent(this, ChatOnlyActivity::class.java)
        chatOnlyActivity.putExtra(API_KEY, "API_KEY")
        chatOnlyActivity.putExtra(CHANNEL_ID, "channelID")
        chatOnlyActivity.putExtra(USER_ID, "userId")
        chatOnlyActivity.putExtra(USER_NAME, "userName")
        startActivity(chatOnlyActivity)
        this.finish()*/

    }
}