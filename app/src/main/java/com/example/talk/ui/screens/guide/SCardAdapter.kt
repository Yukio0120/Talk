package com.example.talk.ui.screens.guide

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.talk.R

class SCardAdapter : RecyclerView.Adapter<SCardAdapter.ViewHolder>() {

    private val titles = arrayOf(
        "Каргашилова Любовь Юрьевна",
        "Малеева Ольга Александровна",
        "Лехман Максим Сергеевич",
        "Сонкина Татьяна Александровна",
        "Рыжик Вадим"
    )
    private val position = arrayOf(
        "Заведующий общежитием",
        "Администратор общежития",
        "Администратор общежития",
        "Администратор общежития",
        "Председатель студенческого совета"
    )
    private val description = arrayOf(
        "График работы: Пн-Пт - 8:30-17:00 || Сб - Вс - Выходной",
        "График работы: Пн-Пт - 18:00-01:00 || Сб - 19:00-01:00 || Вс - Выходной",
        "График работы: Пн-Пт - 18:00-01:00 || Сб - Выходной || Вс - 19:00-01:00",
        "График работы: Пн-Пт - 12:30-19:30 || Сб - 09:00-14:00 || Вс - Выходной",
        " "
    )
    private val images = intArrayOf(
        R.drawable.lyuba,
        R.drawable.olya,
        R.drawable.max,
        R.drawable.default_photo,
        R.drawable.vadim
    )


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val v = LayoutInflater.from(viewGroup.context).inflate(R.layout.card_item, viewGroup, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, i: Int) {
        viewHolder.itemTitle.text = titles[i]
        viewHolder.itemPos.text = position[i]
        viewHolder.itemDesc.text = description[i]
        viewHolder.itemImage.setImageResource(images[i])
    }


    override fun getItemCount(): Int {
        return titles.size
    }

   inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
       var itemImage: ImageView
       var itemTitle: TextView
       var itemPos: TextView
       var itemDesc: TextView

       init {
           itemImage = itemView.findViewById(R.id.card_item_img)
           itemTitle = itemView.findViewById(R.id.card_item_title)
           itemPos = itemView.findViewById(R.id.card_item_pos)
           itemDesc = itemView.findViewById(R.id.card_item_desc)
       }
   }


}

