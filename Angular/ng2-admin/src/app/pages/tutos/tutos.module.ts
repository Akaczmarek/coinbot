import { NgModule }      from '@angular/core';
import { CommonModule }  from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NgaModule } from '../../theme/nga.module';


import { TutosComponent } from './tutos.component';
import { routing } from './tutos.routing';


@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    routing,
    NgaModule
  ],
  declarations: [
    TutosComponent
  ],

})
export class TutosModule {}