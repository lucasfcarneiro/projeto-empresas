package br.com.lucasfcarneiro.projetoempresas.utils

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

open class ThreadContextProvider {
    open val main: CoroutineContext by lazy { Dispatchers.Main }
    open val io: CoroutineContext by lazy { Dispatchers.IO }
}

