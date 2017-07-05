import { Component, OnInit } from '@angular/core';

import { CopypastaService } from '../../services/copypasta.service';
import { Copypasta } from "../../model/copypasta";

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
    this.copypastaService.getCopypastas().then(copypastas => { this.copypastas = copypastas; });
  }

  ngOnInit() {
    this.getCopypastas();
  }

}
