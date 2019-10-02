package com.example.bookstore;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BooksViewHolder> implements View.OnClickListener  {


    public List<Book> books;

    public BooksAdapter(List<Book> books) {
        this.books = books;
    }


    public void addNewBook(Book book) {
       books.add(0, book);
       notifyItemInserted(books.size());
    }

    @NonNull
    @Override
    public BooksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View mView = inflater.inflate(R.layout.item_book, parent, false);

        BooksViewHolder viewHolder = new BooksViewHolder(mView);
        return viewHolder;
    }

    public void removeBook(Book book) {
        books.remove(book);
      notifyItemRemoved(books.size());
    }

        @Override
        public void onBindViewHolder(@NonNull final BooksViewHolder holder, int position) {
            final Book book = books.get(position);
            holder.tvName.setText(book.getName());
            holder.tvAuthor.setText(book.getAuthor());

            holder.imgRemoveBook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    books.remove(holder.getAdapterPosition());
                    notifyItemRemoved(holder.getAdapterPosition());
                }
            });
        }

    @Override
    public int getItemCount() {
        return books.size();
    }

    @Override
    public void onClick(View view) {
    }

    static class BooksViewHolder extends RecyclerView.ViewHolder {

        public TextView tvName;
        public TextView tvAuthor;
        public ImageView imgRemoveBook;

        public BooksViewHolder(@NonNull final View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvAuthor = itemView.findViewById(R.id.tvAuthor);
            imgRemoveBook = itemView.findViewById(R.id.remove_book);


        }
    }
}


