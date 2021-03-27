package com.example.jsw_mis_report_generator

import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.view.WindowManager
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.jsw_mis_report_generator.LoginManagement.Login.Login
import com.google.android.material.button.MaterialButton


class Onboarding : AppCompatActivity() {

    private lateinit var onboardingItemsAdapter: OnboardingItemsAdapter
    private lateinit var indicatorContainer: LinearLayout



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_onboarding)
        val isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                .getBoolean("isFirstRun", true)

        if (isFirstRun) {
            //show start activity
            //startActivity(Intent(this@Onboarding, Login::class.java))
            setOnboardingItems()
            setupIndicators()
            setCurrentIndicator(0)

        }else{
            navigateToHomeActivity()
        }





        getSharedPreferences("PREFERENCE", MODE_PRIVATE).edit()
                .putBoolean("isFirstRun", false).commit()


    }

    private fun setOnboardingItems() {
        onboardingItemsAdapter = OnboardingItemsAdapter(
                listOf(
                        OnboardingItem(
                                onboardingImage = R.drawable.jswpic,
                                title = "Better Everyday",
                                description = "Lead by Mr Sajjan Jindal, the company’s success story has been scripted essentially by its resolve to innovate, set new standards, enhance capabilities, enrich lives and to ensure that it stays true to its cherished value system.The current steelmaking capacity of JSW group is 18 MTPA and by 2025, JSW Steel aims to produce 40 MTPA."
                        ),
                        OnboardingItem(
                                onboardingImage = R.drawable.report2,
                                title = "Report Generator",
                                description = "Generates a MIS report comparing Plan Production vs Actual Production, for the date entered by the user."
                        ),
                        OnboardingItem(
                                onboardingImage = R.drawable.knowyourcustomer,
                                title = "Customer Details",
                                description = "Displays the details about Customers. Customers details such as customer's name, enquiry no., order quantity and shipment date can be viewed."
                        )

                )
        )
        val onboardingViewPager = findViewById<ViewPager2>(R.id.onboardingViewPager)
        onboardingViewPager.adapter = onboardingItemsAdapter
        onboardingViewPager.registerOnPageChangeCallback(object :
                ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                setCurrentIndicator(position)
            }
        })
        (onboardingViewPager.getChildAt(0) as RecyclerView).overScrollMode =
            RecyclerView.OVER_SCROLL_NEVER
        findViewById<ImageView>(R.id.imageNext).setOnClickListener{
            if (onboardingViewPager.currentItem + 1 < onboardingItemsAdapter.itemCount) {
                onboardingViewPager.currentItem += 1
            }else {
                navigateToHomeActivity()
            }
        }
        findViewById<TextView>(R.id.textSkip).setOnClickListener{

            navigateToHomeActivity()
            //setFirstTimeLaunchToFalse()

        }
        findViewById<MaterialButton>(R.id.buttonGetStarted).setOnClickListener{
            navigateToHomeActivity()
           // setFirstTimeLaunchToFalse()
           // navigateToHomeActivity()

        }
    }

    private fun navigateToHomeActivity() {
        startActivity(Intent(applicationContext, Login::class.java))
        finish()
    }

    private fun setupIndicators() {
        indicatorContainer = findViewById(R.id.indicatorsContainer)
        val indicators = arrayOfNulls<ImageView>(onboardingItemsAdapter.itemCount)
        val layoutParams: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(WRAP_CONTENT, WRAP_CONTENT)
        layoutParams.setMargins(10, 0, 10, 0)
        for (i in indicators.indices) {
            indicators[i] = ImageView(applicationContext)
            indicators[i]?.let{
                it.setImageDrawable(
                        ContextCompat.getDrawable(
                                applicationContext,
                                R.drawable.navigator_circles
                        )
                )
                it.layoutParams = layoutParams
                indicatorContainer.addView(it)
            }
        }
    }

    private fun setCurrentIndicator(position: Int) {
        val childCount = indicatorContainer.childCount
        for(i in 0 until childCount) {
            val imageView = indicatorContainer.getChildAt(i) as ImageView
            if (i == position) {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(
                                applicationContext,
                                R.drawable.navigator_background
                        )
                )
            }else {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(
                                applicationContext,
                                R.drawable.navigator_circles
                        )
                )
            }
        }
    }

   // private fun setFirstTimeLaunchToFalse() {
  //      prefManager.isFirstTimeLaunch = false
  //  }

}