package com.example.bookstore;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BookItemFragment extends Fragment {


    public List<Book> createBooks() {
        List<Book> books = new ArrayList<>();

        books.add(new Book("War and Peace", "Leo Tolstoy"));
        books.add(new Book("Stranger", "Albert Camus"));
        books.add(new Book("1984", "George Orwell"));
        books.add(new Book(" F. Scott Fitzgerald", "The Great Gatsby"));
        books.add(new Book("A Tale of Two Cities", "Charles Dickens"));
        books.add(new Book("Pride and Prejudice", "Jane Austen"));
        books.add(new Book("Brave New World", "Aldous Huxley"));
        books.add(new Book("Crime and Punishment", "Fyodor Dostoyevsky"));
        books.add(new Book("Don Quixote", "Miguel de Cervantes"));
        books.add(new Book("The Hobbit", "J. R. R. Tolkien"));
        books.add(new Book("The Lord of the Rings", "J. R. R. Tolkien"));

        return books;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        final View View = inflater.inflate(R.layout.fragment_books, container, false);


        final RecyclerView rvBooks = View.findViewById(R.id.rvBooks);
        final EditText bookEditText = View.findViewById(R.id.edText1);
        final EditText authorEditText = View.findViewById(R.id.edText2);
        Button addBook = View.findViewById(R.id.add_Button);


        final LinearLayoutManager llManager = new LinearLayoutManager(this.getContext());
        rvBooks.setLayoutManager(llManager);
        final BooksAdapter adapter = new BooksAdapter(createBooks());
        rvBooks.setAdapter(adapter);

        addBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(@NonNull View addBook) {
                String bookET = bookEditText.getText().toString();
                String authorET = (authorEditText.getText().toString());
                Book newBook = new Book(bookET, authorET);
                adapter.addNewBook(newBook);
                adapter.notifyDataSetChanged();
            }
        });

        return View;

    }

}



