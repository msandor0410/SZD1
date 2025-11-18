import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { DashboardComponent } from './pages/dashboard/dashboard.component';
import { AuthGuard } from './auth.guard';

export const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' },
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'dashboard', component: DashboardComponent, canActivate: [AuthGuard] },
  {
  path: 'create-character',
  loadComponent: () => import('./pages/create-character/create-character.component')
    .then(m => m.CreateCharacterComponent)
},
{
  path: 'character/:id',
  loadComponent: () => import('./pages/view-character/view-character.component')
    .then(m => m.ViewCharacterComponent)
},
{
  path: 'character/:id/edit',
  loadComponent: () => import('./pages/edit-character/edit-character.component')
    .then(m => m.EditCharacterComponent)
}
];
