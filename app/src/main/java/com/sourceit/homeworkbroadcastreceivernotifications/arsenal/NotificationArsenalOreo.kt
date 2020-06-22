package com.sourceit.appnotification.arsenal

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi

const val CHANNEL_ID = "MyChannel"

@RequiresApi(Build.VERSION_CODES.O)
class NotificationArsenalOreo(context: Context) : NotificationArsenal(context) {

    init {
        val channel =
            NotificationChannel(
                CHANNEL_ID,
                "MyChannel",
                NotificationManager.IMPORTANCE_HIGH
            )
        nm.createNotificationChannel(channel)

    }

    override fun showNotification() {
        @Suppress("Deprecation")
        val builder = Notification.Builder(this)
        prepareNotificationAirplaneMode(builder)
    }

    override fun showNotificationAboutBluetoothState() {
        @Suppress("Deprecation")
        val builder = Notification.Builder(this)
        prepareNotificationBluetoothMode(builder)
    }
}