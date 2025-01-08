package ru.salfa.bankcardinfo

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import ru.salfa.bankcardinfo.data.di.dataModule
import ru.salfa.bankcardinfo.ui.di.appModule

class Application : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger(Level.DEBUG)
            androidContext(this@Application)
            modules(appModule, dataModule())
        }
    }
}