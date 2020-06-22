package com.sourceit.homeworkbroadcastreceivernotifications

import android.app.NotificationManager
import android.bluetooth.BluetoothAdapter
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.sourceit.appnotification.arsenal.chooseNotification
import com.sourceit.appnotification.arsenal.chooseNotificationForBluetooth
import com.sourceit.homeworkbroadcastreceivernotifications.utilites.isAirplaneModeOn

class ReceiverBluetoothMode : BroadcastReceiver() {


    companion object {
        fun newInstance() = ReceiverBluetoothMode()
    }

    override fun onReceive(context: Context, intent: Intent?) {
        val bluetoothAdapter: BluetoothAdapter = BluetoothAdapter.getDefaultAdapter()
        val nm = context.getSystemService(Context.NOTIFICATION_SERVICE)
                as NotificationManager
        if (!bluetoothAdapter.isEnabled && isAirplaneModeOn(context)) {
            nm.cancel(101)
        } else if (bluetoothAdapter.isEnabled && isAirplaneModeOn(context)) {
            Log.d("MyApp", "bluetooth is ON & airplaneMode is ON")
            chooseNotification(context)
        } else {
            Log.d("MyApp", "bluetooth is ON & airplaneMode is OFF")
            chooseNotificationForBluetooth(context)
        }
    }
}