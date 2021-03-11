package fr.azhot.mpandroidchart

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.utils.ColorTemplate
import fr.azhot.mpandroidchart.databinding.FragmentPieChartBinding

class PieChartFragment : Fragment() {


    companion object {
        @JvmStatic
        fun newInstance(): PieChartFragment = PieChartFragment()
    }


    // variables
    private lateinit var binding: FragmentPieChartBinding
    private val viewModel: SharedViewModel by activityViewModels()


    // overridden functions
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initVariables()
        viewModel.title.value = getString(R.string.pie_chart)
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
        binding = FragmentPieChartBinding.inflate(layoutInflater)
    }

    private fun setUpChartUI() {
        binding.root.apply {
            setUsePercentValues(true)
            description.isEnabled = false
            dragDecelerationFrictionCoef = 0.95f
            isDrawHoleEnabled = true
            transparentCircleRadius = 61f
            animateY(1000, Easing.EaseInOutCubic)
        }
    }

    private fun setUpChartDataSet(): PieDataSet {
        return viewModel.getPieDataSet(DUMMY_LABEL_C).apply {
            sliceSpace = 3f
            selectionShift = 5f
            colors = ColorTemplate.MATERIAL_COLORS.toList()
        }
    }

    private fun setUpChartData() {
        val pieData = PieData(setUpChartDataSet()).apply {
            setValueTextSize(10f)
            setValueTextColor(Color.WHITE)
        }

        binding.root.data = pieData // link data to the chart
        binding.root.invalidate() // refresh
    }
}