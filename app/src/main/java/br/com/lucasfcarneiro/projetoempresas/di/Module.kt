package br.com.lucasfcarneiro.projetoempresas.di

import br.com.lucasfcarneiro.projetoempresas.data.interactor.LoginInteractor
import br.com.lucasfcarneiro.projetoempresas.data.repository.LoginRepository
import br.com.lucasfcarneiro.projetoempresas.data.service.EnterpriseServiceFactory
import br.com.lucasfcarneiro.projetoempresas.utils.BASE_URL
import br.com.lucasfcarneiro.projetoempresas.utils.ThreadContextProvider
import br.com.lucasfcarneiro.projetoempresas.view_model.LoginViewModel
import kotlinx.coroutines.CoroutineScope
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { LoginViewModel(get(), get()) }
}

val enterpriseServiceModule = module {
    single { EnterpriseServiceFactory.createClient(BASE_URL) }
}

val repositoryModule = module {
    factory { LoginRepository(get()) }
}

val interactorModule = module {
    factory {(scope: CoroutineScope) -> LoginInteractor(get(), get(), scope)}
    factory { ThreadContextProvider() }
}


