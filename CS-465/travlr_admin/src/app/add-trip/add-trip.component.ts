import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { TripDataService } from '../services/trip-data.service';
import { Trip } from '../models/trip';

@Component({
  selector: 'app-add-trip',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './add-trip.component.html',
  styleUrl: './add-trip.component.css'
})
export class AddTripComponent {
  private fb = new FormBuilder();

  constructor(
    private tripService: TripDataService,
    public router: Router
  ) {}

  addForm = this.fb.group({
    code: ['', Validators.required],                   
    name: ['', Validators.required],
    length: ['', Validators.required],
    start: ['', Validators.required],                  
    resort: ['', Validators.required],
    perPerson: [0, [Validators.required, Validators.min(1)]],
    image: ['https://picsum.photos/600/400'],
    description: ['', Validators.required]
  });

  onSubmit() {
    if (this.addForm.valid) {
      const trip = this.addForm.getRawValue() as Trip;
      this.tripService.addTrip(trip).subscribe({
        next: () => this.router.navigate(['/trips']),  // ← Better destination
        error: (err) => alert('Add failed: ' + (err.error?.message || err.message))
      });
    }
  }
}