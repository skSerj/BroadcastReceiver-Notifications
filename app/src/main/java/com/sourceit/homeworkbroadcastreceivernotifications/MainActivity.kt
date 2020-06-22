package com.sourceit.homeworkbroadcastreceivernotifications

import android.bluetooth.BluetoothAdapter
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private val onNoticeAirPlaneMode = ReceiverAirplaneMode.newInstance()
    private val onNoticeBluetoothMode = ReceiverBluetoothMode.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(onNoticeAirPlaneMode)
        unregisterReceiver(onNoticeBluetoothMode)
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(onNoticeAirPlaneMode, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))
        registerReceiver(onNoticeBluetoothMode, IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED))
    }
}