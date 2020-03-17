package br.com.lucasfcarneiro.projetoempresas.utils.extensions

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.lucasfcarneiro.projetoempresas.utils.EventLiveData
import br.com.lucasfcarneiro.projetoempresas.utils.view_state.ViewState
import org.koin.core.KoinComponent
import org.koin.core.inject
import org.koin.core.parameter.parametersOf

fun <T> viewState(): Lazy<EventLiveData<ViewState<T>>> {
    return lazy {
        EventLiveData<ViewState<T>>()
    }
}

inline fun <V, reified U> V.getInteractor() where V : ViewModel, V : KoinComponent = inject<U> {
    parametersOf(viewModelScope)
}