import {Component, EventEmitter, OnInit, Output} from "@angular/core";
import {TagsService} from "../../services/tags.service";
import {Tag} from "../../model/tag";

@Component({
  selector: 'app-tag-search',
  templateUrl: './tag-search.component.html',
  styleUrls: ['./tag-search.component.css'],
  providers: [TagsService]
})
export class TagSearchComponent implements OnInit {

  @Output() tagSelected = new EventEmitter();

  private tags: Tag[];
  protected tagNames: string[];
  protected tag: string;

  constructor(private tagService: TagsService) { }

  ngOnInit() {
    this.getTags();
  }

  getTags() {
    this.tagService.getTags().then(tags => {
      this.tags = tags;
      this.tagNames = tags.map(t => t.name);
    });
  }

  selectTag() {
    const tagStream = this.tags.filter(t => t.name === this.tag);
    if (tagStream.length === 0) {
      const newTag = new Tag;
      newTag.name = this.tag.startsWith("#") ? this.tag : "#" + this.tag;
      this.tagService.createTag(newTag).then(t => this.tagSelected.emit(t));
    } else {
      this.tagSelected.emit(tagStream.pop());
    }
    this.tag = "";
  }
}
