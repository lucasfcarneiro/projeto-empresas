package br.com.lucasfcarneiro.projetoempresas.view_model

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import br.com.lucasfcarneiro.projetoempresas.utils.extensions.asLiveData
import br.com.lucasfcarneiro.projetoempresas.utils.extensions.postError
import br.com.lucasfcarneiro.projetoempresas.utils.extensions.postSuccess
import br.com.lucasfcarneiro.projetoempresas.utils.extensions.viewState
import br.com.lucasfcarneiro.projetoempresas.utils.view_state.ViewState
import org.koin.core.KoinComponent

class LoginViewModel(application: Application) : AndroidViewModel(application), LifecycleObserver,
    KoinComponent {

    private val emailState by viewState<Unit>()
    private val passwordState by viewState<Unit>()
    private val loginState by viewState<Unit>()

    fun getEmailState() = emailState.asLiveData()
    fun getPasswordState() = passwordState.asLiveData()
    fun getLoginState() = loginState.asLiveData()


    fun login(email: String, passaword: String) {
        if (validateFields(email, passaword)) {
            loginState.postSuccess(Unit)
        } else {
            loginState.postError("Credencias incorretas")
        }

    }

    private fun validateFields(email: String, passaword: String): Boolean {
        var isValid = true

        if (email.isEmpty()) {
            emailState.postError("Campo email vazio")
            isValid = false
        } else if (!email.contains("@") || !email.contains(".")) {
            emailState.postError("Email invalido")
            isValid = false
        }

        if (passaword.isEmpty()) {
            passwordState.postError("Senha vazia")

            isValid = false
        }

        return isValid
    }


}