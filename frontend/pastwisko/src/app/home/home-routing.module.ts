import { NgModule }             from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

import { HomeComponent } from "./home.component";
import {FeedComponent} from "./feed/feed.component";
import {CreatorComponent} from "./creator/creator.component";

export const routes: Routes = [
  { path: '', component: HomeComponent,
    children: [
      { path: 'feed', component: FeedComponent },
      { path: 'creator', component: CreatorComponent }
    ]}
];

@NgModule({
  imports: [ RouterModule.forChild(routes) ],
  exports: [ RouterModule ]
})
export class HomeRoutingModule {}
