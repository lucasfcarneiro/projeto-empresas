package br.com.lucasfcarneiro.projetoempresas.utils

import androidx.lifecycle.MutableLiveData

class EventLiveData<T> : MutableLiveData<T>() {

    var hasBeenHandled = false
        private set

    private fun getContentIfNotHandled() =
        if (hasBeenHandled) {
            null
        } else {
            hasBeenHandled = true
            value
        }

    fun getContent(isSingleEvent: Boolean) = if (isSingleEvent) getContentIfNotHandled() else value

}