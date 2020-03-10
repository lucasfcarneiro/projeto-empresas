package br.com.lucasfcarneiro.projetoempresas.data.service

import br.com.lucasfcarneiro.projetoempresas.data.model.LoginModel
import br.com.lucasfcarneiro.projetoempresas.data.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface EnterpriseService {

    @POST(LOG_IN_PATH)
    suspend fun login (@Body loginModel: LoginModel) : LoginResponse
}

const val LOG_IN_PATH = "users/auth/sign_in"