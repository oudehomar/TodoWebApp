import { HttpService } from './../../services/http.service';
import { Component, OnInit } from '@angular/core';
import { Todo } from 'src/app/model/todo';

@Component({
  selector: 'app-show-all',
  templateUrl: './show-all.component.html',
  styleUrls: ['./show-all.component.css']
})
export class ShowAllComponent implements OnInit {

  constructor(private httpService:HttpService) { }

  listOfTodos:Todo[];

  ngOnInit(): void {

    this.httpService.fetchAll().subscribe(todo =>this.listOfTodos=todo);


  }

}
