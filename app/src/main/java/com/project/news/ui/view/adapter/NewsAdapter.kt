package com.project.news.ui.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.project.core.model.remote.Article
import com.project.news.databinding.ListItemNewsBinding
import com.skydoves.whatif.whatIfNotNull

class NewsAdapter: PagingDataAdapter<Article, NewsAdapter.ViewHolder>(CharacterComparator) {

    class ViewHolder(
        private val binding: ListItemNewsBinding
    ): RecyclerView.ViewHolder(binding.root){

        fun bind(data: Article){
            binding.apply {
                tvTitle.text = data.title
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
        getItem(position).whatIfNotNull { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemNewsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        ))
    }
}