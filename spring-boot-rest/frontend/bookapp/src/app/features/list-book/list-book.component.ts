import { Component, OnInit } from '@angular/core';
import { BooksService } from '../../core/services/books.service';
import { Book } from 'src/app/shared/models/book.model';

@Component({
  selector: 'app-list-book',
  templateUrl: './list-book.component.html',
  styleUrls: ['./list-book.component.scss']
})
export class ListBookComponent implements OnInit {

  public books: Book[];

  constructor(private bookService: BooksService) { }

  ngOnInit() {
    this.bookService.getAll() // observable Book
      .subscribe((data: Book[]) => {
        this.books = data; // save Book[] from the observable
        this.books.forEach(book => {
          console.log(book);
        });
      });
  }

}
