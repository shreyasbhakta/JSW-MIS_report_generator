package com.example.jsw_mis_report_generator.report

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import android.widget.Toast
import androidx.lifecycle.ViewModelProviders
import com.example.jsw_mis_report_generator.HomeScreen.HomeScreen
import com.example.jsw_mis_report_generator.R
import com.example.jsw_mis_report_generator.menuForReportDetails
import com.example.jsw_mis_report_generator.outputDetails.ActualDetailsOutput
import com.example.jsw_mis_report_generator.usermenu.userMenuScreen
import kotlinx.android.synthetic.main.fragment_customer.*
import kotlinx.android.synthetic.main.fragment_report.*

class ReportFragment : Fragment() {

    companion object {
        fun newInstance() = ReportFragment()
    }

    private lateinit var viewmodel: ReportViewmodel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_report, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        viewmodel= ViewModelProviders.of(this).get(ReportViewmodel::class.java)




        reportUpdateDetails.setOnClickListener {
            val intent = Intent(requireContext(), ReportGeneration::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)

        }

        /*reportViewDetails.setOnClickListener {
            val intent = Intent(requireContext(), ::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)

        }*/

       /* reportpopup.setOnClickListener {
            val popup = PopupMenu(requireContext(),reportpopup)
            popup.inflate(R.menu.reportmenu)
            popup.setOnMenuItemClickListener {
                val item :MenuItem?=null
                when (item?.itemId) {
                    R.id.ractual -> {
                        val intent = Intent(requireContext(), ActualDetailsOutput::class.java)
                        startActivity(intent)
                        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                        startActivity(intent)
                        Toast.makeText(requireContext(), "clicked", Toast.LENGTH_LONG).show()
                        true
                    }
                    R.id.rplanned -> {
                        Toast.makeText(requireContext(), "clicked", Toast.LENGTH_LONG).show()
                        return@setOnMenuItemClickListener true
                    }
                    R.id.reportBydate -> {
                        Toast.makeText(requireContext(), "clicked", Toast.LENGTH_LONG).show()
                        return@setOnMenuItemClickListener true
                    }
                    else -> false
                }
                //Toast.makeText(requireContext(), "Item : " + it.title, Toast.LENGTH_SHORT).show()
                true
            }
            popup.show()
        }
*/
        reportViewDetails.setOnClickListener{
            val intent = Intent(requireContext(), menuForReportDetails::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            activity?.finish()
        }



        reportFragmentToUsermenu.setOnClickListener{
            val intent = Intent(requireContext(), userMenuScreen::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
        }
        gotoHomeFromReportFrag.setOnClickListener {
            val intent = Intent(requireContext(), HomeScreen::class.java)
            startActivity(intent)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            activity?.finish()
        }
    }

    /*private fun onMenuItemClick(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.ractual -> {
                val intent = Intent(requireContext(), OutputActualDetails::class.java)
                startActivity(intent)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
                true
            }
            R.id.rplanned -> {
                true
            }
            R.id.reportBydate -> {
                true
            }
            else -> false
        }
    }
*/
   /* fun onMenuItemClick(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.ractual -> {
                val intent = Intent(requireContext(), OutputActualDetails::class.java)
                startActivity(intent)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
                true
            }
            R.id.rplanned -> {
                true
            }
            R.id.reportBydate -> {
                true
            }
            else -> false
        }
    }

*/

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.ractual -> {
                val intent = Intent(requireContext(), ActualDetailsOutput::class.java)
                startActivity(intent)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
                Toast.makeText(requireContext(), "clicked", Toast.LENGTH_LONG).show()
                true
            }
            R.id.rplanned ->{
                Toast.makeText(requireContext(), "clicked", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.reportBydate ->{
                Toast.makeText(requireContext(), "clicked", Toast.LENGTH_LONG).show()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}