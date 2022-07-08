import { HeaderService } from '../../shared/components/template/header/header.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'

@Component({
  selector: 'health',
  templateUrl: './health.component.html',
  styleUrls: ['./health.component.css']
})
export class HealthCrudComponent implements OnInit {

  constructor(private router: Router, private headerService: HeaderService) {
    headerService.headerData = {
      title: 'Cadastro de Produtos',
      icon: 'storefront',
      routeUrl: 'healths'
    }
  }

  ngOnInit(): void {
  }

  navigateToHealthsCreate(): void {
    this.router.navigate(['/healths/create'])
  }

}