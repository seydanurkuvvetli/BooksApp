package com.example.booksapp.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.booksapp.common.gone
import com.example.booksapp.common.loadImage
import com.example.booksapp.common.visible
import com.example.booksapp.data.model.Book
import com.example.booksapp.databinding.ItemBookBinding


class BooksAdapter(private val bookListener: BookListener) :
    ListAdapter<Book, BooksAdapter.BookViewHolder>(BookDiffCallBack()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder =
        BookViewHolder(
            ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            bookListener
        )

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) =
        holder.bind(getItem(position))


    class BookViewHolder(
        val binding: ItemBookBinding,
        private val bookListener: BookListener
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(book: Book) = with(binding) {
            txtName.text = book.name
            txtPrice.text = "${book.price} ₺"
            imgBook.loadImage(book.imageUrl)


            if (book.isBestSeller == true) {
                bestSellerBadge.visible()
            } else {
                bestSellerBadge.gone()
            }



            root.setOnClickListener {
                bookListener.onBookClick(book.id ?: 1)
            }
        }
    }

    class BookDiffCallBack : DiffUtil.ItemCallback<Book>() {
        override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
            return oldItem == newItem
        }
    }

    interface BookListener {
        fun onBookClick(id: Int)


    }
}

