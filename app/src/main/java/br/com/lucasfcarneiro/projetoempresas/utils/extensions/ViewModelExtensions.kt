package br.com.lucasfcarneiro.projetoempresas.utils.extensions

import br.com.lucasfcarneiro.projetoempresas.utils.EventLiveData
import br.com.lucasfcarneiro.projetoempresas.utils.view_state.ViewState

fun <T> viewState(): Lazy<EventLiveData<ViewState<T>>> {
    return lazy {
        EventLiveData<ViewState<T>>()
    }
}