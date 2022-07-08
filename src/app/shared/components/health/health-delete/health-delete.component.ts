import { Router, ActivatedRoute } from "@angular/router";
import { HealthService } from "../health.service";
import { Health } from "../health.model";
import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-health-delete",
  templateUrl: "./health-delete.component.html",
  styleUrls: ["./health-delete.component.css"],
})
export class HealthDeleteComponent implements OnInit {
  health: Health | any;

  constructor(
    private healthService: HealthService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.healthService.readById(id).subscribe((health) => {
      this.health = health;
    });
  }

  deleteHealth(): void {
    this.healthService.delete(this.health.id).subscribe(() => {
      this.healthService.showMessage("Produto excluido com sucesso!");
      this.router.navigate(["/healths"]);
    });
  }

  cancel(): void {
    this.router.navigate(["/healths"]);
  }
}
