import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http'
import { GeographyColumn } from '../classes/geography-column';
import { Observable } from 'rxjs';
import { OldNewMap } from '../classes/old-new-map';

@Injectable({
  providedIn: 'root'
})
export class UpdateService {
  

  private geographyUrl:string='http://localhost:8080/api/geography';

  constructor(private httpClient:HttpClient) { }

  getDistinctCityList(tableName:String,columnName:String):Observable<String[]>{
    const url=`${this.geographyUrl}/list?tabName=${tableName}&colName=${columnName}`;
    return this.httpClient.get<String[]>(url);
  }

  updateColValues(tabName: String, colName: String, newList: OldNewMap[]) {
    const url=`${this.geographyUrl}/update/${tabName}/${colName}`;
    return this.httpClient.put(url,newList);
  }
}
