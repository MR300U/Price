package com.example.myapplication

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.myapplication.databinding.RecyclerItemBinding
import com.example.myapplication.remote.dataModel.ContentModel
import java.util.ArrayList

class RecyclerMainAdapter (
    private val allData : ArrayList<ContentModel>
):RecyclerView.Adapter<RecyclerMainAdapter.MainViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        return MainViewHolder(RecyclerItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
            )
        )

    }

    override fun getItemCount(): Int = allData.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.setData(allData[position])
    }



    inner class MainViewHolder(
        private val binding: RecyclerItemBinding
    ):ViewHolder(binding.root){

        fun setData(data : ContentModel){
            binding.txtLabel.text = data.label
            binding.txtPrice.text = (data.price / 10).toString()
        }

    }

}