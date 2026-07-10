import { Component } from '@angular/core';
import { HeaderComponent } from './components/header/header.component';
import { HomeComponent } from './pages/home/home.component';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [HeaderComponent, HomeComponent],
  template: `
    <app-header></app-header>
    <app-home></app-home>
  `
})
export class AppComponent {
  title = 'student-course-portal';
}