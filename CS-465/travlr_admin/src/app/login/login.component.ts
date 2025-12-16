import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthenticationService } from '../services/authentication.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule, FormsModule],     // ← FormsModule is REQUIRED
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  email: string = '';
  password: string = '';
  formError: string = '';

  constructor(
    private router: Router,
    private authenticationService: AuthenticationService
  ) {}

  onLoginSubmit(): void {
    console.log('Sign In button clicked!');     // ← you will see this in console

    this.formError = '';

    if (!this.email || !this.password) {
      this.formError = 'Both email and password are required';
      return;
    }

    // Your User interface only has email + name → we only send that
    const userForLogin = {
      email: this.email,
      name: ''                         // required by User interface, but not used for login
    };

    this.authenticationService.login(userForLogin, this.password).subscribe({
      next: () => {
        console.log('Login successful, redirecting...');
        this.router.navigate(['/trips']);
      },
      error: (err) => {
        console.error('Login failed:', err);
        this.formError = err?.error?.message || 'Invalid email or password';
      }
    });
  }
}