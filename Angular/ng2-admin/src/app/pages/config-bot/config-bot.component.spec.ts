import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ConfigBotComponent } from './config-bot.component';

describe('ConfigBotComponent', () => {
  let component: ConfigBotComponent;
  let fixture: ComponentFixture<ConfigBotComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ConfigBotComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ConfigBotComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
