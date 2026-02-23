package ru.easycode.zerotoheroandroidtdd

import org.junit.Assert.assertEquals
import org.junit.Test
import ru.easycode.zerotoheroandroidtdd.Count.Companion.MAX_SHOULD_BE_MORE_THAN_MIN
import ru.easycode.zerotoheroandroidtdd.Count.Companion.MAX_SHOULD_BE_MORE_THAN_STEP
import ru.easycode.zerotoheroandroidtdd.Count.Companion.MAX_SHOULD_BE_POSITIVE
import ru.easycode.zerotoheroandroidtdd.Count.Companion.STEP_SHOULD_BE_POSITIVE

/**
 * Please also check ui test
 * @see ru.easycode.zerotoheroandroidtdd.Task013Test
 */
class CountTest {

    @Test
    fun test() {
        val count: Count = Count.Base(step = 2, min = 0, max = 4)

        var actual: UiState = count.initial(number = "0")
        var expected: UiState = UiState.Min(text = "0")
        assertEquals(expected, actual)

        actual = count.increment(number = "0")
        expected = UiState.Base(text = "2")
        assertEquals(expected, actual)

        actual = count.increment(number = "2")
        expected = UiState.Max(text = "4")
        assertEquals(expected, actual)

        actual = count.decrement(number = "4")
        expected = UiState.Base(text = "2")
        assertEquals(expected, actual)

        actual = count.decrement(number = "2")
        expected = UiState.Min(text = "0")
        assertEquals(expected, actual)
    }

    @Test
    fun test_initial_max() {
        val count: Count = Count.Base(step = 3, min = 0, max = 6)

        val actual: UiState = count.initial(number = "6")
        val expected: UiState = UiState.Max(text = "6")
        assertEquals(expected, actual)
    }

    @Test
    fun test_initial_base() {
        val count: Count = Count.Base(step = 7, min = 0, max = 14)

        val actual: UiState = count.initial(number = "7")
        val expected: UiState = UiState.Base(text = "7")
        assertEquals(expected, actual)
    }

    @Test(expected = IllegalStateException::class)
    fun test_step_zero() {
        Count.Base(step = 0, min = 0, max = 11)
    }

    @Test(expected = IllegalStateException::class)
    fun test_step_negative() {
        Count.Base(step = -1, min = 0, max = 11)
    }

    @Test
    fun test_step_negative_message() {
        try {
            Count.Base(step = -2, min = 0, max = 11)
        } catch (e: Exception) {
            assertEquals("$STEP_SHOULD_BE_POSITIVE -2", e.message)
        }
    }

    @Test(expected = IllegalStateException::class)
    fun test_zero_max() {
        Count.Base(step = 3, min = 0, max = 0)
    }

    @Test(expected = IllegalStateException::class)
    fun test_negative_max() {
        Count.Base(step = 3, min = 0, max = -1)
    }

    @Test
    fun test_negative_max_message() {
        try {
            Count.Base(step = 5, min = 0, max = -2)
        } catch (e: Exception) {
            assertEquals("$MAX_SHOULD_BE_POSITIVE -2", e.message)
        }
    }

    @Test(expected = IllegalStateException::class)
    fun test_max_less_than_step() {
        Count.Base(step = 7, min = 0, max = 6)
    }

    @Test
    fun test_max_less_than_step_message() {
        try {
            Count.Base(step = 5, min = 0, max = 4)
        } catch (e: Exception) {
            assertEquals(MAX_SHOULD_BE_MORE_THAN_STEP, e.message)
        }
    }

    @Test(expected = IllegalStateException::class)
    fun test_max_less_than_min() {
        Count.Base(step = 5, min = 1, max = 0)
    }

    @Test
    fun test_max_less_than_min_message() {
        try {
            Count.Base(step = 5, min = 7, max = 6)
        } catch (e: Exception) {
            assertEquals(MAX_SHOULD_BE_MORE_THAN_MIN, e.message)
        }
    }
}
