import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  { path: '', redirectTo: 'auth', pathMatch: 'full' },
  { path: 'auth', loadChildren: "./auth/auth.module#AuthModule" },
  { path: 'feed', loadChildren: "./feed/feed.module#FeedModule" },
  { path: 'user', loadChildren: "./user/user.module#UserModule" }
];

@NgModule({
  imports: [ RouterModule.forRoot(routes) ],
  exports: [ RouterModule ]
})
export class AppRoutingModule {}
