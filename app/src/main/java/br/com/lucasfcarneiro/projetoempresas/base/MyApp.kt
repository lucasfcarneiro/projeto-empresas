package br.com.lucasfcarneiro.projetoempresas.base

import android.app.Application
import br.com.lucasfcarneiro.projetoempresas.di.enterpriseServiceModule
import br.com.lucasfcarneiro.projetoempresas.di.repositoryModule
import br.com.lucasfcarneiro.projetoempresas.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@MyApp)
            modules(viewModelModule, enterpriseServiceModule, repositoryModule)
        }
    }
}