import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Employee } from '../_model/employee.model';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private myhttp: HttpClient) { }

  localhost:string = "localhost";
  port:string = "9088";
  baseUrl:string = 'http://' + this.localhost + ':' + this.port;

  getAllData(){
    return this.myhttp.get(this.baseUrl + '/employees');
  }

  addEmployee(data: any) {
    return this.myhttp.post(this.baseUrl + '/employees', data);
  }

  updateEmployee(employee: Employee) {
    return this.myhttp.put(this.baseUrl + '/employees', employee);
  }

  deleteEmployee(id: any) {
    return this.myhttp.delete(this.baseUrl + '/employees/' + id);
  }

  searchEmployee(updateId: any) {
    return this.myhttp.get(this.baseUrl + '/employees/' + updateId);
  }

}
