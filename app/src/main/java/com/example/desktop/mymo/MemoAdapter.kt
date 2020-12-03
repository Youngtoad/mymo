package com.example.desktop.mymo

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_memo.view.*

class MemoAdapter(val context: Context, val memos: List<Memo>, val itemClick: (Memo) -> Unit) :
    RecyclerView.Adapter<MemoAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_memo, parent, false)
        return Holder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return memos.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bind(memos[position])
    }

    inner class Holder(itemView: View?, itemClick: (Memo) -> Unit) : RecyclerView.ViewHolder(itemView!!) {
        val midTv = itemView?.findViewById<TextView>(R.id.id_number)
        val titleTv = itemView?.findViewById<TextView>(R.id.text_title)

        fun bind(memo: Memo) {

            midTv?.text = memo.mid.toString()
            titleTv?.text = memo.title.toString()

            itemView.setOnClickListener{ itemClick(memo) }
        }
    }
}