package com.example.myapplication

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.remote.dataModel.ContentModel
import com.example.myapplication.remote.dataModel.GoldModel
import com.example.myapplication.remote.dataModel.TimeModel
import com.example.myapplication.remote.gold.GoldApiRepository
import com.example.myapplication.remote.gold.GoldRequest
import com.example.myapplication.remote.time.TimeApiRepository
import com.example.myapplication.remote.time.TimeRequest



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val goldPrice = ArrayList<ContentModel>()

    private val currencyPrice = ArrayList<ContentModel> ()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        TimeApiRepository.instance.getTime(
            object : TimeRequest {
                override fun onSuccess(data: TimeModel) {

                    val date = data.date
                    val text = "${date.l_value} ${date.j_value} ${date.F_value} ${date.Y_value}"
                    binding.textDate.text = text
                }

                override fun onNotSuccess(message: String) {
                    Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
                }

                override fun onError(error: String) {
                    Toast.makeText(this@MainActivity, error, Toast.LENGTH_SHORT).show()
                }

            }
        )

        getPrice()

        binding.recyclerView.layoutManager =
            LinearLayoutManager(this,RecyclerView.VERTICAL , false)

        binding.txtArz.setOnClickListener {

            binding.txtArz.setTextColor(Color.parseColor("#E7C376"))
            binding.txtTala.setTextColor(Color.parseColor("#787879"))

            setData(currencyPrice)
        }

        binding.txtTala.setOnClickListener {

            binding.txtTala.setTextColor(Color.parseColor("#E7C376"))
            binding.txtArz.setTextColor(Color.parseColor("#787879"))

            setData(goldPrice)

        }

    }

    private fun getPrice(){

        GoldApiRepository.instance.getGold(

            object : GoldRequest {
                override fun onSuccess(data: GoldModel) {
                    goldPrice.addAll(data.data.golds)
                    currencyPrice.addAll(data.data.currencies)
                    setData(goldPrice)
                }

                override fun onNotSuccess(message: String) {
                }

                override fun onError(error: String) {
                }


            }
        )

    }

    private fun setData(data : ArrayList<ContentModel>){

        binding.recyclerView.adapter = RecyclerMainAdapter(data)
    }

}