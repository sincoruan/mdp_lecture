package com.example.recyclerviewtest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*

class MyAdapter(var clist:ArrayList<String>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>(){
    // Inflate the Layout to set in the RecyclerView and return the ViewHolder object
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.MyViewHolder {
        val v = LayoutInflater.from(parent?.context).inflate(R.layout.item_list, parent, false)
        return MyViewHolder(v);
    }

     // @return Size of the list of data.

    override fun getItemCount(): Int {
        return clist.size
    }
    // Binds the Array<String> values in to the ViewHolder name TextView designed in the item_list.xml
    override fun onBindViewHolder(holder: MyAdapter.MyViewHolder, position: Int) {
            holder.cname.text = clist[position]
    }

    /*RecyclerView.Adapter accepts the generic type of your Adapter inner class ViewHolder type.
 In this example Adapter class name is MyAdapter and the MyViewHolder  is the inner class */
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var cname = itemView.name

    }
    }

