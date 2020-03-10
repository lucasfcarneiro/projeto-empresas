package br.com.lucasfcarneiro.projetoempresas.data.model

import com.google.gson.annotations.SerializedName

class LoginResponse(
    @SerializedName("investor")
    val investor: String = "",

    @SerializedName("enterprise")
    val enterprise: String = "",

    @SerializedName("success")
    val success: Boolean = false,

    @SerializedName ( "Errors")
    val errors : String = ""
)