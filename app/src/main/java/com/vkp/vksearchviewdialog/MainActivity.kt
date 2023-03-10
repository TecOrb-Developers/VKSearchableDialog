package com.vkp.vksearchviewdialog

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.vkp.searchabledialog.SearchableDialog
import com.vkp.searchabledialog.callback.OnItemSelectedListener
import com.vkp.vksearchviewdialog.databinding.ActivityMainBinding
import com.vkp.vksearchviewdialog.models.AndroidOS

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    private lateinit var context: Context
    private lateinit var searchableDialogOS: SearchableDialog
    private var osList: ArrayList<AndroidOS> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        context = this
        setContentView(binding.root)
        initView()
        setListeners()
        Log.d("OS=", "onCreate: ${createOsList()}")
    }

    private fun initView() {
        createOsList()
        searchableDialogOS = SearchableDialog(context)
        searchableDialogOS.windowTitle = "Select/Search Android OS"
        searchableDialogOS.setSpinnerListItems(loadOSNameList(osList))
    }

    private fun loadOSNameList(osList: ArrayList<AndroidOS>): ArrayList<String> {
        val list: ArrayList<String> = arrayListOf()
        if (!osList.isNullOrEmpty()) {
            for (item in osList) {
                list.add(item.androidOS)
            }
        }
        return list
    }

    private fun setListeners() {
        binding.tvSelectedOS.setOnClickListener(this)
        searchableDialogOS.onItemSelectedListener = object : OnItemSelectedListener {
            override fun setOnItemSelectedListener(position: Int, selectedOsName: String) {
                binding.tvSelectedOS.text = selectedOsName

            }
        }
    }

    private fun createOsList(): ArrayList<AndroidOS> {

        osList.add(AndroidOS("Android Tiramisu", 33))
        osList.add(AndroidOS("Android 12L (Sv2)", 32))
        osList.add(AndroidOS("Android 12.0 (S)", 31))
        osList.add(AndroidOS("Android 11.0 (R)", 30))
        osList.add(AndroidOS("Android 10.0 (Q)", 29))
        osList.add(AndroidOS("Android 9.0 (Pie)", 28))
        osList.add(AndroidOS("Android 8.1 (Oreo)", 27))
        osList.add(AndroidOS("Android 8.0 (Oreo)", 26))
        osList.add(AndroidOS("Android 7.1.1 (Nougat)", 25))
        osList.add(AndroidOS("Android 7.0 (Nougat)", 24))
        osList.add(AndroidOS("Android 6.0 (Marshmallow)", 23))
        osList.add(AndroidOS("Android 5.1 (Lollipop)", 22))
        osList.add(AndroidOS("Android 5.0 (Lollipop)", 21))
        osList.add(AndroidOS("Android 4.4W (Kitkat Wear)", 20))
        osList.add(AndroidOS("Android 4.4 (Kitkat)", 19))
        osList.add(AndroidOS("Android 4.3 (Jelly Bean)", 18))
        osList.add(AndroidOS("Android 4.2 (Jelly Bean)", 17))
        osList.add(AndroidOS("Android 4.1 (Jelly Bean)", 16))
        osList.add(AndroidOS("Android 4.0.3 (IceCreamSandwich)", 15))
        osList.add(AndroidOS("Android 4.0 (IceCreamSandwich)", 14))
        osList.add(AndroidOS("Android 3.2 (Honeycomb)", 13))
        osList.add(AndroidOS("Android 3.1 (Honeycomb)", 12))
        osList.add(AndroidOS("Android 3.0 (Honeycomb)", 11))
        osList.add(AndroidOS("Android 2.3.3 (Gingerbread)", 10))
        osList.add(AndroidOS("Android 2.3 (Gingerbread)", 9))
        osList.add(AndroidOS("Android 2.2 (Froyo)", 8))
        osList.add(AndroidOS("Android 2.1 (Eclair)", 7))


        return osList
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.tvSelectedOS -> {
                searchableDialogOS.show()
            }
        }
    }
}