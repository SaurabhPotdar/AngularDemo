import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { EmployeeService } from 'src/app/_service/employee.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  constructor(private service: EmployeeService, private router: Router) { }

  model:any={};

  ngOnInit() {
  }

  addProduct(){
    this.service.addProduct(this.model).subscribe((data)=>{alert("Added successfully"); this.router.navigate(['/show']);}, (error)=>{alert(error.error)});
  }

}
