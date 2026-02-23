package ru.easycode.zerotoheroandroidtdd

interface Count {

    companion object {
        internal const val STEP_SHOULD_BE_POSITIVE = "step should be positive, but was"
        internal const val MAX_SHOULD_BE_POSITIVE = "max should be positive, but was"
        internal const val MAX_SHOULD_BE_MORE_THAN_STEP = "max should be more than step"
        internal const val MAX_SHOULD_BE_MORE_THAN_MIN = "max should be more than min"
    }

    fun increment(number: String): UiState

    class Base(private val step: Int, private val max: Int) : Count {
        init {
            when {
                step <= 0 -> {
                    throw IllegalStateException("$STEP_SHOULD_BE_POSITIVE $step")
                }
                max <= 0 -> {
                    throw IllegalStateException("$MAX_SHOULD_BE_POSITIVE $max")
                }
                step > max -> {
                    throw IllegalStateException(MAX_SHOULD_BE_MORE_THAN_STEP)
                }
            }
        }

        override fun increment(number: String): UiState {
            val result = step + number.toInt()

            return when {
                result >= max -> UiState.Max(max.toString())
                result + step > max -> UiState.Max(result.toString())
                else -> UiState.Base(result.toString())
            }
        }
    }
}
