import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UpdateDetailsComponent } from './component/update-details/update-details.component';
import { TableDetailsComponent } from './component/table-details/table-details.component';

const routes: Routes = [
  { path: 'update/:tabName/:colName', component:  UpdateDetailsComponent},
  {path:'manualUpdate', component: TableDetailsComponent},
  {path:'',redirectTo:'/manualUpdate',pathMatch:'full'},
  {path:'**',redirectTo:'/manualUpdate',pathMatch:'full'}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
