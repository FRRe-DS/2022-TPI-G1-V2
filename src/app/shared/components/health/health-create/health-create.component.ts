import { Health } from '../health.model';
import { HealthService } from '../health.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-health-create',
  templateUrl: './health-create.component.html',
  styleUrls: ['./health-create.component.css']
})
export class HealthCreateComponent implements OnInit {

  health: Health = {
    id: 0,
    description: '',
  }

  constructor(private healthService: HealthService,
      private router: Router) { }

  ngOnInit(): void {
    
  }

  createHealth(): void {
    this.healthService.create(this.health).subscribe(() => {
      this.healthService.showMessage('Produto criado!')
      this.router.navigate(['/healths'])
    })

  }

  cancel(): void {
    this.router.navigate(['/healths'])
  }
}
