package ru.easycode.zerotoheroandroidtdd

interface Count {

    companion object {
        internal const val STEP_SHOULD_BE_POSITIVE = "step should be positive, but was"
        internal const val MAX_SHOULD_BE_POSITIVE = "max should be positive, but was"
        internal const val MAX_SHOULD_BE_MORE_THAN_STEP = "max should be more than step"
        internal const val MAX_SHOULD_BE_MORE_THAN_MIN = "max should be more than min"
    }

    fun initial(number: String): UiState
    fun decrement(number: String): UiState
    fun increment(number: String): UiState

    class Base(private val min: Int,private val step: Int, private val max: Int) : Count {

        init {
            when {
                step <= 0 -> throw IllegalStateException("$STEP_SHOULD_BE_POSITIVE $step")
                max <= 0 -> throw IllegalStateException("$MAX_SHOULD_BE_POSITIVE $max")
                min > max -> throw IllegalStateException(MAX_SHOULD_BE_MORE_THAN_MIN)
                step > max -> throw IllegalStateException(MAX_SHOULD_BE_MORE_THAN_STEP)
            }
        }

        override fun initial(number: String): UiState = when (number.toInt()) {
            min -> UiState.Min(min.toString())
            max -> UiState.Max(max.toString())
            else -> UiState.Base(number)
        }

        override fun decrement(number: String): UiState {
            val result = number.toInt() - step

            return when {
                result <= min -> UiState.Min(min.toString())
                result - step < min -> UiState.Min(result.toString())
                else -> UiState.Base(result.toString())
            }
        }

        override fun increment(number: String): UiState {
            val result = number.toInt() + step

            return when {
                result >= max -> UiState.Max(max.toString())
                result + step > max -> UiState.Max(result.toString())
                else -> UiState.Base(result.toString())
            }
        }
    }
}
