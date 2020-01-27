import { Injectable } from '@angular/core';
import { Book } from '../../shared/models/book.model';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class BooksService {

  private readonly API_BOOKS = `${environment.serverUrl}/api/books`;

  // add http client to project
  constructor(private http: HttpClient) { }

  // CRUD

  create(book: Book): Observable<Book> {
    return this.http.post<Book>(this.API_BOOKS, book);
  }

  // return http. verb <type> (body, parameters)
  getAll(): Observable<Book[]> {
    return this.http.get<Book[]>(this.API_BOOKS);
  }

  findById(id: number): Observable<Book> {
    return this.http.get<Book>(`${this.API_BOOKS}/${id}`);
  }

  update(id: number, book: Book): Observable<Book> {
    return this.http.put<Book>(`${this.API_BOOKS}/${id}`, book);
  }

  delete(id: number): Observable<string> {
    return this.http.delete<string>(`${this.API_BOOKS}/${id}`);
  }
}
