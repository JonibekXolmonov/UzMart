package bek.android.uzmart_mobile.di

import bek.android.uzmart_mobile.data.source.impl.SettingsImpl
import bek.android.uzmart_mobile.data.source.remote.api.MainApiService
import bek.android.uzmart_mobile.data.source.remote.api.impl.MainApiServiceImpl
import bek.android.uzmart_mobile.data.source.remote.network.KtorNetwork
import bek.android.uzmart_mobile.domain.datasource.cache.Settings
import org.koin.dsl.module


val appModule = module {
    single<Settings> {
        SettingsImpl()
    }
}

val networkModule = module {
    single {
        KtorNetwork(get())
    }
    single<MainApiService> {
        MainApiServiceImpl(get())
    }
}
val dbModule = module {

}

val dataSourceNodule = module {

}

val repositoryModule = module {

}

val useCaseModule = module {

}

val viewModelModule = module {

}


