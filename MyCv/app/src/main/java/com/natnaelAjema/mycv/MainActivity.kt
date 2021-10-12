package com.natnaelAjema.mycv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.natnaelAjema.mycv.Adapter.FragmentPageAdapter
import com.natnaelAjema.mycv.fragments.AboutMe
import com.natnaelAjema.mycv.fragments.Contact
import com.natnaelAjema.mycv.fragments.Home
import com.natnaelAjema.mycv.fragments.WorkExperience

class MainActivity : AppCompatActivity() {
    lateinit var viewPage: ViewPager;
    lateinit var tabLayout:TabLayout;
    lateinit var adapter: FragmentPageAdapter;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewPage=findViewById(R.id.view_pager);
        tabLayout=findViewById(R.id.tab)
        adapter= FragmentPageAdapter(supportFragmentManager)
        adapter.add(Home(),"Home")
        adapter.add(WorkExperience(),"Experience")
        adapter.add(AboutMe(),"About")
        adapter.add(Contact(),"Contact");
        viewPage.adapter=adapter;
        tabLayout.setupWithViewPager(viewPage)


    }
}