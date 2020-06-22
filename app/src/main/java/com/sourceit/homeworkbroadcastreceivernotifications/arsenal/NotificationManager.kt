package com.sourceit.appnotification.arsenal

import android.content.Context
import android.os.Build
import android.os.Build.VERSION_CODES.O
import android.widget.Toast

fun chooseNotification(context: Context) {
    if (Build.VERSION.SDK_INT < O) {
        NotificationArsenalPreOreo(context).showNotification()
    } else {
        Toast.makeText(context,"in Notification manager",Toast.LENGTH_SHORT).show()
        NotificationArsenalOreo(context).showNotification()
    }
}

fun chooseNotificationForBluetooth(context: Context) {
    if (Build.VERSION.SDK_INT < O) {
        NotificationArsenalPreOreo(context).showNotificationAboutBluetoothState()
    } else {
        Toast.makeText(context,"in Notification manager",Toast.LENGTH_SHORT).show()
        NotificationArsenalOreo(context).showNotificationAboutBluetoothState()
    }
}