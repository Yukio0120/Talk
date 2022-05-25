package com.example.talk.ui.screens.guide

import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.talk.R
import com.example.talk.ui.screens.base.BFrag
import com.example.talk.utilits.APP_ACTIVITY
import com.example.talk.utilits.replaceFragment
import kotlinx.android.synthetic.main.card_view_full.*


class GuideFragment : BFrag(R.layout.card_view_full) {

    private lateinit var adapter: SCardAdapter
    private lateinit var mRecyclerView: RecyclerView

    override fun onResume() {
        super.onResume()
        setHasOptionsMenu(true)
        APP_ACTIVITY.title = getString(R.string.navbar_guide)
        initCard()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity?.menuInflater?.inflate(R.menu.scard_action_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.btn_all_number -> replaceFragment(AllNumberFrag())
            R.id.btn_dom_info -> replaceFragment(AboutDomFrag())
        }
        return true
    }

    private fun initCard(){

        mRecyclerView = card_recycle_view
        adapter = SCardAdapter()

        mRecyclerView.layoutManager = LinearLayoutManager(APP_ACTIVITY)
        mRecyclerView.adapter = adapter
    }

}
