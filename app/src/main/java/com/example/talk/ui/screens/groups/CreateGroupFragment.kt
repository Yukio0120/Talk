package com.example.talk.ui.screens.groups

import androidx.recyclerview.widget.RecyclerView
import com.example.talk.R
import com.example.talk.models.CommonModel
import com.example.talk.ui.screens.base.BaseFragment
import com.example.talk.utilits.APP_ACTIVITY
import com.example.talk.utilits.getPlurals
import com.example.talk.utilits.hideKeyboard
import com.example.talk.utilits.showToast
import kotlinx.android.synthetic.main.fragment_create_group.*


class CreateGroupFragment(private var listContacts:List<CommonModel>)
    :BaseFragment(R.layout.fragment_create_group) {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: AddContactsAdapter

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = getString(R.string.create_group)
        hideKeyboard()
        initRecyclerView()
        create_group_btn_complete.setOnClickListener { showToast("Click") }
        create_group_input_name.requestFocus()
        create_group_counts.text = getPlurals(listContacts.size)
    }

    private fun initRecyclerView() {
        mRecyclerView = create_group_recycle_view
        mAdapter = AddContactsAdapter()
        mRecyclerView.adapter = mAdapter
        listContacts.forEach {  mAdapter.updateListItems(it) }
    }
}