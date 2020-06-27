package com.sourceit.homeworkbroadcastreceivernotifications.dagger

import android.content.Context
import android.os.Build
import android.widget.Toast
import com.sourceit.appnotification.arsenal.NotificationArsenal
import com.sourceit.appnotification.arsenal.NotificationArsenalOreo
import com.sourceit.appnotification.arsenal.NotificationArsenalPreOreo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ArsenalModule {

    @Singleton
    @Provides
    fun provideNotificationArsenal(context: Context): NotificationArsenal {
        return if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            NotificationArsenalPreOreo(context)
        } else {
            NotificationArsenalOreo(context)
        }
    }
}