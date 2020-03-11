package br.com.lucasfcarneiro.projetoempresas.data.model

import com.google.gson.annotations.SerializedName

data class PortfolioModel (

    @SerializedName("enterprises_number")
    val enterprisesNumber: Int?,

    @SerializedName("enterprises")
    val enterprises: List<String>?

)
