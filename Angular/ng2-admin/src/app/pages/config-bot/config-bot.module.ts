import { NgModule }      from '@angular/core';
import { CommonModule }  from '@angular/common';
import { FormsModule } from '@angular/forms';
import { NgaModule } from '../../theme/nga.module';


import { ConfigBotComponent } from './config-bot.component';
import { routing } from './config-bot.routing';


@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    routing,
    NgaModule
  ],
  declarations: [
    ConfigBotComponent
  ],

})
export class ConfigBotModule {}