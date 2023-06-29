import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
    
import {  Observable, throwError } from 'rxjs';
import { catchError } from 'rxjs/operators';
   
import { Category } from './category';
    
@Injectable({
  providedIn: 'root'
})
export class CategoryService {
    
  private apiURL = "http://127.0.0.1:8080/api/v1";
    
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }
   
  constructor(private httpClient: HttpClient) { }
    
  getAll(): Observable<Category[]> {
    return this.httpClient.get<Category[]>(this.apiURL + '/categories/')
    .pipe(
      catchError(this.errorHandler)
    )
  }
    
  create(category:any): Observable<Category> {
    return this.httpClient.post<Category>(this.apiURL + '/categories/', JSON.stringify(category), this.httpOptions)
    .pipe(
      catchError(this.errorHandler)
    )
  }  
    
  find(id:number): Observable<Category> {
    return this.httpClient.get<Category>(this.apiURL + '/categories/' + id)
    .pipe(
      catchError(this.errorHandler)
    )
  }
    
  update(id:number, category:any): Observable<Category> {
    return this.httpClient.put<Category>(this.apiURL + '/categories/' + id, JSON.stringify(category), this.httpOptions)
    .pipe(
      catchError(this.errorHandler)
    )
  }
    
  delete(id:number){
    return this.httpClient.delete<Category>(this.apiURL + '/categories/' + id, this.httpOptions)
    .pipe(
      catchError(this.errorHandler)
    )
  }
     
   
  errorHandler(error:any) {
    let errorMessage = '';
    if(error.error instanceof ErrorEvent) {
      errorMessage = error.error.message;
    } else {
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    return throwError(errorMessage);
 }
}