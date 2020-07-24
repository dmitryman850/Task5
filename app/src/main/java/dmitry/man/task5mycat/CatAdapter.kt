package dmitry.man.task5mycat

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CatAdapter : RecyclerView.Adapter<CatViewHolder>() {

    private val listOfCats = mutableListOf<Cats>()

    private lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, null)
        return CatViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listOfCats.size
    }

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        val width = listOfCats[position].width
        val height = listOfCats[position].height
        val imageUrl = listOfCats[position].imageUrl ?: ""

        holder.bind(imageUrl, width, height, context)
    }

    fun addItems(newItems: List<Cats>) {
        listOfCats.addAll(newItems)
        notifyDataSetChanged()
    }
}

class CatViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val imageView = view.findViewById<ImageView>(R.id.imageView)

    fun bind(imageUrl: String, width: Int, height: Int, context: Context) {
        Glide.with(context)
            .load(imageUrl)
            .override(width, height)
            .into(imageView)

        imageView.setOnClickListener(View.OnClickListener { v -> Toast.makeText(context,
            "Котики нажаты",
            Toast.LENGTH_SHORT).show() })
    }
}
