package com.silva021.questionapp.ui.aplication

import android.app.Application
import android.util.Log
import com.silva021.questionapp.di.questionModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class QuestionApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@QuestionApplication)
            modules(questionModule)
        }
    }
}