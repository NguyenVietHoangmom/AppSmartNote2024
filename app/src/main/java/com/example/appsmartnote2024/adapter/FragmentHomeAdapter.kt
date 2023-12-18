package com.example.appghichu.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.appghichu.`interface`.IclickAdapterHome
import com.example.appghichu.model.Product
import com.example.appsmartnote2024.R
import com.example.appsmartnote2024.databinding.ItemFragmentHomeBinding
import com.example.appsmartnote2024.setImageBasedOnCondition


class FragmentHomeAdapter : RecyclerView.Adapter<FragmentHomeAdapter.FragmentHomeViewHolder>() {
    var isCheck =false

    var listHome: MutableList<Product> = mutableListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var iclickHomeAdapter: IclickAdapterHome? = null

    class FragmentHomeViewHolder(var binding: ItemFragmentHomeBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FragmentHomeViewHolder {
        val binding = ItemFragmentHomeBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return FragmentHomeViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listHome.size
    }

    override fun onBindViewHolder(holder: FragmentHomeViewHolder, position: Int) {
        with(listHome[position]) {
            with(holder.binding) {
                tvNumber.text = number.toString()
                tvDoccument.text = name.toString()
                imRight.setOnClickListener {
                    isCheck = !isCheck
                    imRight.setImageBasedOnCondition(isCheck, R.drawable.rightwhite, R.drawable.right)
                }
            }
        }
        holder.itemView.setOnClickListener {
            iclickHomeAdapter?.onClickItemHome(
                position, listHome[position]
            )
        }
    }


    // Phương thức để thêm một mục mới
    fun addItem(item: Product) {
        listHome.add(item)
        notifyItemInserted(listHome.size - 1)
    }
}


