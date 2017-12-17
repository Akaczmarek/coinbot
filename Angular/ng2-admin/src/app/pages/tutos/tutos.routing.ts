import { Routes, RouterModule } from '@angular/router';
import { TutosComponent } from './tutos.component';

const routes: Routes = [
  {
    path: '',
    component: TutosComponent
  }
];

export const routing = RouterModule.forChild(routes);