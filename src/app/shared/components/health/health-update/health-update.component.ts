import { Health } from "./../health.model";
import { Router, ActivatedRoute } from "@angular/router";
import { HealthService } from "./../health.service";
import { Component, OnInit } from "@angular/core";

@Component({
  selector: "app-health-update",
  templateUrl: "./health-update.component.html",
  styleUrls: ["./health-update.component.css"],
})
export class HealthUpdateComponent implements OnInit {
  health: Health|any;

  constructor(
    private healthService: HealthService,
    private router: Router,
    private route: ActivatedRoute
  ) {}

  ngOnInit(): void {
    const id = Number(this.route.snapshot.paramMap.get("id"));
    this.healthService.readById(id).subscribe((health) => {
      this.health = health;
    });
  }

  updateHealth(): void {
    this.healthService.update(this.health).subscribe(() => {
      this.healthService.showMessage("Produto atualizado com sucesso!");
      this.router.navigate(["/healths"]);
    });
  }

  cancel(): void {
    this.router.navigate(["/healths"]);
  }
}
