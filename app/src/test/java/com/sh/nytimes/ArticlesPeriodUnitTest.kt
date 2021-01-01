package com.sh.nytimes

import com.sh.nytimes.data.sources.remote.ApiManager
import com.sh.nytimes.data.sources.remote.services.ArticlesService
import com.sh.nytimes.utils.DateUtils
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ArticlesPeriodUnitTest {

    private fun fetchArticles(period: Int) {
        val articlesService = ApiManager.getArticlesService()


        val response = articlesService.getViewed(period)
            .execute()
        assertTrue(response.isSuccessful)

        for (article in response.body()!!.results) {
            println(article.updated + " - " + DateUtils.getDiffDaysToToday(article.updated))
            assertTrue(DateUtils.getDiffDaysToToday(article.updated) <= period)
        }
    }

    @Test
    fun testOneDayArticles() {
        fetchArticles(ArticlesService.ONE_DAY)
    }

    @Test
    fun testSevenDaysArticles() {
        fetchArticles(ArticlesService.SEVEN_DAYS)
    }

    @Test
    fun testThirtyDaysArticles() {
        fetchArticles(ArticlesService.THIRTY_DAYS)
    }
}