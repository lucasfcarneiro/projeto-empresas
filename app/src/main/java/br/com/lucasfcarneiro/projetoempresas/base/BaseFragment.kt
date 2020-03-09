package br.com.lucasfcarneiro.projetoempresas.base

import androidx.fragment.app.Fragment
import br.com.lucasfcarneiro.projetoempresas.utils.view_state.ViewStateListener

open class BaseFragment : Fragment(),ViewStateListener {
    override fun onStateError(error: Throwable) {

    }

    override fun onStateLoading() {

    }
}