//package com.example.movieapp
//
//
//import android.content.Intent
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.RecyclerView
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.ImageView
//import com.bumptech.glide.Glide
//
//import kotlinx.android.synthetic.main.serie_list_content.view.*
//import kotlinx.android.synthetic.main.item_list.*
//
//class MainActivity2 : AppCompatActivity() {
//
//    private var twoPane: Boolean = false
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        if (detailFrameLayout != null) {
//            twoPane = true
//
//            val fragment = DetailFragment().apply {
//                arguments = Bundle().apply {
//                    putString("name", "Juego de tronos")
//                    putString("author", "George R. R. Martin")
//                    putString("season", "8")
//                    putString(
//                            "description",
//                            "Esta serie, basada en los libros de George R.R. Martin, muestra la competencia entre familias nobles de siete reinos de Westeros, cuya finalidad es ganar el control sobre el Trono de Hierro."
//                    )
//                    putString(
//                            "url",
//                            "https://cindybruchman.files.wordpress.com/2016/09/game-of-thrones-season-3.jpg"
//                    )
//                }
//            }
//
//            supportFragmentManager
//                    .beginTransaction()
//                    .replace(R.id.detailFrameLayout, fragment)
//                    .commit()
//        }
//
//        setupRecyclerView(mRecyclerView)
//
//    }
//
//    private fun setupRecyclerView(recyclerView: RecyclerView) {
//        recyclerView.adapter = SerieViewAdapter(this,getSeries(), twoPane, recyclerView)
//    }
//
//    class SerieViewAdapter(private val parentActivity: MainActivity,
//                           private val values: List<Serie>,
//                           private val twoPane: Boolean,
//                           private val recyclerView: RecyclerView):
//            RecyclerView.Adapter<SerieViewAdapter.ViewHolder>() {
//
//        private val onClickListener: View.OnClickListener
//
//        init {
//            onClickListener = View.OnClickListener { v ->
//
//                if (twoPane) {
//                    val fragment = DetailFragment().apply {
//                        arguments = Bundle().apply {
//                            putString("name",values[recyclerView.getChildAdapterPosition(v)].name)
//                            putString("author",values[recyclerView.getChildAdapterPosition(v)].author)
//                            putString("season",values[recyclerView.getChildAdapterPosition(v)].season.toString())
//                            putString("description",values[recyclerView.getChildAdapterPosition(v)].description)
//                            putString("url",values[recyclerView.getChildAdapterPosition(v)].url)
//                        }
//                    }
//                    parentActivity.supportFragmentManager
//                            .beginTransaction()
//                            .replace(R.id.detailFrameLayout, fragment)
//                            .commit()
//                } else {
//                    val intent = Intent(v.context, DetailActivity::class.java).apply {
//                        putExtra("name",values[recyclerView.getChildAdapterPosition(v)].name)
//                        putExtra("author",values[recyclerView.getChildAdapterPosition(v)].author)
//                        putExtra("season",values[recyclerView.getChildAdapterPosition(v)].season.toString())
//                        putExtra("description",values[recyclerView.getChildAdapterPosition(v)].description)
//                        putExtra("url",values[recyclerView.getChildAdapterPosition(v)].url)
//                    }
//                    v.context.startActivity(intent)
//                }
//            }
//        }
//
//        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//            val view = LayoutInflater.from(parent.context)
//                    .inflate(R.layout.serie_list_content, parent, false)
//            return ViewHolder(view)
//        }
//
//        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//            val serie = values[position]
//            holder.mPosterImageView?.let {
//                Glide.with(holder.itemView.context)
//                        .load(serie.url)
//                        .into(it)
//            }
//
//            with(holder.itemView) {
//                tag = serie
//                setOnClickListener(onClickListener)
//            }
//        }
//
//        override fun getItemCount() = values.size
//
//        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
//            val mPosterImageView: ImageView? = view.posterImageView
//        }
//    }
//
//    private fun getSeries(): MutableList<Serie>{
//        val mSerie:MutableList<Serie> = ArrayList()
//        mSerie.add(Serie("Juego de tronos", "George R. R. Martin", 8,"Esta serie, basada en los libros de George R.R. Martin, muestra la competencia entre familias nobles de siete reinos de Westeros, cuya finalidad es ganar el control sobre el Trono de Hierro.","https://cindybruchman.files.wordpress.com/2016/09/game-of-thrones-season-3.jpg"))
//        mSerie.add(Serie("La casa de papel", "Álex Pina", 3,"Una banda organizada de ladrones tiene el objetivo de cometer el atraco del siglo en la Fábrica Nacional de Moneda y Timbre. Cinco meses de preparación quedarán reducidos a once días para poder llevar a cabo con éxito el gran golpe.","https://es.web.img3.acsta.net/pictures/19/06/26/14/51/0019735.jpg"))
//        mSerie.add(Serie("Stranger Things", "Hermanos Duffer",3,"Una banda organizada de ladrones tiene el objetivo de cometer el atraco del siglo en la Fábrica Nacional de Moneda y Timbre. Cinco meses de preparación quedarán reducidos a once días para poder llevar a cabo con éxito el gran golpe.","https://es.web.img3.acsta.net/pictures/19/06/04/16/39/4888520.jpg"))
//        mSerie.add(Serie("The Flash", "Glen Winter",6 ,"Nueve meses después de que el laboratorio S.T.A.R. explotara, Barry despierta del coma y descubre que tiene el poder de la súper velocidad. Con la ayuda de su nuevo equipo, Barry, denominado ahora `Flash', luchará contra el crimen en Ciudad Central.","https://www.formulatv.com/images/series/posters/800/834/7_m1.jpg"))
//        mSerie.add(Serie("The Walking Dead", "Frank Darabont",10, "Tras estar en estado de coma, el expolicía Rick Grimes, descubre que una enfermedad originó un apocalipsis zombi. Rick liderará un grupo de sobrevivientes para buscar un lugar seguro, pero las luchas más peligrosas surgirán entre ellos mismos.","https://images-na.ssl-images-amazon.com/images/I/81gV5kbZBhL._SY445_.jpg"))
//        return mSerie
//    }
//}
//
//
