package com.sourceit.homeworkbroadcastreceivernotifications.dagger

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class BaseModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideAppContext() = context //если вместо конткста мы создаём обьект то аннотация синглтон не позволит плодить обьекты
}