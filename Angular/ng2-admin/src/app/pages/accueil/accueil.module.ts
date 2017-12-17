import { NgModule }      from '@angular/core';
import { CommonModule }  from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NgaModule } from '../../theme/nga.module';


import { AccueilComponent } from './accueil.component';
import { routing } from './accueil.routing';


@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    routing,
    NgaModule
  ],
  declarations: [
    AccueilComponent
  ],

})
export class AccueilModule {}