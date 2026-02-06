import android.widget.LinearLayout
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withParent
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.hamcrest.Matchers.allOf
import org.junit.Rule
import org.junit.Test
import ru.easycode.zerotoheroandroidtdd.MainActivity
import ru.easycode.zerotoheroandroidtdd.R

class Task003Test {

    @get:Rule
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test_change_parent() {
        onView(
            allOf(
                withId(R.id.titleTextView),
                withText(R.string.i_am_an_android_developer),
                withParent(isAssignableFrom(LinearLayout::class.java))
            )
        ).check(matches(isDisplayed()))
    }
}
