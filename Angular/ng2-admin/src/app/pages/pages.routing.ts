import { Routes, RouterModule } from '@angular/router';
import { Pages } from './pages.component';
import { ModuleWithProviders } from '@angular/core';
// noinspection TypeScriptValidateTypes

// export function loadChildren(path) { return System.import(path); };

export const routes: Routes = [
  {
    path: 'login',
    loadChildren: 'app/pages/login/login.module#LoginModule'
  },
  {
    path: 'register',
    loadChildren: 'app/pages/register/register.module#RegisterModule'
  },
  {
    path: 'pages',
    component: Pages,
    children: [
      { path: '', redirectTo: 'accueil', pathMatch: 'full' },
      { path: 'supervision', loadChildren: './supervision/supervision.module#SupervisionModule' },
      { path: 'accueil', loadChildren: './accueil/accueil.module#AccueilModule' },
      { path: 'config-bot', loadChildren: './config-bot/config-bot.module#ConfigBotModule' },
      { path: 'tutos', loadChildren: './tutos/tutos.module#TutosModule' }
    ]
  }
];

export const routing: ModuleWithProviders = RouterModule.forChild(routes);
