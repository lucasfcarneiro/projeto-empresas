package br.com.lucasfcarneiro.projetoempresas.di

import br.com.lucasfcarneiro.projetoempresas.data.repository.LoginRepository
import br.com.lucasfcarneiro.projetoempresas.data.service.EnterpriseServiceFactory
import br.com.lucasfcarneiro.projetoempresas.utils.BASE_URL
import br.com.lucasfcarneiro.projetoempresas.view_model.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module{
    viewModel{LoginViewModel(get(),get())}
}

val enterpriseServiceModule = module {
    single { EnterpriseServiceFactory.createClient(BASE_URL, okHttpClient = get(), adapter = get()) }
}

val repositoryModule = module {
    factory { LoginRepository () }
}
