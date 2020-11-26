package com.example.desktop.mymo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_memo.view.*

class MemoAdapter : RecyclerView.Adapter<Holder>() {    //RecyclerView.Adpater를 사용하기 위해 상속
    var memoData = mutableListOf<Memo>()    //리스트 데이터를 전달 받을 변수

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        //레이아웃 생성
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_memo, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        //데이터 삽입
        val data = memoData.get(position)
        holder.setMemoData(data)
    }

    override fun getItemCount(): Int {
        //리스트 아이템 수
        return memoData.size
    }
}
//매개변수로 있는 item은 하나의 리스트 아이템을 adapter로부터 전달받는 변수
class Holder(itemView: View) : RecyclerView.ViewHolder(itemView){   //뷰홀더를 사용하기 위해 상속
    fun setMemoData(memodata: Memo){    //개별 아이템에 대응하는 함수
        itemView.id_number.text = "${memodata.mid}" //해당 뷰에 데이터 전달
        itemView.text_title.text = memodata.title
    }
}