import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { Error404Component } from './_component/error404/error404.component';
import { ShowComponent } from './_component/show/show.component';
import { TempComponent } from './_component/temp/temp.component';

@NgModule({
  declarations: [
    AppComponent,
    ShowComponent,
    Error404Component,
    TempComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
