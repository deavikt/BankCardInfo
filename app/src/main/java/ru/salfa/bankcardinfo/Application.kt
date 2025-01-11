package ru.salfa.bankcardinfo

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import ru.salfa.data.di.dataModule
import ru.salfa.presentation.di.presentationModule

class Application : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            val appContext = this@Application

            androidLogger(Level.DEBUG)
            androidContext(appContext)
            modules(presentationModule, dataModule(appContext))
        }
    }
}