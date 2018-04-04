package com.skydoves.cameleonlayoutdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.skydoves.cameleonlayout.FilledStatus
import com.skydoves.cameleonlayout.OnLayerClickListener
import kotlinx.android.synthetic.main.item_episode.*
import kotlinx.android.synthetic.main.item_episode1.*
import kotlinx.android.synthetic.main.item_episode_glance.*
import kotlinx.android.synthetic.main.layout_progress.*

class MainActivity : AppCompatActivity(), OnLayerClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cameleonLayout.onLayerClickListener = this
        cameleonLayout1.setOnClickListener { cameleonLayout1.drawSecondLayout() }
        cameleonLayout2.setOnClickListener { cameleonLayout2.drawSecondLayout() }
        cameleonLayout3.setOnClickListener { cameleonLayout3.drawSecondLayout() }
    }

    override fun onClick(status: FilledStatus) {
        when(status) {
            is FilledStatus.UnFilled -> cameleonLayout.drawSecondLayout()
            is FilledStatus.Filled -> Toast.makeText(this, "clicked onFilled", Toast.LENGTH_SHORT).show()
        }
    }
}
