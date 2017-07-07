import {Component, EventEmitter, OnInit, Output} from '@angular/core';
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

  constructor(private tagService: TagsService) { }

  ngOnInit() {
    this.getTags();
  }

  getTags() {
    this.tagService.getTags().then(tags => this.tags = tags);
  }

  selectTag(tag: string) {
    const tagStream = this.tags.filter(t => t.name === tag);
    if (tagStream.length === 0) {
      const newTag = new Tag;
      newTag.name = tag;
      this.tagService.createTag(newTag).then(t => this.tagSelected.emit(t));
    } else {
      this.tagSelected.emit(tagStream.pop());
    }
  }
}
