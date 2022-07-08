import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";

import { HomeComponent } from "./views/home/home.component";
import { HealthCrudComponent } from "./views/health/health.component";
import { HealthCreateComponent } from "./shared/components/health/health-create/health-create.component";
import { HealthUpdateComponent } from "./shared/components/health/health-update/health-update.component";
import { HealthDeleteComponent } from "./shared/components/health/health-delete/health-delete.component";


const routes: Routes = [
  {
    path: "",
    component: HomeComponent
  },
  {
    path: "healths",
    component: HealthCrudComponent
  },
  {
    path: "healths/create",
    component: HealthCreateComponent
  },
  {
    path: "healths/update/:id",
    component: HealthUpdateComponent
  },
  {
    path: "healths/delete/:id",
    component: HealthDeleteComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}