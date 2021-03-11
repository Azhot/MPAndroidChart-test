package fr.azhot.mpandroidchart

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry

class SharedViewModel : ViewModel() {

    companion object {
        val TAG = this::class.simpleName
    }

    init {
        Log.i(TAG, "$TAG created.")
    }


    // variables
    var title = MutableLiveData<String>()


    // overridden functions
    override fun onCleared() {
        super.onCleared()
        Log.i(TAG, "$TAG destroyed.")
    }


    // functions
    fun updateActionBarTitle(title: String) {
        this.title.value = title
    }

    fun getEntries(): List<Entry> = DummyRepository.getDummyEntries()
    fun getLineDataSet(label: String): LineDataSet = LineDataSet(getEntries(), label)

    fun getPieEntries(): List<PieEntry> = DummyRepository.getDummyPieEntries()
    fun getPieDataSet(label: String): PieDataSet = PieDataSet(getPieEntries(), label)
}