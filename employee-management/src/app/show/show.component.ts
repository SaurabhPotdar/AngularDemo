import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../employee.model';
import { EmployeeService } from '../employee.service';

@Component({
  selector: 'app-show',
  templateUrl: './show.component.html',
  styleUrls: ['./show.component.css']
})
export class ShowComponent implements OnInit {

  constructor(private service: EmployeeService, private router: Router) { }

  employees: Employee[] = [];

  ngOnInit() {
    this.service.getAllData().subscribe((data: Employee[]) => { this.employees = data; console.log(this.employees); }, error => { alert(error.error);
    console.log(error.error);
    });
  }

}
