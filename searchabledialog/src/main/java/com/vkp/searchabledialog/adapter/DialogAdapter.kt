package com.vkp.searchabledialog.adapter

import android.content.Context
import android.graphics.Typeface
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.vkp.searchabledialog.R
import com.vkp.searchabledialog.callback.OnItemSelectedListener
import com.vkp.searchabledialog.databinding.RvItemDialogBinding

internal class DialogAdapter(
    private val context: Context,
    private val list: ArrayList<String>,
    private val onItemSelectedListener: OnItemSelectedListener
) :
    RecyclerView.Adapter<DialogAdapter.ViewHolder>() {
    private var dialogListItems: ArrayList<String> = list
    private lateinit var selectedItem: String
    var highlightSelectedItem: Boolean = true


    inner class ViewHolder(val binding: RvItemDialogBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RvItemDialogBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        dialogListItems[position]?.let { currentSting ->
            holder.binding.apply {
                tvDialogItem.text = currentSting
                if (highlightSelectedItem && ::selectedItem.isInitialized) {
                    val colorDrawable: ColorDrawable = if (currentSting.equals(selectedItem, true)) {
                        ColorDrawable(ContextCompat.getColor(context, R.color.separatorColor))
                    } else {
                        ColorDrawable(ContextCompat.getColor(context, R.color.white))
                    }
                    //tvDialogItem.setTypeface(tvDialogItem.typeface, Typeface.NORMAL)
                    tvDialogItem.background = colorDrawable
                } /*else {
                    tvDialogItem.setTypeface(tvDialogItem.typeface, Typeface.BOLD)
                }*/
                tvDialogItem.setOnClickListener {
                    tvDialogItem.isClickable = false
                    selectedItem = currentSting
                    notifyDataSetChanged()
                    onItemSelectedListener.setOnItemSelectedListener(
                        getOriginalItemPosition(currentSting),
                        currentSting
                    )
                }
            }
        }
    }

    fun filter(query: CharSequence?) {
        val filteredNames: ArrayList<String> = ArrayList()
        if (query.isNullOrEmpty()) {
            filterList(list)
        } else {
            for (s in list) {
                if (s.contains(query, true)) {
                    filteredNames.add(s)
                }
            }
            filterList(filteredNames)
        }
    }

    private fun filterList(filteredNames: ArrayList<String>) {
        dialogListItems = filteredNames
        notifyDataSetChanged()
    }

    private fun getOriginalItemPosition(selectedString: String): Int {
        return list.indexOf(selectedString)
    }

    override fun getItemCount() = dialogListItems.size
}