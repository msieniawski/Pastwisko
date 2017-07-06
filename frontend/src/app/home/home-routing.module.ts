import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from "./home.component";
import { FeedComponent } from "./feed/feed.component";
import { UserProfileComponent } from "./user-profile/user-profile.component";
import { CopypastaCreatorComponent } from "./copypasta-creator/copypasta-creator.component";
import {AuthGuard} from "../auth/auth-guard/auth.guard";

export const routes: Routes = [
  { path: '', component: HomeComponent,
    children: [
      { path: 'feed', component: FeedComponent },
      { path: 'creator', component: CopypastaCreatorComponent, canActivate: [AuthGuard]},
      { path: 'profile/:username', component: UserProfileComponent, canActivate: [AuthGuard]},
      { path: 'auth', redirectTo: '/auth/login', pathMatch: 'full' },
      { path: '', redirectTo: 'feed', pathMatch: 'full' },
      { path: '**', redirectTo: 'feed', pathMatch: 'full' }
    ]}
];

@NgModule({
  imports: [ RouterModule.forChild(routes) ],
  exports: [ RouterModule ]
})
export class HomeRoutingModule {}
