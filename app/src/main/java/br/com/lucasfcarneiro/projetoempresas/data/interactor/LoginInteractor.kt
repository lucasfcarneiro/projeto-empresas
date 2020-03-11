package br.com.lucasfcarneiro.projetoempresas.data.interactor

import br.com.lucasfcarneiro.projetoempresas.data.Response
import br.com.lucasfcarneiro.projetoempresas.data.model.LoginResponse
import br.com.lucasfcarneiro.projetoempresas.data.repository.LoginRepository
import br.com.lucasfcarneiro.projetoempresas.utils.ThreadContextProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LoginInteractor(
    private val contextProvider: ThreadContextProvider,
    private val loginRepository: LoginRepository,
    private val scope: CoroutineScope
) {

    fun login(email: String, password: String, result : (Response<LoginResponse>)->Unit) {

        scope.launch(contextProvider.io) {
            val response = loginRepository.login(email, password)
            withContext(contextProvider.main) {
                result(response)
            }
        }

    }
}