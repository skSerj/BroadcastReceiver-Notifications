package com.sourceit.homeworkbroadcastreceivernotifications.UI

import android.os.Handler
import com.sourceit.appnotification.arsenal.NotificationArsenal
import javax.inject.Inject

class MainPresenter @Inject constructor() {

    @Inject
    lateinit var notificationArsenal: NotificationArsenal

    var view: MainView? = null

    init {
        Handler().postDelayed({
            view?.updateText("after 4 sec")
        }, 4000)
    }

    fun showNotification() {
        notificationArsenal.showNotification()
    }
}