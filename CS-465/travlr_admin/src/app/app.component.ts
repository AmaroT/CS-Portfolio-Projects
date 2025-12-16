import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet],
  template: `
    <div class="min-vh-100 bg-light">
      <nav class="navbar navbar-dark bg-primary mb-4">
        <div class="container">
          <span class="navbar-brand mb-0 h1">Travlr Getaways Admin</span>
        </div>
      </nav>
      <router-outlet></router-outlet>
    </div>
  `,
  styles: []
})
export class AppComponent { }