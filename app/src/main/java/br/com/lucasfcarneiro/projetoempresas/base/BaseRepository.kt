package br.com.lucasfcarneiro.projetoempresas.base

import br.com.lucasfcarneiro.projetoempresas.data.service.EnterpriseService
import br.com.lucasfcarneiro.projetoempresas.data.service.NetworkStatus
import org.koin.core.KoinComponent
import org.koin.core.inject

open class BaseRepository: KoinComponent {

    protected val networkStatus : NetworkStatus by inject()
    protected val service : EnterpriseService by inject()

}