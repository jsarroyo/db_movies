package com.example.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.movieapp.bussinesIntel.Moovie_BI
import kotlinx.android.synthetic.main.activity_det.*
import kotlinx.android.synthetic.main.activity_serie_detail.*
import kotlinx.android.synthetic.main.fragment_serie_detail.*

class DetActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_det)

        val nMoovieIndex = intent.getIntExtra("index",0)
        val name = intent.getStringExtra("name")
        val author = intent.getStringExtra("author")
        val season = intent.getStringExtra("season")
        val description = intent.getStringExtra("description")
        val url = intent.getStringExtra("url")

        val mName = findViewById<TextView>(R.id.nameTextView)
        val mAuthor = findViewById<TextView>(R.id.authorTextView)
        val mSeason = findViewById<TextView>(R.id.seasonTextView)
        val mDescription = findViewById<TextView>(R.id.descriptionTextView)
        val mPoster = findViewById<ImageView>(R.id.posterImageView)
        val mVistaImageView = findViewById<ImageView>(R.id.vistaImageView)

        btn_delete_movie_adt.setOnClickListener {

            val vloDD = Moovie_BI(this)
            vloDD.deleteMoovies(
                    MainActivity.mMovie[nMoovieIndex]
            )
            MainActivity.mMovie = MainActivity.mMovie.minusElement (MainActivity.mMovie[nMoovieIndex])

            Toast.makeText(this,"Moovie has been deleted successfully - btn_delete_movie_adt", Toast.LENGTH_LONG).show();
            finish()
        }
//        btn_delete_movie_fsd.setOnClickListener {


//            val vloDD = Moovie_BI(this)
//            vloDD.deleteMoovies(
//                    MainActivity.mMovie[nMoovieIndex]
//
//            )
//            Toast.makeText(this,"Moovie has been deleted successfully - btn_delete_movie_fsd", Toast.LENGTH_LONG).show();
//
//        }
//        btn_delete_movie_asd    .setOnClickListener {
//            val vloDD = Moovie_BI(this)
//            vloDD.deleteMoovies(
//                    MainActivity.mMovie[nMoovieIndex]
//
//            )
//            Toast.makeText(this,"Moovie has been deleted successfully - btn_delete_movie_asd", Toast.LENGTH_LONG).show();
//
//        }

        mName.text = name
        mAuthor.text = author
        mSeason.text = season
        mDescription.text = description

        Glide.with(this)
            .load(url)
            .into(mPoster)

        Glide.with(this)
            .load(url)
            .into(mVistaImageView)
    }
}