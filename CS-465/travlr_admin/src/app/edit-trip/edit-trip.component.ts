import { Component, OnInit, inject } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ReactiveFormsModule, FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { TripDataService } from '../services/trip-data.service';
import { Trip } from '../models/trip';

@Component({
  selector: 'app-edit-trip',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './edit-trip.component.html',
  styleUrl: './edit-trip.component.css'
})
export class EditTripComponent implements OnInit {
  private fb = inject(FormBuilder);               // ← NEW ANGULAR 14+ WAY – NO CONSTRUCTOR NEEDED
  private route = inject(ActivatedRoute);
  private tripService = inject(TripDataService);
  private router = inject(Router);

  tripCode: string = '';

  editForm = this.fb.group({
    _id: [''],
    code: ['', Validators.required],
    name: ['', Validators.required],
    length: ['', Validators.required],
    start: ['', Validators.required],
    resort: ['', Validators.required],
    perPerson: [0, [Validators.required, Validators.min(1)]],
    image: ['https://picsum.photos/600/400'],
    description: ['', Validators.required]
  });

  ngOnInit(): void {
    this.tripCode = this.route.snapshot.paramMap.get('id') || '';

    this.tripService.getTrip(this.tripCode).subscribe(trip => {
      this.editForm.patchValue({
        code: trip.code,
        name: trip.name,
        length: trip.length,
        start: trip.start ? trip.start.split('T')[0] : '', 
        resort: trip.resort,
        perPerson: trip.perPerson,
        image: trip.image,
        description: trip.description
      });
    });
  }

  onSubmit(): void {
    if (this.editForm.invalid) return;

    const data = this.editForm.getRawValue();

    const updatedTrip: Trip = {
      _id: this.tripCode,
      code: data.code!,
      name: data.name!,
      length: data.length!,
      start: data.start ? data.start.split('T')[0] : '',  // Converts ISO to YYYY-MM-DD for <input type="date">
      resort: data.resort!,
      perPerson: Number(data.perPerson),
      image: data.image!,
      description: data.description!
    };

    this.tripService.updateTrip(updatedTrip).subscribe({
      next: () => this.router.navigate(['/trips']),
      error: () => alert('Update failed')
    });
  }

  cancel() {
    this.router.navigate(['/trips']);
  }
}