package com.hantel.view.elements

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class CycleElementAdapter(private val dataset: Array<String>) : RecyclerView.Adapter<CycleElementAdapter.CycleViewHolder>() {

    class CycleViewHolder(cycleMenuElement: View): RecyclerView.ViewHolder(cycleMenuElement) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CycleViewHolder {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: CycleViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}