import { Component } from '@angular/core';

@Component({
  selector: 'app-header',
  standalone: true,
  template: `
    <nav style="background: #1e1b4b; padding: 15px; color: #fff; display: flex; gap: 20px;">
      <span style="font-weight: bold; margin-right: auto;">Student Course Portal</span>
      <span>Home</span>
      <span>Courses</span>
      <span>Profile</span>
    </nav>
  `
})
export class HeaderComponent {}