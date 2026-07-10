import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  standalone: true,
  template: `
    <div style="padding: 20px; color: #333;">
      <h1>Welcome to the Student Course Portal</h1>
      <p>Manage your courses, view schedules, and keep track of your performance.</p>
      <div style="display: flex; gap: 30px; margin-top: 20px;">
        <div style="background: #f3f4f6; padding: 15px; border-radius: 8px;">
          <strong>Courses Available:</strong> 12
        </div>
        <div style="background: #f3f4f6; padding: 15px; border-radius: 8px;">
          <strong>Enrolled:</strong> 3
        </div>
        <div style="background: #f3f4f6; padding: 15px; border-radius: 8px;">
          <strong>GPA:</strong> 3.8
        </div>
      </div>
    </div>
  `
})
export class HomeComponent {}