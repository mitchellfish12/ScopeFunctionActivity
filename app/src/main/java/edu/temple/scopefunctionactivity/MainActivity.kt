package edu.temple.scopefunctionactivity

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val randomArray = listOf(14.23, 73.91, 28.46, 42.19, 91.85, 19.67, 85.32, 46.58, 67.21)
        Log.d("function output", averageLessThanMedian(randomArray).toString())

        // You can test your helper functions by  calling them from onCreate() and
        // printing their output to the Log, which is visible in the LogCat:
        // eg. Log.d("function output", getTestDataArray().toString())

    }


    /* Convert all the helper functions below to Single-Expression Functions using Scope Functions */
    // eg. private fun getTestDataArray() = ...

    // HINT when constructing elaborate scope functions:
    // Look at the final/return value and build the function "working backwards"

    private fun getTestDataArray() : List<Int> {
        return List(10){ Random.nextInt(1, 100)}.sorted()
    }

    private fun averageLessThanMedian(listOfNumbers: List<Double>): Boolean =
        listOfNumbers.average() < listOfNumbers.sorted().let { list ->
            if (list.size % 2 == 0) (list[list.size / 2-1] + list[list.size / 2]) else list[list.size / 2]
        }

    // Create a view from an item in a collection, but recycle if possible (similar to an AdapterView's adapter)
    private fun getView(position: Int, recycledView: View?, collection: List<Int>, context: Context): View =
        (recycledView as? TextView) ?: TextView(context).apply {
            setPadding(5, 10, 10, 0)
            textSize = 22f
            text = collection[position].toString()
        }
}