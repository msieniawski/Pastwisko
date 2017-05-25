import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeComponent } from './home.component';
import { FeedComponent } from './feed/feed.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { CopypastaCreatorComponent } from './copypasta-creator/copypasta-creator.component';
import {HomeRoutingModule} from "./home-routing.module";

@NgModule({
  imports: [
    CommonModule,
    HomeRoutingModule
  ],
  declarations: [HomeComponent, FeedComponent, UserProfileComponent, CopypastaCreatorComponent]
})
export class HomeModule { }