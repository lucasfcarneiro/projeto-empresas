package br.com.lucasfcarneiro.projetoempresas.data.repository

import br.com.lucasfcarneiro.projetoempresas.data.model.LoginModel
import br.com.lucasfcarneiro.projetoempresas.data.model.LoginResponse
import br.com.lucasfcarneiro.projetoempresas.data.service.EnterpriseService
import br.com.lucasfcarneiro.projetoempresas.di.enterpriseServiceModule

class LoginRepository (private val enterpriseService: EnterpriseService) {

    suspend fun login(email: String, password: String): LoginResponse {
            return enterpriseService .login(LoginModel(email, password))
    }
}