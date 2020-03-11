package br.com.lucasfcarneiro.projetoempresas.data.model

import com.google.gson.annotations.SerializedName

data class ErrorModel (
    @SerializedName("messages")
    val messages: List<String>
)