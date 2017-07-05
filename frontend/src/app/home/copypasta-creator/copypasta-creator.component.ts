import { Component, OnInit } from '@angular/core';
import {CopypastaService} from "../../services/copypasta.service";
import {Copypasta} from "../../model/copypasta";

@Component({
  selector: 'app-copypasta-creator',
  templateUrl: './copypasta-creator.component.html',
  styleUrls: ['./copypasta-creator.component.css'],
  providers: [CopypastaService]
})
export class CopypastaCreatorComponent implements OnInit {

  title: string;
  text: string;

  constructor(private copypastaService: CopypastaService) { }

  ngOnInit() {
  }

  addCopyPasta() {
    const copypasta = new Copypasta;
    copypasta.title = this.title;
    copypasta.text = this.text;
    this.copypastaService.createCopypasta(copypasta);
  }
}
