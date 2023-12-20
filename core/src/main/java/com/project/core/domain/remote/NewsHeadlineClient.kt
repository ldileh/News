package com.project.core.domain.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.project.core.model.remote.Article
import com.project.core.utils.ext.safe
import timber.log.Timber
import kotlin.math.ceil

class NewsHeadlineClient(private val newsService: NewsService): PagingSource<Int, Article>() {

    override fun getRefreshKey(state: PagingState<Int, Article>): Int?{
        // Try to find the page key of the closest page to anchorPosition, from
        // either the prevKey or the nextKey, but you need to handle nullability
        // here:
        //  * prevKey == null -> anchorPage is the first page.
        //  * nextKey == null -> anchorPage is the last page.
        //  * both prevKey and nextKey null -> anchorPage is the initial page, so
        //    just return null.
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        val pageNumber = params.key ?: 1

        return try {
            val response = newsService.getTopHeadlines(page = pageNumber)
            val pagedResponse = response.body()
            val data = pagedResponse?.articles?.filterNot { it.author == null }
            val totalResult = pagedResponse?.totalResults.safe()
            val totalPage = ceil(totalResult.toFloat() / PAGE_SIZE)
                .let { if (it < 1) 1 else it }
                .toInt()

            var nextPageNumber: Int? = null
            if (pageNumber < totalPage) {
                nextPageNumber = pageNumber + 1
            }

            LoadResult.Page(
                data = data.orEmpty(),
                prevKey = null,
                nextKey = nextPageNumber
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    companion object{

        const val PAGE_SIZE = 20
    }
}