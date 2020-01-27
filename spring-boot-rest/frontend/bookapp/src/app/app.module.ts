import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ListBookComponent } from './features/list-book/list-book.component';
import { HttpClientModule } from '@angular/common/http';
import { BooksService } from './core/services/books.service';
import { AddBookComponent } from './features/add-book/add-book.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

@NgModule({
  declarations: [
    AppComponent,
    ListBookComponent,
    AddBookComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    ReactiveFormsModule,
  ],
  providers: [BooksService],
  bootstrap: [AppComponent]
})
export class AppModule { }
