import { Component, Input, Output, EventEmitter } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Router } from '@angular/router'; 
import { Trip } from '../models/trip';

@Component({
  selector: 'app-trip-card',
  standalone: true,
  imports: [CommonModule],       
  templateUrl: './trip-card.component.html',
  styleUrls: ['./trip-card.component.css']     
})
export class TripCardComponent {
  @Input() trip!: Trip;
  @Output() delete = new EventEmitter<string>();

  constructor(private router: Router) {}

  edit() {
    this.router.navigate(['/edit-trip', this.trip.code]);
  }
}