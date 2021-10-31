package com.t_ovchinnikova.cryptoapp.presentation

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.t_ovchinnikova.cryptoapp.R

class CoinInfoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var ivLogoCoin = view.findViewById<ImageView>(R.id.ivLogoCoin)
    var tvSymbols = view.findViewById<TextView>(R.id.tvSymbols)
    var tvPrice = view.findViewById<TextView>(R.id.tvPrice)
    var tvLastUpdate = view.findViewById<TextView>(R.id.tvLastUpdate)
}