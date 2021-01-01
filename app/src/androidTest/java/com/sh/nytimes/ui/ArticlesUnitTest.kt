package com.sh.nytimes.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import com.sh.nytimes.BuildConfig
import com.sh.nytimes.R
import com.sh.nytimes.data.models.Article
import com.sh.nytimes.ui.activities.MainActivity
import com.sh.nytimes.ui.fragments.articles.ArticlesAdapter
import com.sh.nytimes.ui.utils.MockDataUtil
import com.sh.nytimes.ui.utils.MockServerDispatcher
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.io.IOException

@LargeTest
class ArticlesUnitTest {

    private val mockWebServer = MockWebServer()

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java, true, false)

    @Before
    @Throws(IOException::class, InterruptedException::class)
    fun setupServer() {
        mockWebServer.start(BuildConfig.MOCK_PORT_NUMBER)
        mockWebServer.dispatcher = MockServerDispatcher()
    }

    @After
    fun teardown() {
        mockWebServer.shutdown()
    }

    @Test
    fun testArticleClickAndDetails() {

        val articlePosition = 3
        val article = MockDataUtil.getArticle(articlePosition)

        activityRule.launchActivity(null)
        onView(withId(R.id.recyclerView_articles))
            .perform(
                RecyclerViewActions.actionOnItemAtPosition<ArticlesAdapter.ArticleViewHolder>(
                    articlePosition,
                    ViewActions.click()
                )
            )
        testDetailsViewModel(article)
    }

    private fun testDetailsViewModel(article: Article) {
        onView(withId(R.id.txt_title))
            .check(matches(withText(article.title)))
        if (article.media.isNotEmpty())
            onView(withId(R.id.txt_caption)).check(matches(withText(article.media[0].caption)))
        onView(withId(R.id.txt_abstract)).check(matches(withText(article.abstractDescription)))
        onView(withId(R.id.txt_by)).check(matches(withText(article.byline)))
        onView(withId(R.id.txt_published_at)).check(matches(withText(article.publishedDate)))
    }
}