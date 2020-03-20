package br.com.lucasfcarneiro.projetoempresas.view.home


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import br.com.lucasfcarneiro.projetoempresas.R
import br.com.lucasfcarneiro.projetoempresas.base.BaseFragment
import br.com.lucasfcarneiro.projetoempresas.view.home.adapter.EnterpriseAdapter
import br.com.lucasfcarneiro.projetoempresas.view.home.adapter.OnItemClickListener
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.search_bar.*


class HomeFragment : BaseFragment(), OnItemClickListener<String> {

    private lateinit var adapter: EnterpriseAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setupRecyclerView()
    }

    private fun setupView() {
        homeSearchView.setOnSearchClickListener {
            homeLogo.visibility = View.GONE
            searchStartHint.visibility = View.GONE
            homeSearchView.maxWidth = Integer.MAX_VALUE
            recyclerView.visibility = View.VISIBLE
        }
        homeSearchView.setOnCloseListener {
            homeLogo.visibility = View.VISIBLE
            searchStartHint.visibility = View.VISIBLE
            recyclerView.visibility = View.GONE
            false
        }
    }

    private fun setupRecyclerView() {
        adapter = EnterpriseAdapter(mutableListOf("Nome1", "Nome2", "Nome3", "Nome4", "Nome5", "Nome6", "Nome7"), this)
        recyclerView.adapter = adapter
    }

    override fun onItemClick(item: String, position: Int) {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToEnterpriseDetailFragment())
    }


}
