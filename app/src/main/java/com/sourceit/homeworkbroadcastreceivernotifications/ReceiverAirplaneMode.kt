package com.sourceit.homeworkbroadcastreceivernotifications

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.sourceit.appnotification.arsenal.chooseNotification
import com.sourceit.homeworkbroadcastreceivernotifications.utilites.isAirplaneModeOn

class ReceiverAirplaneMode : BroadcastReceiver() {

    companion object {
        fun newInstance() = ReceiverAirplaneMode()
    }

    override fun onReceive(context: Context, intent: Intent?) {
        val nm = context.getSystemService(Context.NOTIFICATION_SERVICE)
                as NotificationManager
        Log.d("MyApp", "airplane mode is changed")
        if (!isAirplaneModeOn(
                context
            )
        ) {
            Log.d("MyApp", "airplane mode is off")
            chooseNotification(context)
        } else {
            Log.d("MyApp", "airplane mode is on")
            nm.cancel(101)
        }
    }
}