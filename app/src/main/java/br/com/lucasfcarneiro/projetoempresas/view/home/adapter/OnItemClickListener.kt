package br.com.lucasfcarneiro.projetoempresas.view.home.adapter

interface OnItemClickListener<T> {
    fun onItemClick(item: T, position: Int)
}