import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import {NgxPaginationModule} from 'ngx-pagination';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { Error404Component } from './_component/error404/error404.component';
import { ShowComponent } from './_component/show/show.component';
import { TempComponent } from './_component/temp/temp.component';
import { AddComponent } from './_component/add/add.component';

@NgModule({
  declarations: [
    AppComponent,
    ShowComponent,
    Error404Component,
    TempComponent,
    AddComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    NgxPaginationModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
