package bek.android.uzmart_mobile.presentation

import android.app.Application
import bek.android.uzmart_mobile.di.appModule
import bek.android.uzmart_mobile.di.dataSourceNodule
import bek.android.uzmart_mobile.di.dbModule
import bek.android.uzmart_mobile.di.networkModule
import bek.android.uzmart_mobile.di.repositoryModule
import bek.android.uzmart_mobile.di.useCaseModule
import bek.android.uzmart_mobile.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class UzMartApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@UzMartApp)
            modules(appModule + networkModule + dbModule + repositoryModule + useCaseModule + viewModelModule + dataSourceNodule)
        }
    }
}