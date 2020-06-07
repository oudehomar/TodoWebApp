import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Todo } from '../model/todo';

@Injectable({
  providedIn: 'root'
})
export class HttpService {

  url: string = 'http://localhost:8080/todo/'

  constructor(private http: HttpClient) { }

  public fetchAll(): Observable<Todo[]> {

    return this.http.get<Todo[]>(this.url + 'findall');
  }


  public addTodo(todo: Todo) {

    return this.http.post<Todo>(this.url + 'add', todo);
  }


  public delete(id: number) {
    return this.http.delete<Todo>(this.url + 'delete/' + id);

  }


}
