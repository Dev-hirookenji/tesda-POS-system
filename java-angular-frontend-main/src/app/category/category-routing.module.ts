import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { IndexComponent } from './index/index.component';
import { ViewComponent } from './view/view.component';
import { CreateComponent } from './create/create.component';
import { EditComponent } from './edit/edit.component';
import { HomeComponent } from './thome/thome.component';

const routes: Routes = [
  { path: 'category', redirectTo: 'category/index', pathMatch: 'full' },
  { path: 'category/index', component: IndexComponent },
  { path: 'category/:categoryId/view', component: ViewComponent },
  { path: 'category/create', component: CreateComponent },
  { path: 'category/:categoryId/edit', component: EditComponent },
  { path: 'category/thome', component: HomeComponent },
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class CategoryRoutingModule {}
