import {Component, OnInit} from "@angular/core";
import {CopypastaService} from "../../services/copypasta.service";
import {Copypasta} from "../../model/copypasta";
import {TagsService} from "../../services/tags.service";
import {Tag} from "../../model/tag";

@Component({
  selector: 'app-copypasta-creator',
  templateUrl: './copypasta-creator.component.html',
  styleUrls: ['./copypasta-creator.component.css'],
  providers: [CopypastaService, TagsService]
})
export class CopypastaCreatorComponent implements OnInit {

  tags: Tag[];
  selectedTags: Tag[];
  currentTag: string;
  title: string;
  text: string;

  constructor(private copypastaService: CopypastaService, private tagService: TagsService) { }

  ngOnInit() {
    this.getTags();
  }

  getTags() {
    this.tagService.getTags().then(tags => this.tags = tags);
  }

  addCopyPasta() {
    const copypasta = new Copypasta;
    copypasta.title = this.title;
    copypasta.text = this.text;
    this.copypastaService.createCopypasta(copypasta);
  }

  addTag() {
    const tagStream = this.tags.filter(tag => tag.name === this.currentTag);
    if (tagStream.length === 0) {
      const tag = new Tag;
      tag.name = this.currentTag;
      this.tagService.createTag(tag).then(t => this.selectedTags.push(t));
    } else {
      this.selectedTags.push(tagStream.pop());
    }
  }
}
