package com.example.myapplication

object ResultFormatter {
    fun format(result: SortResult): String {
        val sortedLine = result.sorted.joinToString(", ")
        return "$sortedLine\nПроходов: ${result.passes}, обменов: ${result.swaps}"
    }
}