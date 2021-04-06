import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  constructor(private myhttp: HttpClient) { }

  getAllData(){
    return this.myhttp.get('http://localhost:9088/employees');
  }

}
