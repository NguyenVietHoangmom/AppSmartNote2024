package com.example.appghichu.newnote

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.appghichu.home.FragmentHomeViewModel
import com.example.appghichu.model.Product
import com.example.appsmartnote2024.R
import com.example.appsmartnote2024.base.BaseBindingFragment
import com.example.appsmartnote2024.databinding.FragmentNewNoteBinding
class FragmentNewNote : BaseBindingFragment<FragmentNewNoteBinding, FragmentNewNoteViewModel>() {
    private val listNewNote: MutableList<Product> = mutableListOf()
    private lateinit var sharedViewModel: FragmentHomeViewModel

    override fun getViewModel(): Class<FragmentNewNoteViewModel> {
        return FragmentNewNoteViewModel::class.java
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_new_note
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {
        Log.d("TAG", "onCreatedView: ")
        initData()
    }

    private fun initData() {
        // Gán giá trị trả về từ ViewModelProvider cho biến sharedViewModel
        sharedViewModel = ViewModelProvider(requireActivity()).get(FragmentHomeViewModel::class.java)

        binding.tvFinish.setOnClickListener {
            Log.d("Data", "initData: ")
            // Khi bạn muốn truyền dữ liệu từ FragmentNewNote về FragmentHome
            val dataToPass = binding.edNewFolder.text.toString()
            sharedViewModel.setNoteData(dataToPass)
            navigateFragment(R.id.fragment_home)

        }
    }
}