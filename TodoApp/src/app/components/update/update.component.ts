import { HttpService } from './../../services/http.service';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Todo } from 'src/app/model/todo';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  todoToBeUpdated: Todo;

  updatedForm: FormGroup;

  show: boolean = false;

  constructor(private httpService: HttpService, private fb: FormBuilder, private rout: ActivatedRoute) { }

  ngOnInit(): void {
    const id = this.rout.snapshot.paramMap.get('id');
    this.httpService.findById(+id).subscribe(todo => this.todoToBeUpdated = todo);


    this.updatedForm = this.fb.group({
      task: [''],
      description: [''],
      date: [''],
      done: [''],
    });
  }



  handelSubmitUpdate() {
    this.httpService.update(this.todoToBeUpdated.id, this.updatedForm.value).subscribe();
  }



  update() {
    this.updatedForm.setValue({
      task: this.todoToBeUpdated.task,
      description: this.todoToBeUpdated.description,
      date: this.todoToBeUpdated.date,
      done: this.todoToBeUpdated.done,
    });

    this.show = !this.show;

  }




  }

