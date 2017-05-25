import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HomeComponent } from './home.component';
import { FeedComponent } from './feed/feed.component';
import { CreatorComponent } from './creator/creator.component';

@NgModule({
  imports: [
    CommonModule
  ],
  declarations: [HomeComponent, FeedComponent, CreatorComponent]
})
export class HomeModule { }
