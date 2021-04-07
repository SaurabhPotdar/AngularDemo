import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Employee } from '../_model/employee.model';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private myhttp: HttpClient) { }

  getAllData(){
    return this.myhttp.get('http://localhost:9088/employees');
  }

  addEmployee(data: any) {
    return this.myhttp.post('http://localhost:9088/employees', data);
  }

  updateEmployee(employee: Employee) {
    return this.myhttp.put('http://localhost:9088/employees', employee);
  }

  deleteEmployee(id: any) {
    return this.myhttp.delete('http://localhost:9088/employees/' + id,id);
  }

  searchEmployee(updateId: any) {
    return this.myhttp.get('http://localhost:9088/employees/' + updateId);
  }

}
