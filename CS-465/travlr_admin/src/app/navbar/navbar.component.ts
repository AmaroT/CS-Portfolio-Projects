import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-navbar',
  standalone: true,
  imports: [CommonModule, RouterLink],           // ← removed RouterLinkActive
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {
  constructor(private authenticationService: AuthenticationService) {}

  isLoggedIn(): boolean {
    return this.authenticationService.isLoggedIn();
  }

  onLogout(): void {
    this.authenticationService.logout();
  }
}