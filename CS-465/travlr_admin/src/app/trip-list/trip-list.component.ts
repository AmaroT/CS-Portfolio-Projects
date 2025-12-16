// src/app/trip-list/trip-list.component.ts
import { Component, OnInit, ChangeDetectorRef } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router';
import { TripCardComponent } from '../trip-card/trip-card.component';
import { TripDataService } from '../services/trip-data.service';
import { AuthenticationService } from '../services/authentication.service';
import { Trip } from '../models/trip';

@Component({
  selector: 'app-trip-list',
  imports: [CommonModule, TripCardComponent],
  templateUrl: './trip-list.component.html',
  styleUrls: ['./trip-list.component.css'],
  providers: [TripDataService]
})


export class TripListComponent implements OnInit {
  trips: Trip[] = [];
  message: string = '';

  constructor(
    private tripService: TripDataService,
    private authenticationService: AuthenticationService,
    private router: Router,
    private cdr: ChangeDetectorRef        
  ) {}

  ngOnInit(): void {
    this.loadTrips();
  }

  loadTrips(): void {
    this.tripService.getTrips().subscribe({
      next: (data) => {
        this.trips = data;
        this.cdr.detectChanges();       
        console.log('Cards loaded:', this.trips.length);
      },
      error: (err) => {
        console.error('Failed to load trips:', err);
      }
    });
  }

  goToAdd(): void {
    this.router.navigate(['/add']);
  }

  onTripDeleted(code: string): void {
    if (confirm('Delete this trip permanently?')) {
      this.tripService.deleteTrip(code).subscribe({
        next: () => {
          this.trips = this.trips.filter(t => t.code !== code);
          console.log('Trip deleted from database');
        },
        error: (err) => {
          console.error('Delete failed:', err);
          alert('Could not delete trip — check console');
          // Still remove from UI so it feels responsive
          this.trips = this.trips.filter(t => t.code !== code);
        }
      });
      
    }
  }
  public isLoggedIn(): boolean {
    return this.authenticationService.isLoggedIn();
  }
}