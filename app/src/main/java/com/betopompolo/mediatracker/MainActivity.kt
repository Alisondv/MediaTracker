package com.betopompolo.mediatracker

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.progressindicator.LinearProgressIndicator

val bookDetail = BookDetail(
    title = "The Lord of the Rings: The Fellowship of the Ring",
    synopsis = "A young hobbit, Frodo, who has found the One Ring that belongs to the Dark Lord Sauron, begins his journey with eight companions to Mount Doom, the only place where it can be destroyed.",
    author = "J.R.R. Tolkien",
    publisher = "Allen & Unwin",
    firstPublished = "1954",
    currentPage = 42,
    totalPages = 423,
    genres = listOf("Fantasy", "Adventure")
)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val bookTitleTextView = findViewById<TextView>(R.id.book_title)
        bookTitleTextView.text = bookDetail.title

        val synopsisTextView = findViewById<TextView>(R.id.synopsis_text_view)
        synopsisTextView.text = bookDetail.synopsis

        findViewById<TextView>(R.id.author_text_view).apply {
            text = bookDetail.author
        }

        findViewById<TextView>(R.id.publisher_text_view).apply {
            text = bookDetail.publisher
        }

        findViewById<TextView>(R.id.first_published_text_view).text = bookDetail.firstPublished

        findViewById<TextView>(R.id.reading_progress_text_view).text =
            "Page ${bookDetail.currentPage} / ${bookDetail.totalPages}"

        findViewById<TextView>(R.id.reading_progress_percentage).apply {
            text = "${bookDetail.progressPercentage}%"
        }

        findViewById<LinearProgressIndicator>(R.id.reading_progress_indicator).apply {
            progress = bookDetail.progressPercentage
        }

        findViewById<TextView>(R.id.genres).apply {
            text = bookDetail.genres.joinToString(", ")
        }
    }
}

class BookDetail(
    val title: String,
    val synopsis: String,
    val author: String,
    val publisher: String,
    val firstPublished: String,
    val currentPage: Int,
    val totalPages: Int,
    val genres: List<String>
) {
    val progressPercentage: Int
        get() = ((currentPage.toFloat() / totalPages) * 100).toInt()
}