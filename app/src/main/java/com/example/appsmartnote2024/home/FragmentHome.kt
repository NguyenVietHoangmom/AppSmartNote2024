package com.example.appghichu.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.appghichu.adapter.FragmentHomeAdapter
import com.example.appghichu.`interface`.IclickAdapterHome
import com.example.appghichu.model.Product
import com.example.appghichu.newnote.FragmentNewNote
import com.example.appsmartnote2024.Constant
import com.example.appsmartnote2024.R
import com.example.appsmartnote2024.base.BaseBindingFragment
import com.example.appsmartnote2024.databinding.FragmentHomeBinding

class FragmentHome : BaseBindingFragment<FragmentHomeBinding, FragmentHomeViewModel>() {

    private lateinit var sharedViewModel: FragmentHomeViewModel
    private val listHomeFragment: MutableList<Product> = mutableListOf()
    private var fragmentHomeAdapter: FragmentHomeAdapter? = null

    override fun getViewModel(): Class<FragmentHomeViewModel> {
        return FragmentHomeViewModel::class.java
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_home
    }

    override fun onCreatedView(view: View?, savedInstanceState: Bundle?) {


        initData()
        onClick()

    }

    private fun initData() {
        sharedViewModel = ViewModelProvider(this).get(FragmentHomeViewModel::class.java)

        sharedViewModel.noteData.observe(viewLifecycleOwner, Observer { newData ->
            // Xử lý dữ liệu nhận được từ FragmentNewNote ở đây

            // Ví dụ: Tạo một sản phẩm mới từ dữ liệu và thêm vào Adapter
            val newProduct = Product(number = listHomeFragment.size + 1, name = newData, id = "", image_url = "")
            fragmentHomeAdapter?.addItem(newProduct)
        })
    }

    private fun onClick() {
        fragmentHomeAdapter=FragmentHomeAdapter().apply {
        binding.rcvRecyclerview.adapter=this
        with(binding) {
            imIconFolder.setOnClickListener {
                val fragmentNewNote = FragmentNewNote()
                Bundle().apply {
                    putString(Constant.KEY_ADD, "key_add")
                    fragmentNewNote.arguments
                    navigateFragment(R.id.fragment_new_note)
                }
            }
        }}
    }
}