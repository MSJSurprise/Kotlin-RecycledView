package com.example.kotlinrecycledview

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.w3c.dom.Text


class ContactAdapter(private val context: Context, private val contacts: List<Contact>)
    : RecyclerView.Adapter<ContactAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val contact = contacts[position]
        holder.bind(contact)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
            val tvName: TextView = itemView.findViewById<TextView>(R.id.tvName)
            val tvAge: TextView = itemView.findViewById<TextView>(R.id.tvAge)
            val ivProfile: ImageView = itemView.findViewById<ImageView>(R.id.ivProfile)

        fun bind(contact: Contact) {
            tvName.text = contact.name
            tvAge.text = "Age: ${contact.age}"


            //Glide.with(context).load(contact.imageUrl).into(ivProfile)
            Glide.with(context).load(contact.imageUrl).into(ivProfile)
        }
    }

}