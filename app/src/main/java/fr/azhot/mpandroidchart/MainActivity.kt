package fr.azhot.mpandroidchart

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import fr.azhot.mpandroidchart.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    // variables
    private lateinit var binding: ActivityMainBinding
    private val viewModel: SharedViewModel by viewModels()


    // overridden functions
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initVariables()
        setUpTitleObserver()
        startPieChart()
        setContentView(binding.root)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.let {
            menuInflater.inflate(R.menu.menu, it)
            return true
        }
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.pieChart -> startPieChart()
            R.id.lineChart -> startLineChart()
        }
        return super.onOptionsItemSelected(item)
    }


    // functions
    private fun initVariables() {
        binding = ActivityMainBinding.inflate(layoutInflater)
    }

    private fun setUpTitleObserver() {
        viewModel.title.observe(this) { title ->
            supportActionBar?.title = title
        }
    }

    private fun startLineChart() {
        supportFragmentManager
            .beginTransaction()
            .replace(binding.fragmentContainer.id, LineChartFragment.newInstance())
            .commit()
    }

    private fun startPieChart() {
        supportFragmentManager
            .beginTransaction()
            .replace(binding.fragmentContainer.id, PieChartFragment.newInstance())
            .commit()
    }
}