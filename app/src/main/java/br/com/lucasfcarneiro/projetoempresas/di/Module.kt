package br.com.lucasfcarneiro.projetoempresas.di

import br.com.lucasfcarneiro.projetoempresas.view_model.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module{
    viewModel{LoginViewModel(get())}
}