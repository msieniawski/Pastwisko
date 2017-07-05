import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from "./home.component";
import { FeedComponent } from "./feed/feed.component";
import { UserProfileComponent } from "./user-profile/user-profile.component";
import { CopypastaCreatorComponent } from "./copypasta-creator/copypasta-creator.component";

export const routes: Routes = [
  { path: '', component: HomeComponent,
    children: [
      { path: 'feed', component: FeedComponent },
      { path: 'creator', component: CopypastaCreatorComponent },
      { path: 'profile/:username', component: UserProfileComponent },
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
