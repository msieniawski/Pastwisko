import {Component, OnInit} from "@angular/core";
import {CopypastaService} from "../../services/copypasta.service";
import {Copypasta} from "../../model/copypasta";
import {Tag} from "../../model/tag";

@Component({
  selector: 'app-copypasta-creator',
  templateUrl: './copypasta-creator.component.html',
  styleUrls: ['./copypasta-creator.component.css'],
  providers: [CopypastaService]
})
export class CopypastaCreatorComponent implements OnInit {

  private tags: Tag[];
  private title: string;
  private text: string;

  constructor(private copypastaService: CopypastaService) { }

  ngOnInit() {
    this.tags = [];
  }

  addCopyPasta() {
    const copypasta = new Copypasta;
    copypasta.title = this.title;
    copypasta.text = this.text;
    copypasta.tags = this.tags;
    copypasta.creationDate = new Date;
    this.copypastaService.createCopypasta(copypasta);
  }

  addTag(tag: Tag) {
    this.tags.push(tag);
  }
}
