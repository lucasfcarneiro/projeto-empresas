package br.com.lucasfcarneiro.projetoempresas.view.home


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.lucasfcarneiro.projetoempresas.R
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.search_bar.*


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView() {
        homeSearchView.setOnSearchClickListener{
            homeLogo.visibility = View.GONE
            searchStartHint.visibility = View.GONE
            homeSearchView.maxWidth = Integer.MAX_VALUE
        }

        homeSearchView.setOnCloseListener {
            homeLogo.visibility = View.VISIBLE
            searchStartHint.visibility = View.VISIBLE
            false
        }
    }

}
