package br.com.lucasfcarneiro.projetoempresas.base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.lucasfcarneiro.projetoempresas.R

class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }
}
