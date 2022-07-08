import { HealthService } from './../health.service';
import { Health } from './../health.model';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-health-read',
  templateUrl: './health-read.component.html',
  styleUrls: ['./health-read.component.css']
})
export class HealthReadComponent implements OnInit {

  healths: Health[] | any
  displayedColumns = ['id', 'description']
  
  constructor(private healthService: HealthService) { }

  ngOnInit(): void {
      this.healthService.read().subscribe(healths => {
      this.healths = healths
    })
  }

}