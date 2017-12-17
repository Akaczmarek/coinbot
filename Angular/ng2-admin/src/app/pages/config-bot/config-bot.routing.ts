import { Routes, RouterModule } from '@angular/router';
import { ConfigBotComponent } from './config-bot.component';

const routes: Routes = [
  {
    path: '',
    component: ConfigBotComponent
  }
];

export const routing = RouterModule.forChild(routes);