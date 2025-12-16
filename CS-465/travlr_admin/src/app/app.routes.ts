import { Routes } from '@angular/router';
import { TripListComponent } from './trip-list/trip-list.component';
import { LoginComponent } from './login/login.component';
import { AddTripComponent } from './add-trip/add-trip.component';
import { EditTripComponent } from './edit-trip/edit-trip.component';

export const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' },     
  { path: 'login', component: LoginComponent },
  { path: 'trips', component: TripListComponent },      
  { path: 'add-trip', component: AddTripComponent },
  { path: 'edit-trip/:id', component: EditTripComponent },
  { path: '**', redirectTo: '/login' }
];