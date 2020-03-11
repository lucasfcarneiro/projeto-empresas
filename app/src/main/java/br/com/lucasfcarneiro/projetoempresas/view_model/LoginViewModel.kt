package br.com.lucasfcarneiro.projetoempresas.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleObserver
import br.com.lucasfcarneiro.projetoempresas.data.repository.LoginRepository
import br.com.lucasfcarneiro.projetoempresas.utils.extensions.*
import org.koin.core.KoinComponent

class LoginViewModel(application: Application, private val loginRepository: LoginRepository) : AndroidViewModel(application), LifecycleObserver,
    KoinComponent {

    private val emailState by viewState<Unit>()
    private val passwordState by viewState<Unit>()
    private val loginState by viewState<Unit>()

    fun getEmailState() = emailState.asLiveData()
    fun getPasswordState() = passwordState.asLiveData()
    fun getLoginState() = loginState.asLiveData()


    fun login(email: String, password: String) {
        if (validateFields(email, password)) {
//            loginState.postSuccess(Unit)
            loginState.postLoading()
        } else {
            loginState.postError("erru")
        }

    }

    private fun validateFields(email: String, password: String): Boolean {
        var isValid = true

        if (email.isEmpty()) {
            emailState.postError("Campo email vazio")
            isValid = false
        } else if (!email.contains("@") || !email.contains(".")) {
            emailState.postError("Email invalido")
            isValid = false
        }

        if (password.isEmpty()) {
            passwordState.postError("Senha vazia")

            isValid = false
        }

        return isValid
    }


}