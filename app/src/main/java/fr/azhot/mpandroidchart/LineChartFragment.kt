package fr.azhot.mpandroidchart

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.LineData
import fr.azhot.mpandroidchart.databinding.FragmentLineChartBinding

class LineChartFragment : Fragment() {


    companion object {
        @JvmStatic
        fun newInstance(): LineChartFragment = LineChartFragment()
    }


    // variables
    private lateinit var binding: FragmentLineChartBinding
    private val viewModel: SharedViewModel by activityViewModels()


    // overridden functions
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initVariables()
        viewModel.title.value = getString(R.string.line_chart)
        setUpChartUI()
        setUpChartData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }


    // functions
    private fun initVariables() {
        binding = FragmentLineChartBinding.inflate(layoutInflater)
    }

    private fun setUpChartUI() {
        binding.root.apply {
            description = Description().apply { text = DUMMY_DESCRIPTION }
            animateX(500)
        }
    }

    private fun setUpChartData() {
        val dataSetA = viewModel.getLineDataSet(DUMMY_LABEL_A).apply {
            color = Color.RED
            lineWidth = 5f
            valueTextSize = 10f
        }
        val dataSetB = viewModel.getLineDataSet(DUMMY_LABEL_B).apply {
            color = Color.BLUE
            lineWidth = 8f
            valueTextSize = 10f
        }
        val lineData = LineData(dataSetA, dataSetB)
        binding.root.data = lineData // link data to the chart
        binding.root.invalidate() // refresh
    }
}