import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { Error404Component } from './_component/error404/error404.component';
import { ShowComponent } from './_component/show/show.component';
import { TempComponent } from './_component/temp/temp.component';


const routes: Routes = [
  { path: '', redirectTo: 'show', pathMatch: 'full' },
  { path: 'show', component: ShowComponent },
  { path: 'temp', component: TempComponent },
  { path: '**', component: Error404Component }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
