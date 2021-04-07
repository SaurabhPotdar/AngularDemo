import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AddComponent } from './_component/add/add.component';
import { Error404Component } from './_component/error404/error404.component';
import { ShowComponent } from './_component/show/show.component';
import { TempComponent } from './_component/temp/temp.component';
import { UpdateComponent } from './_component/update/update.component';


const routes: Routes = [
  { path: '', redirectTo: 'show', pathMatch: 'full' },
  { path: 'show', component: ShowComponent },
  { path: 'add', component: AddComponent },
  { path: 'update/:id', component: UpdateComponent },
  { path: 'temp', component: TempComponent },
  { path: '**', component: Error404Component }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
