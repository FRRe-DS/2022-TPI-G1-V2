import { Health } from './../health.model';
import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTable } from '@angular/material/table';
import { HealthRead2DataSource } from './health-read2-datasource';

@Component({
  selector: 'app-health-read2',
  templateUrl: './health-read2.component.html',
  styleUrls: ['./health-read2.component.css']
})
export class HealthRead2Component implements AfterViewInit, OnInit {
  @ViewChild(MatPaginator) paginator: MatPaginator | any;
  @ViewChild(MatSort) sort: MatSort | any;
  @ViewChild(MatTable) table: MatTable<Health> | any;
  dataSource: HealthRead2DataSource | any;

  /** Columns displayed in the table. Columns IDs can be added, removed, or reordered. */
  displayedColumns = ['id', 'description'];

  ngOnInit() {
    this.dataSource = new HealthRead2DataSource();
  }

  ngAfterViewInit() {
    this.dataSource.sort = this.sort;
    this.dataSource.paginator = this.paginator;
    this.table.dataSource = this.dataSource;
  }
}
