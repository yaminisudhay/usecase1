import { Component, OnInit } from '@angular/core';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { UpdateService } from 'src/app/service/update.service';

@Component({
  selector: 'app-table-details',
  templateUrl: './table-details.component.html',
  styleUrls: ['./table-details.component.css']
})
export class TableDetailsComponent implements OnInit {

  tableName='';
  columnName='';
  uniqueColumn='';

  constructor(private service:UpdateService,private router:Router) { }

  ngOnInit(): void {
    
  }

  manualUpdate(){
    console.log(this.tableName);
    this.router.navigate(
      ['/update',this.tableName,this.columnName]
    )
  }

}
