package com.example.practice_android.util

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.PendingIntent.FLAG_MUTABLE
import android.app.PendingIntent.FLAG_UPDATE_CURRENT
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import com.example.practice_android.MainActivity
import com.example.practice_android.R
import com.example.practice_android.SecondActivity
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class MyFirebaseMessagingService : FirebaseMessagingService() {
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Log.e("hyeon","fcm token : $token")
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        Log.e("hyeon",message.notification.toString())
        Log.e("hyeon",message.data.toString())
        createNotification(message)
    }

    private fun createNotification(message: RemoteMessage){
        val intent = Intent(this,SecondActivity::class.java)
        for (key in message.data.keys) {
            intent.putExtra(key,message.data.get(key))
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        val pendingIntent = PendingIntent.getActivity(this,(System.currentTimeMillis()/7).toInt(),intent,PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_MUTABLE)

        val notificationChannel = NotificationChannel(
            CHANNEL_ID,
            "TestChannelName",
            NotificationManager.IMPORTANCE_DEFAULT
        )

        val builder = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Title")
            .setContentText("ContentText")
            .setContentIntent(pendingIntent)

        val notificationManager: NotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.createNotificationChannel(notificationChannel)

        notificationManager.notify(
            1, // 해당 알림의 고유 ID
            builder // 표시할 알림
                .setContentTitle("Title")
                .setContentText("ContentText")
                .build()
        )
    }
    private fun getFcmToken(){
        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener{ task->
            if(!task.isSuccessful){
                Log.e("hyeon","Fetching FCM registration token failed",task.exception)
                return@OnCompleteListener
            }
            val token = task.result
            Log.e("hyeon", "token is $token")
        })
    }
    companion object {
        private const val CHANNEL_ID = "channel_id"
        private const val notificationId = 1234
    }
}