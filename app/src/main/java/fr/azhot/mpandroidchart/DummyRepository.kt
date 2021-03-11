package fr.azhot.mpandroidchart

import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.PieEntry
import kotlin.random.Random

object DummyRepository {


    // functions
    fun getDummyEntries(): List<Entry> {
        return mutableListOf<Entry>().apply {
            this.add(Entry(0f, 0f))
            var xAxis = 1f
            var yAxis = 1f
            repeat(15) {
                this.add(Entry(xAxis, yAxis))
                xAxis++
                yAxis += xAxis / Random.Default.nextInt(1, 10)
            }
        }
    }

    fun getDummyPieEntries(): List<PieEntry> {
        return mutableListOf<PieEntry>().apply {
            repeat(6) {
                this.add(PieEntry(Random.Default.nextInt(7, 30).toFloat(), "Entry $it"))
            }
        }
    }
}