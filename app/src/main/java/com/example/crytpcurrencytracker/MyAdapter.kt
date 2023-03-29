package com.example.crytpcurrencytracker

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.crytpcurrencytracker.databinding.CurrencyLayoutRowBinding
import java.text.NumberFormat
import java.util.*


class MyAdapter(val dataModel: DataModel) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    private var priceDollar: String = ""

    inner class ViewHolder(val binding: CurrencyLayoutRowBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(pos: Int){
            binding.cryptoNameTextView.text = dataModel.data[pos].name
            binding.cryptoSymbolTextView.text = dataModel.data[pos].symbol

            priceDollar = "\$${
                NumberFormat.getNumberInstance(Locale.US)
                    .format(dataModel.data[pos].quote.USD.price)
            }"

            binding.cryptoPriceTextView.text = priceDollar
            binding.sNoTxtVw.text = (pos + 1).toString()
        }

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CurrencyLayoutRowBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return dataModel.data.size
    }


}
