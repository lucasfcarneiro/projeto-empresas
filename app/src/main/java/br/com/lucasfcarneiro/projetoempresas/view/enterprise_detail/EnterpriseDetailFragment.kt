package br.com.lucasfcarneiro.projetoempresas.view.enterprise_detail


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

import br.com.lucasfcarneiro.projetoempresas.R
import kotlinx.android.synthetic.main.enterprise_detail_bar.*

class EnterpriseDetailFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_enterprise_detail, container, false)
    }
}
