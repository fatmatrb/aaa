import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Attribut } from '../models/Attribut';

@Injectable({
  providedIn: 'root'
})
export class AttributService {

  private apiBaseUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }
  

  getAllAttributs(): Observable<Attribut[]> {
    const options = { withCredentials: true };
    return this.http.get<Attribut[]>(`${this.apiBaseUrl}/attributs/All`);
  }

  addAttributsToModule(attribut: Attribut, idModule: number): Observable<Attribut> {
    return this.http.post<Attribut>(`${this.apiBaseUrl}/attributs/AddAttribut/${idModule}`, attribut);
  }

  updateAttribut(attribut: Attribut): Observable<Attribut> {
    const attributId = attribut.idAttribut; // Make sure you have an 'id' property in your Attributs interface
    return this.http.put<Attribut>(`${this.apiBaseUrl}/attributs/UpdateAttribut/${attributId}`, attribut);
  }

  deleteAttribut(id: number): Observable<void> {
    return this.http.delete<void>(`${this.apiBaseUrl}/attributs/deleletAttribut/${id}`);
  }
  
}

