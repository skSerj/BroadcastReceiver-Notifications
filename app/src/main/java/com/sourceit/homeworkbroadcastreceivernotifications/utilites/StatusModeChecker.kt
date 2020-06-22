package com.sourceit.homeworkbroadcastreceivernotifications.utilites

import android.content.Context
import android.os.Build
import android.provider.Settings


fun isAirplaneModeOn(context: Context): Boolean {
    return Settings.Global.getInt(
        context.getContentResolver(),
        Settings.Global.AIRPLANE_MODE_ON,
        0
    ) !== 0
}