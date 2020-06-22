package com.sourceit.appnotification.arsenal

import android.app.Notification
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.ContextWrapper
import android.content.Intent
import android.graphics.BitmapFactory
import android.graphics.Color
import com.sourceit.homeworkbroadcastreceivernotifications.MainActivity
import com.sourceit.homeworkbroadcastreceivernotifications.R

abstract class NotificationArsenal(context: Context) : ContextWrapper(context) {

    val notifyID = 101

    val nm = context.getSystemService(Context.NOTIFICATION_SERVICE)
            as NotificationManager

    abstract fun showNotification()

    fun prepareNotificationAirplaneMode(builder: Notification.Builder) {
        val notificationIntent = Intent(this, MainActivity::class.java)
        val contentIntent: PendingIntent = PendingIntent.getActivity(
            this,
            1000,
            notificationIntent,
            PendingIntent.FLAG_CANCEL_CURRENT
        )

        builder.apply {
            setContentIntent(contentIntent)
            setContentTitle("HelloFromHomework")
            setContentText("Большой брат присматривает за тобой")
            setSmallIcon(R.mipmap.ic_launcher)
            setDefaults(Notification.DEFAULT_ALL)
            setLargeIcon(BitmapFactory.decodeResource(resources,R.drawable.airplane_mode))
            setVibrate(longArrayOf(1000,1000,1000,1000,1000))
            setLights(Color.BLUE,500,500)
        }
        nm.notify(notifyID, builder.build())
    }

    abstract fun showNotificationAboutBluetoothState()

    fun prepareNotificationBluetoothMode(builder: Notification.Builder) {
        val notificationIntent = Intent(this, MainActivity::class.java)
        val contentIntent: PendingIntent = PendingIntent.getActivity(
            this,
            1000,
            notificationIntent,
            PendingIntent.FLAG_CANCEL_CURRENT
        )

        builder.apply {
            setContentIntent(contentIntent)
            setContentTitle("HelloFromHomework")
            setContentText("Большой брат наблюдает за тобой")
            setSmallIcon(R.mipmap.ic_launcher)
            setDefaults(Notification.DEFAULT_ALL)
            setLargeIcon(BitmapFactory.decodeResource(resources,R.drawable.bluetooth))
            setVibrate(longArrayOf(500,500,500,500,500))
            setLights(Color.RED,500,500)
        }
        nm.notify(notifyID, builder.build())
    }
}