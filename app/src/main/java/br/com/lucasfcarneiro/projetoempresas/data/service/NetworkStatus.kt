package br.com.lucasfcarneiro.projetoempresas.data.service

import android.content.Context
import android.net.ConnectivityManager

class NetworkStatus(private val context: Context){

    fun isOnline(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return (networkInfo != null && networkInfo.isConnected)
    }
}