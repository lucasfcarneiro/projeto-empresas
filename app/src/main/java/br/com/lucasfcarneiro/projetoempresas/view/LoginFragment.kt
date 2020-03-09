package br.com.lucasfcarneiro.projetoempresas.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.androidx.viewmodel.ext.android.viewModel
import br.com.lucasfcarneiro.projetoempresas.R
import br.com.lucasfcarneiro.projetoempresas.base.BaseFragment
import br.com.lucasfcarneiro.projetoempresas.view_model.LoginViewModel
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : BaseFragment() {

    private val viewModel: LoginViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        observeState()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        buttonLogin.setOnClickListener {
            viewModel.login(
                email = editTextMail.text.toString(),
                passaword = editTextPassword.text.toString()
            )
        }
    }

    private fun observeState() {
        viewModel.getLoginState().onPostValue(this,
            onSuccess = {
                //TODO: Navigate to Home

            },
            onError = {
                errorMessage.visibility = View.VISIBLE
                errorMessage.text = it.message
            })


        viewModel.getEmailState().onPostValue(this,
            onSuccess = {
                inputLayoutMail.error = null

            },
            onError = {
                inputLayoutMail.error = it.message
            })



        viewModel.getPasswordState().onPostValue(this,
            onSuccess = {
                inputLayoutPassword.error = null

            },
            onError = {
                inputLayoutPassword.error = it.message
            })

    }


}
