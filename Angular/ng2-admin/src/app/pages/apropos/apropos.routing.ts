import { Routes, RouterModule } from '@angular/router';
import { AproposComponent } from './apropos.component';

const routes: Routes = [
  {
    path: '',
    component: AproposComponent
  }
];

export const routing = RouterModule.forChild(routes);