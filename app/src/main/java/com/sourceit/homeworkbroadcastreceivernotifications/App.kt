package com.sourceit.homeworkbroadcastreceivernotifications

import android.app.Application
import com.sourceit.homeworkbroadcastreceivernotifications.dagger.AppComponent
import com.sourceit.homeworkbroadcastreceivernotifications.dagger.ArsenalModule
import com.sourceit.homeworkbroadcastreceivernotifications.dagger.BaseModule
import com.sourceit.homeworkbroadcastreceivernotifications.dagger.DaggerAppComponent

class App : Application() {
    val appComponent: AppComponent by lazy {

        DaggerAppComponent.builder()
            .baseModule(BaseModule(this))
            .arsenalModule(ArsenalModule())
            .build()
    }
}