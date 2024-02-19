package com.example.roomdbproject

data class NewsData(
    val feed: Feed,
    val items: List<Item>,
    val status: String
)