package com.example.talk.ui.screens.groups

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.talk.R
import com.example.talk.database.*
import com.example.talk.models.CommonModel
import com.example.talk.utilits.APP_ACTIVITY
import com.example.talk.utilits.AppValueEventListener
import com.example.talk.utilits.hideKeyboard
import kotlinx.android.synthetic.main.fragment_add_contacts.*
import kotlinx.android.synthetic.main.fragment_main_list.*


class AddContactsFragment : Fragment(R.layout.fragment_add_contacts) {

    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter: AddContactsAdapter
    private val mRefMainList = REF_DATABASE_ROOT.child(NODE_MAIN_LIST).child(CURRENT_UID)
    private val mRefUsers = REF_DATABASE_ROOT.child(NODE_USERS)
    private val mRefMessages = REF_DATABASE_ROOT.child(NODE_MESSAGES).child(CURRENT_UID)
    private var mListItems = listOf<CommonModel>()

    override fun onResume() {
        super.onResume()
        APP_ACTIVITY.title = "Добавить участника"
        APP_ACTIVITY.mAppDrawer.enableDrawer()
        hideKeyboard()
        initRecyclerView()
        add_contacts_btn_next.setOnClickListener {
            listContacts.forEach {
                println(it.id)
            }
        }
    }

    private fun initRecyclerView() {
        mRecyclerView = add_contacts_recycle_view
        mAdapter = AddContactsAdapter()

        // 1 запрос
        mRefMainList.addListenerForSingleValueEvent(AppValueEventListener { dataSnapshot ->
            mListItems = dataSnapshot.children.map { it.getCommonModel() }
            mListItems.forEach { model ->

                // 2 запрос
                mRefUsers.child(model.id)
                    .addListenerForSingleValueEvent(AppValueEventListener { dataSnapshot1 ->
                        val newModel = dataSnapshot1.getCommonModel()

                        // 3 запрос
                        mRefMessages.child(model.id).limitToLast(1)
                            .addListenerForSingleValueEvent(AppValueEventListener { dataSnapshot2 ->
                                val tempList = dataSnapshot2.children.map { it.getCommonModel() }

                                if (tempList.isEmpty()){
                                    newModel.lastMessage = "Чат очищен"
                                } else {
                                    newModel.lastMessage = tempList[0].text
                                }


                                if (newModel.fullname.isEmpty()) {
                                    newModel.fullname = newModel.phone
                                }
                                mAdapter.updateListItems(newModel)
                            })
                    })
            }
        })

        mRecyclerView.adapter = mAdapter
    }

    companion object{
        val listContacts = mutableListOf<CommonModel>()
    }
}