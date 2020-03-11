package br.com.lucasfcarneiro.projetoempresas.data.model

import android.text.BoringLayout
import com.google.gson.annotations.SerializedName

data class InvestorModel(

    @SerializedName("investor_name")
    val investorName: String?,

    @SerializedName("email")
    val email: String?,

    @SerializedName("city")
    val city: String?,

    @SerializedName("country")
    val country: String?,

    @SerializedName("balance")
    val balance: Double?,

    @SerializedName("photo")
    val photo: String?,

    @SerializedName("portfolio")
    val portfolio: PortfolioModel,

    @SerializedName("portfolio_value")
    val portfolioValue: Double?,

    @SerializedName("first_access")
    val firstAccess: Boolean?,

    @SerializedName("super_angel")
    val superAngel: Boolean?


)