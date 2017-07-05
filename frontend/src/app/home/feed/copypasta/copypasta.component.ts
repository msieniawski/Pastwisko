import {Component, Input, OnChanges, OnInit, SimpleChanges} from '@angular/core';
import {Copypasta} from "../../../model/copypasta";
import {IStarRatingOnRatingChangeEven} from "angular-star-rating";

@Component({
  selector: 'app-copypasta',
  templateUrl: './copypasta.component.html',
  styleUrls: ['./copypasta.component.css']
})
export class CopypastaComponent implements OnInit, OnChanges {

  @Input('copypasta') copypasta: Copypasta;

  avgRating: number;
  myRating: number;

  constructor() { }

  ngOnInit() {}

  ngOnChanges(changes: SimpleChanges) {
    this.avgRating = this.copypasta.ratings.map(rating => rating.value).reduce((a, b) => a + b) / this.copypasta.ratings.length;
    this.myRating = 0;
  }

  getMyRating(): string {
    return this.myRating === 0 ? "?" : this.myRating.toString();
  }

  onRatingChange = ($event: IStarRatingOnRatingChangeEven) => {
    this.myRating = $event.rating;
  }
}
