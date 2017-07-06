import { Component, OnInit } from '@angular/core';

import { CopypastaService } from '../../services/copypasta.service';
import { Copypasta } from "../../model/copypasta";
import {Tag} from "../../model/tag";

@Component({
  selector: 'app-feed',
  templateUrl: './feed.component.html',
  styleUrls: ['./feed.component.css'],
  providers: [CopypastaService]
})
export class FeedComponent implements OnInit {

  copypastas: Copypasta[];

  constructor(private copypastaService: CopypastaService) { }

  getCopypastas(): void {
    this.copypastaService.getAllCopypastas().then(copypastas => { this.copypastas = copypastas; });
  }

  ngOnInit() {
    this.getCopypastas();
  }

  addTagToFilter(tag: Tag) {

  }

  removeTagFromFilter(tag: Tag) {

  }
}
