package br.com.lucasfcarneiro.projetoempresas.data.repository

import br.com.lucasfcarneiro.projetoempresas.base.BaseRepository
import br.com.lucasfcarneiro.projetoempresas.data.Response
import br.com.lucasfcarneiro.projetoempresas.data.model.LoginModel
import br.com.lucasfcarneiro.projetoempresas.data.model.LoginResponse
import br.com.lucasfcarneiro.projetoempresas.utils.extensions.safeApiCall

class LoginRepository : BaseRepository() {

    suspend fun login(email: String, password: String): Response<LoginResponse> {
        return safeApiCall({ networkStatus.isOnline() },
            { service.login(LoginModel(email, password)) })
    }
}