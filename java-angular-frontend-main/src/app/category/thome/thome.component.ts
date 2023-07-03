import { Component, OnInit } from '@angular/core';
import { CategoryService } from '../category.service';
import { Category } from '../category';

@Component({
  selector: 'app-index',
  templateUrl: './thome.component.html',
  styleUrls: ['./thome.component.css'],
})
export class HomeComponent implements OnInit {
  categories: Category[] = [];
  /*------------------------------------------
    --------------------------------------------
    Created constructor
    --------------------------------------------
    --------------------------------------------*/
  constructor(public categoryService: CategoryService) {}

  /**
   * Write code on Method
   *
   * @return response()
   */
  ngOnInit(): void {
    this.categoryService.getAll().subscribe((data: Category[]) => {
      this.categories = data;
      console.log(this.categories);
    });
  }
}
