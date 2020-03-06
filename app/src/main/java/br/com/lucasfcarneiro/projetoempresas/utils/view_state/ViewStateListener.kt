package br.com.lucasfcarneiro.projetoempresas.utils.view_state

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import br.com.lucasfcarneiro.projetoempresas.utils.extensions.observe

interface ViewStateListener {
    fun onStateError(error: Throwable)

    fun onStateLoading()

    private fun <T> ViewState<T>.handle(
        onError: ((Throwable) -> Unit)? = null,
        onLoading: (() -> Unit)? = null,
        onSuccess: ((T) -> Unit)? = null
    ) {
        stateHandler(
            onSuccess = { onSuccess?.invoke(it) },
            onError = { onError?.invoke(it) ?: onStateError(it) },
            loading = { onLoading?.invoke() ?: onStateLoading() }
        )
    }

    fun <T> LiveData<ViewState<T>>.onPostValue(
        lifecycleOwner: LifecycleOwner,
        onError: ((Throwable) -> Unit)? = null,
        onLoading: (() -> Unit)? = null,
        onSuccess: ((T) -> Unit)? = null
    ) {
        observe(lifecycleOwner) {
            it.handle(onError, onLoading, onSuccess)
        }
    }

}
