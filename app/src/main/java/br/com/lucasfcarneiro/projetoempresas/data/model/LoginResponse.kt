package br.com.lucasfcarneiro.projetoempresas.data.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("investor")
    val investor: InvestorModel?,

    @SerializedName("enterprise")
    val enterprise: String?,

    @SerializedName("success")
    val success: Boolean?,

    @SerializedName ( "Errors")
    val errors : String?
)