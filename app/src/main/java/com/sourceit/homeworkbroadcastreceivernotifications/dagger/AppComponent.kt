package com.sourceit.homeworkbroadcastreceivernotifications.dagger

import com.sourceit.homeworkbroadcastreceivernotifications.UI.MainActivity
import com.sourceit.homeworkbroadcastreceivernotifications.ReceiverAirplaneMode
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        BaseModule::class,
        ArsenalModule::class
    ]
)

interface AppComponent {
    fun inject(mainActivity: MainActivity)
    fun inject(receiverAirplaneMode: ReceiverAirplaneMode)
}

