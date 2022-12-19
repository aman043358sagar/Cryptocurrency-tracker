package com.example.crytpcurrencytracker

import java.util.ArrayList


class DataModel(
    val data: List<DataCrypto>
)

class DataCrypto(
    val name: String,
    val symbol: String,
    val quote: Price
)

class Price(
    val USD: PriceDetail
)

class PriceDetail(
    val price: Double
)


