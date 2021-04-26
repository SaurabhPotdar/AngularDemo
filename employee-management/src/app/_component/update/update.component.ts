import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from 'src/app/_model/employee.model';
import { EmployeeService } from 'src/app/_service/employee.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  constructor(private route: ActivatedRoute, private service: EmployeeService, private router: Router) { }

  updateId: any;
  model: Employee = { "id": 0, "name": "", "department": "", "phoneNumber": "" };
  oldModel:Employee;

  ngOnInit() {
    this.updateId = this.route.snapshot.paramMap.get("id");
    this.service.searchEmployee(this.updateId).subscribe((employee: Employee) => {
      this.model = employee;
      this.oldModel = { "id": this.model.id, "name": this.model.name, "department": this.model.department, "phoneNumber": this.model.phoneNumber };
    });
  }

  updateEmployee() {
    // if(this.oldModel != this.model){
    //   this.service.updateEmployee(this.model).subscribe(() => { alert("Updated successfully"); this.router.navigate(['/show']); }, (error) => { alert(error.error) });
    // }
    this.service.updateEmployee(this.model).subscribe(() => { alert("Updated successfully"); this.router.navigate(['/show']); }, (error) => { alert(error.error) });
  }

}
