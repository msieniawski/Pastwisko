import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { HomeComponent } from './home.component';
import { FeedComponent } from './feed/feed.component';
import { UserProfileComponent } from './user-profile/user-profile.component';
import { CopypastaCreatorComponent } from './copypasta-creator/copypasta-creator.component';
import {HomeRoutingModule} from "./home-routing.module";
import { CopypastaComponent } from './feed/copypasta/copypasta.component';
import {TranslateModule} from "@ngx-translate/core";
import {StarRatingModule} from "angular-star-rating";
import {FormsModule} from "@angular/forms";
import { TagSearchComponent } from './tag-search/tag-search.component';

@NgModule({
  imports: [
    CommonModule,
    HomeRoutingModule,
    TranslateModule,
    StarRatingModule,
    FormsModule
  ],
  declarations: [HomeComponent, FeedComponent, UserProfileComponent, CopypastaCreatorComponent, CopypastaComponent, TagSearchComponent]
})
export class HomeModule { }
