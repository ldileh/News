package com.project.news.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.project.core.model.remote.Article
import com.project.core.utils.ext.dp
import com.project.core.utils.ext.formatDate
import com.project.core.utils.ext.safe
import com.project.news.databinding.ListItemNewsBinding
import com.skydoves.whatif.whatIfNotNull

class NewsAdapter(
    private val onSelectItem: (Article) -> Unit
) : PagingDataAdapter<Article, NewsAdapter.ViewHolder>(CharacterComparator) {

    class ViewHolder(
        private val binding: ListItemNewsBinding
    ): RecyclerView.ViewHolder(binding.root){

        fun bind(data: Article, position: Int, onSelectItem: (Article) -> Unit){
            binding.apply {
                root.layoutParams = (root.layoutParams as RecyclerView.LayoutParams).apply {
                    setMargins(
                        12.dp,
                        if(position == 0) 74.dp else 0,
                        12.dp,
                        0
                    )
                }

                tvTitle.text = data.title.safe()
                tvAuthor.text = data.source?.name.safe()
                tvTime.text = data.publishedAt.safe().formatDate("dd MMMM yyyy")

                ivBanner.load(data.urlToImage.safe(
                    "https://placeholder.pics/svg/300/DEDEDE/555555/Image%20Not%20Found"
                )){
                    crossfade(true)
                }

                root.setOnClickListener { onSelectItem(data) }
            }
        }
    }

    object CharacterComparator : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article) =
            oldItem.title == newItem.title

        override fun areContentsTheSame(oldItem: Article, newItem: Article) =
            oldItem == newItem
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position).whatIfNotNull { holder.bind(it, position, onSelectItem) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemNewsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }
}