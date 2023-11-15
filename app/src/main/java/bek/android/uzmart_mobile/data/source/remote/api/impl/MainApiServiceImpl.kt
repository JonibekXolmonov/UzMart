package bek.android.uzmart_mobile.data.source.remote.api.impl

import bek.android.uzmart_mobile.data.source.remote.api.MainApiService
import bek.android.uzmart_mobile.data.source.remote.network.KtorNetwork

class MainApiServiceImpl(private val ktorNetwork: KtorNetwork) : MainApiService {

    val client = ktorNetwork.getClient()


}