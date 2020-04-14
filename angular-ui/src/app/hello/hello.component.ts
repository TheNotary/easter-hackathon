import { Component, OnInit } from '@angular/core';
import Hello from '../hello';

@Component({
  selector: 'app-hello',
  templateUrl: './hello.component.html',
  styleUrls: ['./hello.component.css']
})
export class HelloComponent implements OnInit {

  hello: Hello = {
    id: 1,
    title: "hero",
    body: "hero",
    is_good: true,
    created_at: null,
    updated_at: null,
  };

  constructor() { }

  ngOnInit(): void {
  }

}
