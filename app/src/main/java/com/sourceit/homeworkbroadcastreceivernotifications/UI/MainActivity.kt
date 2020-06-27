package com.sourceit.homeworkbroadcastreceivernotifications.UI

import android.bluetooth.BluetoothAdapter
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sourceit.appnotification.arsenal.NotificationArsenal
import com.sourceit.homeworkbroadcastreceivernotifications.App
import com.sourceit.homeworkbroadcastreceivernotifications.R
import com.sourceit.homeworkbroadcastreceivernotifications.ReceiverAirplaneMode
import com.sourceit.homeworkbroadcastreceivernotifications.ReceiverBluetoothMode
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(),MainView {

    @Inject
    lateinit var presenter: MainPresenter

    private val onNoticeAirPlaneMode =
        ReceiverAirplaneMode.newInstance()
    private val onNoticeBluetoothMode =
        ReceiverBluetoothMode.newInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        (application as App).appComponent.inject(this)
        presenter.showNotification()
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(onNoticeAirPlaneMode)
        unregisterReceiver(onNoticeBluetoothMode)
    }

    override fun onStart() {
        super.onStart()
        presenter.view = this
    }

    override fun onStop() {
        super.onStop()
        presenter.view = null
    }

    override fun onResume() {
        super.onResume()
        registerReceiver(onNoticeAirPlaneMode, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))
        registerReceiver(onNoticeBluetoothMode, IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED))
    }

    override fun updateText(text: String) {
        txt_airplane_status.text = text
    }
}