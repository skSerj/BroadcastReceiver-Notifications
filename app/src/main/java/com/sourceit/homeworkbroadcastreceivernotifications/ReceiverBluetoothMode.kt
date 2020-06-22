package com.sourceit.homeworkbroadcastreceivernotifications

import android.app.NotificationManager
import android.bluetooth.BluetoothAdapter
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.sourceit.appnotification.arsenal.chooseNotificationForBluetooth
class ReceiverBluetoothMode : BroadcastReceiver() {


    companion object {
        fun newInstance() = ReceiverAirplaneMode()
    }

    override fun onReceive(context: Context, intent: Intent?) {
        val bluetoothAdapter: BluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
        val nm = context.getSystemService(Context.NOTIFICATION_SERVICE)
                as NotificationManager
        if (!bluetoothAdapter.isEnabled) {
            nm.cancel(101)
        } else {
            Log.d("MyApp", "bluetooth is ON")
            chooseNotificationForBluetooth(context)
        }
    }
}