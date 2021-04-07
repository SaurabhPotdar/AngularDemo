import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from 'src/app/_model/employee.model';
import { EmployeeService } from 'src/app/_service/employee.service';


@Component({
  selector: 'app-show',
  templateUrl: './show.component.html',
  styleUrls: ['./show.component.css']
})
export class ShowComponent implements OnInit {

  constructor(private service: EmployeeService, private router: Router) { }

  employees: Employee[] = [];

  ngOnInit() {
    this.service.getAllData().subscribe((data: Employee[]) => { this.employees = data; }, error => {
      alert(error.error);
    });
  }

  updateEmployee(id: number) {
    this.router.navigate(['update', id]);
  }

  deleteEmployee(id: number) {
    this.service.deleteEmployee(id).subscribe(() => {
      alert("Deleted successfully");
      window.location.reload();
    });
  }

}
