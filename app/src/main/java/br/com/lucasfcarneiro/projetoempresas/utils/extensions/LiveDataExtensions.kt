package br.com.lucasfcarneiro.projetoempresas.utils.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import br.com.lucasfcarneiro.projetoempresas.utils.EventLiveData
import br.com.lucasfcarneiro.projetoempresas.utils.view_state.ViewState
import br.com.lucasfcarneiro.projetoempresas.utils.view_state.ViewState.Status.*

fun <T> EventLiveData<ViewState<T>>.postNeutral() {
    postValue(
        ViewState(
            NEUTRAL,
            null,
            null
        )
    )
}

fun <T> EventLiveData<ViewState<T>>.postSuccess(data: T) {
    postValue(
        ViewState(
            SUCCESS,
            data,
            null
        )
    )
}

fun <T> EventLiveData<ViewState<T>>.postError(error: Throwable?) {
    postValue(
        ViewState(
            ERROR,
            null,
            error
        )
    )
}

fun <T> EventLiveData<ViewState<T>>.postError(message: String) {
    postValue(
        ViewState(
            ERROR,
            null,
            RuntimeException(message)
        )
    )
}

fun <T> EventLiveData<ViewState<T>>.postLoading() {
    postValue(
        ViewState(
            LOADING,
            null,
            null
        )
    )
}

fun <T> EventLiveData<T>.asLiveData(): LiveData<T> = this

fun <T> LiveData<ViewState<T>>.observe(
    lifecycleOwner: LifecycleOwner,
    isSingleEvent: Boolean = false,
    event: (ViewState<T>) -> Unit
) {
    observe(lifecycleOwner, Observer {
        (this as? EventLiveData)?.apply {
            getContent(isSingleEvent)?.let { event(it) }
            return@Observer
        }

        value?.let { event(it) }
    })
}