package com.sourceit.homeworkbroadcastreceivernotifications

import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.sourceit.appnotification.arsenal.NotificationArsenal
import com.sourceit.appnotification.arsenal.chooseNotification
import com.sourceit.homeworkbroadcastreceivernotifications.utilites.isAirplaneModeOn
import javax.inject.Inject

class ReceiverAirplaneMode : BroadcastReceiver() {

    @Inject
    lateinit var notificationArsenal: NotificationArsenal


    companion object {
        fun newInstance() = ReceiverAirplaneMode()
    }

    override fun onReceive(context: Context, intent: Intent?) {
        (context.applicationContext as App).appComponent.inject(this)

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