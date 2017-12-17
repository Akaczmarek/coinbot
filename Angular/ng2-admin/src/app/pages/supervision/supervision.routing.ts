import { Routes, RouterModule } from '@angular/router';
import { SupervisionComponent } from './supervision.component';

const routes: Routes = [
  {
    path: '',
    component: SupervisionComponent
  }
];

export const routing = RouterModule.forChild(routes);