import { NgModule } from "@angular/core";
import { Routes, RouterModule } from "@angular/router";
import { HealthCrudComponent } from "./views/health/health.component";

import { HomeComponent } from "./views/home/home.component";


const routes: Routes = [
  {
    path: "",
    component: HomeComponent
  },
  {
    path: "healths",
    component: HealthCrudComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}