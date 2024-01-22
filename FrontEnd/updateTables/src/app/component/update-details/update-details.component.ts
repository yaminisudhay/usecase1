import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { OldNewMap } from 'src/app/classes/old-new-map';
import { UpdateService } from 'src/app/service/update.service';

@Component({
  selector: 'app-update-details',
  templateUrl: './update-details.component.html',
  styleUrls: ['./update-details.component.css']
})
export class UpdateDetailsComponent implements OnInit {

  newList:OldNewMap[]=[];
  tabName:String='';
  colName:String='';
  constructor(private service:UpdateService,private route:ActivatedRoute) { }

  ngOnInit(): void {
    this.tabName = this.route.snapshot.paramMap.get('tabName')!;
    this.colName = this.route.snapshot.paramMap.get('colName')!;
    console.log(this.tabName+" "+this.colName);
    this.service.getDistinctCityList(this.tabName,this.colName).subscribe(
      data=> this.newList=data.map(each => new OldNewMap(each,''))
    );
  }

  updateDetails():void{

    console.log("update called");
    
    this.service.updateColValues(this.tabName,this.colName,this.newList.filter(e=>e.newName.trim() !='')).subscribe(
      sdata=> {
        this.service.getDistinctCityList(this.tabName,this.colName).subscribe(
          data=> this.newList=data.map(each => new OldNewMap(each,''))
        );
      }
    );
    
    
  }

}
