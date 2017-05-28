import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {Copypasta} from "../../model/copypasta";

@Component({
  selector: 'app-copypasta',
  templateUrl: './copypasta.component.html',
  styleUrls: ['./copypasta.component.css']
})
export class CopypastaComponent implements OnInit, OnChanges {

  @Input('copypasta') copypasta: Copypasta;

  rating: number;

  constructor() { }

  ngOnInit() {}

  ngOnChanges(changes: SimpleChanges) {
    this.getRating();
  }

  getRating() {
    this.rating = this.copypasta.ratings.map(rating => rating.value).reduce((a, b) => a + b) / this.copypasta.ratings.length;
  }
}
