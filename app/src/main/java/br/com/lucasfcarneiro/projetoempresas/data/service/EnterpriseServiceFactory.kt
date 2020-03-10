package br.com.lucasfcarneiro.projetoempresas.data.service

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.lang.reflect.Type


object EnterpriseServiceFactory {
    fun createClient(url: String, okHttpClient: OkHttpClient, adapter: CoroutineCallAdapterFactory) : EnterpriseService{
        val retrofit = Retrofit.Builder()
            .baseUrl(url)
            .client(okHttpClient)
            .addConverterFactory(UnitConverterFactory)
            .addCallAdapterFactory(adapter)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit.create(EnterpriseService::class.java)
    }

    object UnitConverterFactory : Converter.Factory() {
        override fun responseBodyConverter(type: Type, annotations: Array<out Annotation>,
                                           retrofit: Retrofit): Converter<ResponseBody, *>? {
            return if (type == Unit::class.java) UnitConverter else null
        }

        private object UnitConverter : Converter<ResponseBody, Unit> {
            override fun convert(value: ResponseBody) {
                value.close()
            }
        }
    }
}