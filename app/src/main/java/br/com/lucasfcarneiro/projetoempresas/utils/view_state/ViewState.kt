package br.com.lucasfcarneiro.projetoempresas.utils.view_state

class ViewState<T>(
    val status: Status = Status.NEUTRAL,
    val data: T? = null,
    val error: Throwable? = null
) {

    fun stateHandler(
        onSuccess: (T) -> Unit,
        onError: (Throwable) -> Unit,
        loading: () -> Unit
    ) {
        when (status) {
            Status.SUCCESS -> data?.let { onSuccess(it) } ?: throw RuntimeException()
            Status.ERROR -> error?.let { onError(it) } ?: throw RuntimeException()
            Status.LOADING -> loading()
            else -> {
            }
        }
    }

    enum class Status {
        SUCCESS, ERROR, LOADING, NEUTRAL
    }
}