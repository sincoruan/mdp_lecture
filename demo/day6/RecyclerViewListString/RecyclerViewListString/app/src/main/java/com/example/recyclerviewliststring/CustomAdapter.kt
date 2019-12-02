package com.example.recyclerviewliststring
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class CustomAdapter(val booklist: ArrayList<Book>): RecyclerView.Adapter<CustomAdapter.MyViewHolder>() {
    /**
     * Sets the contents of an item at a given position in the RecyclerView.
     * Called by RecyclerView to display the data at a specified position.
     *
     * @param holder The view holder for that position in the RecyclerView.
     * @param position The position of the item in the RecycerView.
     */
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder?.bName?.text = booklist[position].name
        holder?.bAuthor.text = booklist[position].author
    }
    /**
     * Inflates an item view and returns a new view holder that contains it.
     * Called when the RecyclerView needs a new view holder to represent an item.
     *
     * @param parent The view group that holds the item views.
     * @param viewType Used to distinguish views, if more than one type of item view is used.
     * @return a view holder.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(v);
    }
    /**
     * Returns the size of the container that holds the data.
     * @return Size of the list of data.
     */
    override fun getItemCount(): Int {
        return booklist.size
    }

    /*RecyclerView.Adapter accepts the generic type of your Adapter inner class ViewHolder type.
  In this example Adapter class name is CustomAdapter and the MyViewHolder  is the inner class */
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val bName = itemView.findViewById<TextView>(R.id.name)
        val bAuthor = itemView.findViewById<TextView>(R.id.author)
    }
}