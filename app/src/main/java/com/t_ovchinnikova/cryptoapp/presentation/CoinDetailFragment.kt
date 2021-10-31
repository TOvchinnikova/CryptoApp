package com.t_ovchinnikova.cryptoapp.presentation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import com.t_ovchinnikova.cryptoapp.databinding.ActivityCoinDetailBinding
import com.t_ovchinnikova.cryptoapp.databinding.FragmentCoinDetailBinding
import com.t_ovchinnikova.cryptoapp.domain.CoinInfo

class CoinDetailFragment : Fragment() {

    private lateinit var viewModel: CoinViewModel

    private var _binding: FragmentCoinDetailBinding? = null
    private val binding: FragmentCoinDetailBinding
        get() = _binding ?: throw RuntimeException("FragmentCoinDetailBinding is null")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCoinDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val fromSymbol = getSymbol()
        setupViewModel(fromSymbol)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun setupViewModel(fromSymbol: String) {
        viewModel = ViewModelProvider(this)[CoinViewModel::class.java]
        viewModel.getDetailInfo(fromSymbol).observe(viewLifecycleOwner) {
            initView(it)
        }
    }

    private fun initView(coin: CoinInfo) {
        with(binding) {
            tvFromSymbol.text = coin.fromSymbol
            tvToSymbol.text = coin.toSymbol
            tvPrice.text = coin.price.toString()
            tvMinPrice.text = coin.lowDay.toString()
            tvMaxPrice.text = coin.highDay.toString()
            tvLastMarket.text = coin.lastMarket
            tvLastUpdate.text = coin.lastUpdate
            Picasso.get().load(coin.imageUrl).into(ivLogoCoin)
        }
    }

    private fun getSymbol(): String {
        return requireArguments().getString(EXTRA_FROM_SYMBOL, "")
    }

    companion object {
        private const val EXTRA_FROM_SYMBOL = "fSym"
        private const val EMPTY_SYMBOL = ""

        fun newInstance(fromSymbol: String): Fragment {
            return CoinDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(EXTRA_FROM_SYMBOL, fromSymbol)
                }
            }
        }
    }
}