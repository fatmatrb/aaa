import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Module } from '../models/Module';

@Injectable({
  providedIn: 'root'
})
export class ModuleService {

  private apiBaseUrl = environment.apiBaseUrl;

constructor(private http: HttpClient){}

  getAllModules(): Observable<Module[]> {
    const options = { withCredentials: true };
    return this.http.get<Module[]>(`${this.apiBaseUrl}/modules`);
  }

  getModuleById(id: number): Observable<Module> {
    const options = { withCredentials: true };
    return this.http.get<Module>(`${this.apiBaseUrl}/modules/${id}`);
  }

  createModule(module: Module): Observable<Module> {
    const options = { withCredentials: true };
    return this.http.post<Module>(`${this.apiBaseUrl}/modules/AddModule`, module);
  }

  deleteModule(id: number): Observable<void> {
    const options = { withCredentials: true };
    return this.http.delete<void>(`${this.apiBaseUrl}/modules/DeleteModule/${id}`);
  }
}
