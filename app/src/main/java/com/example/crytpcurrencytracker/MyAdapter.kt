package com.example.crytpcurrencytracker

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.NumberFormat
import java.util.*


class MyAdapter(val dataModel: DataModel) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {


    private var priceDollar: String = ""

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.currency_layout_row, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.cryptoNameTxtVw.text = dataModel.data[position].name
        holder.cryptoSymbolTxtVw.text = dataModel.data[position].symbol

        priceDollar = "\$${
            NumberFormat.getNumberInstance(Locale.US).format(dataModel.data[position].quote.USD.price)
        }"
        holder.cryptoPriceTxtVw.text = priceDollar

        holder.sNoTxtVw.text = (position+1).toString()
    }

    override fun getItemCount(): Int {
        return dataModel.data.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cryptoNameTxtVw: TextView = itemView.findViewById(R.id.cryptoNameTextView)
        val cryptoSymbolTxtVw: TextView = itemView.findViewById(R.id.cryptoSymbolTextView)
        val cryptoPriceTxtVw: TextView = itemView.findViewById(R.id.cryptoPriceTextView)
        val sNoTxtVw: TextView = itemView.findViewById(R.id.sNoTxtVw)
    }


}
