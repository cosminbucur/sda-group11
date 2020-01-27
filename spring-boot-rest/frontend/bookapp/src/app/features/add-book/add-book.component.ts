import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { Book } from '../../shared/models/book.model';
import { BooksService } from '../../core/services/books.service';

@Component({
  selector: 'app-add-book',
  templateUrl: './add-book.component.html',
  styleUrls: ['./add-book.component.scss']
})
export class AddBookComponent implements OnInit {

  public myForm: FormGroup;

  public book: Book;

  constructor(private bookService: BooksService) { }

  ngOnInit() {
  }

  public onSubmit(): void {
    this.bookService.create()
  }
}
