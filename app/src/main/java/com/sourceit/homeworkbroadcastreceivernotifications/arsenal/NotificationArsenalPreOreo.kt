package com.sourceit.appnotification.arsenal

import android.app.Notification
import android.content.Context

class NotificationArsenalPreOreo(context: Context) : NotificationArsenal(context) {
    override fun showNotification() {
        @Suppress("DEPRECATION")
        val builder = Notification.Builder(this)
        prepareNotificationAirplaneMode(builder)
    }

    override fun showNotificationAboutBluetoothState() {
        @Suppress("DEPRECATION")
        val builder = Notification.Builder(this)
        prepareNotificationBluetoothMode(builder)
    }
}