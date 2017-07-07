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

  ngOnInit() {
    this.getCopypastas();
  }

  filterByTag(tag: Tag) {
    this.getCopypastasByTag(tag);
  }

  getCopypastas(): void {
    this.copypastaService.getAllCopypastas().then(copypastas => { this.copypastas = copypastas; });
  }

  getCopypastasByTag(tag: Tag): void {
    this.copypastaService.getByTag(tag.id).then(copypastas => { this.copypastas = copypastas; });
  }
}
